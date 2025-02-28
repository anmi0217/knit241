## **2. Модификатор volatile в Java**

### **Что делает `volatile`?**

`volatile` — это специальный модификатор, который гарантирует, что **изменения переменной будут немедленно видны всем потокам**. Он решает проблему **кеширования переменных** в многопоточной среде.

В многопоточной среде переменные могут храниться не только в **основной памяти (main memory)**, но и в **кешах процессоров**. Это приводит к тому, что изменения, сделанные одним потоком, могут **не быть видны другим потокам**.

❌ **Проблема без `volatile`**

```java
class SharedData {
    private boolean running = true; // Без volatile

    public void stop() {
        running = false; // Изменение может быть не видно в другом потоке
    }

    public void run() {
        while (running) {
            // Возможен бесконечный цикл, если running не обновляется
        }
    }
}
```

**Почему?**  
Другой поток может читать `running` **из кэша процессора**, а не из памяти. Поэтому он может **не увидеть изменения** и зациклиться.

✅ **Решение:** использовать `volatile`

```java
private volatile boolean running = true;
```

Теперь любое изменение `running` **сразу записывается в память** и становится **видимым для всех потоков**.

---

### **Обеспечение видимости изменений переменной между потоками**

Когда переменная объявлена как `volatile`:

1. **Чтение всегда происходит из основной памяти** (а не из кэша процессора).
2. **Запись сразу обновляет значение в основной памяти**.

📌 **Пример работы без volatile:**

```java
class SharedResource {
    private boolean flag = false; // Без volatile

    public void setTrue() {
        flag = true;
    }

    public boolean getFlag() {
        return flag;
    }
}

public class VolatileTest {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        Thread writer = new Thread(() -> {
            resource.setTrue();
            System.out.println("Writer: flag set to true");
        });

        Thread reader = new Thread(() -> {
            while (!resource.getFlag()) {
                // Может зациклиться, если не увидит обновление
            }
            System.out.println("Reader: flag changed!");
        });

        reader.start();
        Thread.sleep(100);
        writer.start();

        reader.join();
        writer.join();
    }
}
```

👉 Здесь поток `reader` может **не увидеть изменения `flag`** и зависнуть в бесконечном цикле.

✅ **Используем `volatile`**

```java
private volatile boolean flag = false;
```

Теперь после `resource.setTrue()` другой поток **гарантированно увидит изменение**.

---

### **Гарантия порядка операций (Happens-Before)**

В Java **операции могут переставляться** для оптимизации (Instruction Reordering). `volatile` предотвращает эту перестановку.

Пример:

```java
class ReorderingExample {
    int a = 0, b = 0, x = 0, y = 0;

    public void thread1() {
        a = 1;   // (1)
        x = b;   // (2)
    }

    public void thread2() {
        b = 1;   // (3)
        y = a;   // (4)
    }
}
```

Логично ожидать, что `x == 1 || y == 1`, но **без volatile возможен x == 0 и y == 0** из-за перестановки команд.

✅ **Используем `volatile` для корректного порядка**

```java
private volatile int a = 0;
private volatile int b = 0;
```

Теперь **порядок выполнения инструкций гарантирован**.

---

### **Ограничения `volatile`**

#### ❌ **1. Не обеспечивает атомарности сложных операций**

`volatile` **не делает операцию атомарной**, если она состоит из нескольких шагов.

Пример с `i++`:

```java
class Counter {
    private volatile int count = 0;

    public void increment() {
        count++; // Не атомарно!
    }
}
```

Почему? `count++` это:

1. Чтение `count`
2. Увеличение `count`
3. Запись `count`

Если два потока выполняют `count++` одновременно, возможна **потеря инкремента**.

✅ **Решение:** использовать `AtomicInteger`

```java
private AtomicInteger count = new AtomicInteger(0);

public void increment() {
    count.incrementAndGet(); // Атомарно!
}
```

---

#### ❌ **2. Не подходит для синхронизации нескольких переменных**

`volatile` гарантирует **целостность только одной переменной**. Если требуется изменение **нескольких зависимых переменных**, нужно использовать `synchronized` или `Lock`.

Проблема:

```java
class SharedData {
    private volatile int x = 0;
    private volatile int y = 0;

    public void update() {
        x = 1;
        y = 2;
    }

    public boolean check() {
        return y == 2 && x == 0; // Может случиться!
    }
}
```

Так как **`volatile` не обеспечивает атомарность нескольких переменных**, другой поток может увидеть `y = 2`, но `x = 0`.

✅ **Решение:** использовать `synchronized`

```java
synchronized (this) {
    x = 1;
    y = 2;
}
```

---

### **Примеры использования `volatile`**

#### ✅ **1. Флаг остановки потока**

Частый случай — **безопасный останов потока**.

❌ Без `volatile`, поток может **не увидеть изменения** переменной и не остановиться.

```java
class Worker implements Runnable {
    private volatile boolean running = true;

    public void stop() {
        running = false;
    }

    public void run() {
        while (running) {
            System.out.println("Working...");
        }
        System.out.println("Stopped.");
    }
}

public class VolatileFlagExample {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        Thread thread = new Thread(worker);
        thread.start();

        Thread.sleep(100);
        worker.stop(); // Без volatile поток может не увидеть изменение running!
    }
}
```

Теперь `running = false;` **сразу увидит** второй поток, и он завершится.

---

#### ✅ **2. Двойная проверка (Double-Checked Locking)**

Используется для создания **потокобезопасного синглтона** без лишней синхронизации.

❌ Без `volatile` возможны проблемы: поток может увидеть **частично инициализированный объект**.

✅ **Используем `volatile`**

```java
class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) { // Первая проверка без блокировки
            synchronized (Singleton.class) {
                if (instance == null) { // Вторая проверка с блокировкой
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

Благодаря `volatile` гарантируется, что **инициализация полностью завершится** перед тем, как `instance` станет доступен другим потокам.

---

