## **`ReentrantLock` в Java: Потокобезопасная альтернатива `synchronized`**

`ReentrantLock` — это класс из пакета `java.util.concurrent.locks`, который предоставляет **гибкий механизм блокировки** потоков, аналогичный `synchronized`, но с дополнительными возможностями.

---

## **1. Зачем нужен `ReentrantLock`?**

🔹 В Java для обеспечения потокобезопасности традиционно используют `synchronized`:

```java
public synchronized void method() {
    // Код, к которому доступ ограничен
}
```

Но `synchronized` имеет **ограниченную функциональность**:

- **Нет тайм-аута**: нельзя задать время ожидания блокировки.
- **Нет возможности прервать ожидание блокировки**.
- **Нельзя проверить, удерживает ли поток блокировку**.
- **Блокировка освобождается только при выходе из метода**.

📌 **Решение:** использовать `ReentrantLock`, который дает **больше контроля над блокировками**.

---

## **2. Как работает `ReentrantLock`?**

🔹 Основные методы:

|Метод|Описание|
|---|---|
|`lock()`|Захватывает блокировку (если занята – поток ждет)|
|`unlock()`|Освобождает блокировку|
|`tryLock()`|Пытается захватить блокировку, НЕ ожидая, если она занята|
|`tryLock(timeout, TimeUnit)`|Пытается захватить блокировку в течение заданного времени|
|`lockInterruptibly()`|Захватывает блокировку, но можно прервать поток|
|`isLocked()`|Проверяет, удерживает ли кто-то блокировку|
|`isHeldByCurrentThread()`|Проверяет, удерживает ли текущий поток блокировку|

---

## **3. Пример: Использование `ReentrantLock`**

```java
import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private final ReentrantLock lock = new ReentrantLock();

    public void doWork() {
        lock.lock(); // Захватываем блокировку
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет работу...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // Обязательно освобождаем блокировку
        }
    }
}

public class ReentrantLockExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Runnable task = resource::doWork;

        Thread t1 = new Thread(task, "Поток 1");
        Thread t2 = new Thread(task, "Поток 2");

        t1.start();
        t2.start();
    }
}
```

### **Выходные данные (пример)**

```
Поток 1 выполняет работу...
Поток 2 выполняет работу...
```

👉 `t2` ждет, пока `t1` освободит `lock`.

---

## **4. Особенности `ReentrantLock`**

### **🔹 4.1. Реентерабельность (Reentrancy)**

🔹 **"Reentrant" означает, что поток, который уже владеет блокировкой, может захватить ее повторно**.

📌 **Пример с `synchronized` (работает реентерабельно):**

```java
public synchronized void outerMethod() {
    innerMethod(); // Нет блокировки, потому что тот же поток
}

public synchronized void innerMethod() {
    // Код
}
```

📌 **То же самое с `ReentrantLock`**:

```java
import java.util.concurrent.locks.ReentrantLock;

class ReentrantExample {
    private final ReentrantLock lock = new ReentrantLock();

    public void outerMethod() {
        lock.lock();
        try {
            System.out.println("Внешний метод");
            innerMethod(); // Тот же поток может снова заблокировать lock
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod() {
        lock.lock();
        try {
            System.out.println("Внутренний метод");
        } finally {
            lock.unlock();
        }
    }
}
```

✅ **Один и тот же поток может захватывать `lock` несколько раз** без блокировки.

---

### **🔹 4.2. `tryLock()` – попытка захватить блокировку без ожидания**

Используем, если не хотим **блокировать поток** на неопределенное время.

```java
if (lock.tryLock()) {
    try {
        System.out.println("Блокировка получена!");
    } finally {
        lock.unlock();
    }
} else {
    System.out.println("Блокировка занята, поток продолжает выполнение...");
}
```

🔹 Если блокировка **занята**, поток просто выполняет альтернативную логику.

---

### **🔹 4.3. `tryLock(timeout, TimeUnit)` – ожидание блокировки с тайм-аутом**

Можно установить **время ожидания блокировки**.

```java
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockWithTimeout {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> tryToLock("Поток 1"));
        Thread t2 = new Thread(() -> tryToLock("Поток 2"));

        t1.start();
        t2.start();
    }

    private static void tryToLock(String name) {
        try {
            if (lock.tryLock(2, TimeUnit.SECONDS)) { // Ждем 2 секунды
                try {
                    System.out.println(name + " получил блокировку!");
                    Thread.sleep(3000);
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(name + " не смог получить блокировку!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

### **Выходные данные (пример)**

```
Поток 1 получил блокировку!
Поток 2 не смог получить блокировку!
```

✅ **Если поток не получает блокировку за 2 секунды, он продолжает выполнение без ожидания.**

---

### **🔹 4.4. `lockInterruptibly()` – можно прервать ожидание блокировки**

Если поток застрял в ожидании `lock.lock()`, его **нельзя прервать**.  
Но если используем **`lockInterruptibly()`**, поток **можно прервать во время ожидания**.

```java
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyExample {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly(); // Можно прервать ожидание
                try {
                    System.out.println("Поток 1 получил блокировку!");
                    Thread.sleep(5000);
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                System.out.println("Поток 1 был прерван во время ожидания блокировки!");
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                t1.interrupt(); // Прерываем t1
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
```

### **Выходные данные**

```
Поток 1 был прерван во время ожидания блокировки!
```

✅ Поток 1 ожидал `lock`, но `t2` его **прервал**.

---

## **5. Вывод**

✅ `ReentrantLock` дает **гибкость и больше контроля**, чем `synchronized`.  
✅ Позволяет **проверять состояние блокировки (`isLocked()`)**, **использовать таймаут (`tryLock()`)**, **прерывать ожидание (`lockInterruptibly()`)**.  
✅ **Реентерабелен** – поток может захватить блокировку повторно.  
❌ **Нужно вручную вызывать `unlock()`**, иначе возможен deadlock.

📌 **Когда использовать `ReentrantLock` вместо `synchronized`?**

- Если нужна **гибкость (`tryLock()`, `lockInterruptibly()`)**.
- Если блокировка **будет долго удерживаться**.
- Если нужен **таймаут** при захвате блокировки.
