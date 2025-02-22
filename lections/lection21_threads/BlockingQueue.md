## **Что такое `BlockingQueue` в Java?**

### **📌 Определение**

`BlockingQueue` – это **потокобезопасная очередь**, которая:

- **Ожидает** при попытке взять элемент, если очередь пуста.
- **Ожидает** при попытке положить элемент, если очередь заполнена.

🚀 `BlockingQueue` отлично подходит для **многопоточных программ**, особенно для **производитель-потребитель (Producer-Consumer)**.

---

## **🔹 Основные методы `BlockingQueue`**

|Метод|Описание|
|---|---|
|`put(E e)`|Добавляет элемент. Если очередь заполнена – ждет.|
|`take()`|Убирает элемент. Если очередь пуста – ждет.|
|`offer(E e)`|Пытается добавить, но не ждет (возвращает `false`, если нет места).|
|`poll()`|Пытается взять элемент, но не ждет (возвращает `null`, если пусто).|
|`poll(long timeout, TimeUnit unit)`|Пытается взять элемент, но ждет `timeout`.|
|`remainingCapacity()`|Возвращает количество свободных мест в очереди.|

> **`put()` и `take()` – блокируют поток, `offer()` и `poll()` – нет.**

---

## **🔹 Реализации `BlockingQueue`**

### 1️⃣ **`LinkedBlockingQueue<E>`**

- **Размер можно задать (`new LinkedBlockingQueue<>(10)`) или оставить бесконечным.**
- Работает на **двух блокировках** (для чтения и записи), что делает её эффективной.
- **Часто используется для многопоточных задач.**

```java
BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);
```

### 2️⃣ **`ArrayBlockingQueue<E>`**

- **Фиксированный размер (`new ArrayBlockingQueue<>(10)`)**.
- Основана на массиве (быстрее, чем `LinkedBlockingQueue` в некоторых случаях).
- **Лучше для задач с предсказуемым количеством элементов.**

```java
BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
```

### 3️⃣ **`PriorityBlockingQueue<E>`**

- Элементы **упорядочены** (по `Comparable` или `Comparator`).
- Подходит, если важен порядок обработки задач.

```java
BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
```

### 4️⃣ **`DelayQueue<E>`**

- Хранит **элементы с отложенным временем обработки**.
- Элементы можно забирать **только после истечения таймера**.
- Используется для **таймеров, задач с отложенным выполнением**.

```java
BlockingQueue<Delayed> queue = new DelayQueue<>();
```

---

## **🔹 Пример: Производитель и потребитель**

Программа, где **производитель кладет числа в очередь**, а **потребитель их обрабатывает**.

```java
import java.util.concurrent.*;

class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Производитель кладет: " + i);
                queue.put(i); // Ждет, если очередь заполнена
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer item = queue.take(); // Ждет, если очередь пуста
                System.out.println("Потребитель забрал: " + item);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);

        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}
```

### **📌 Вывод**

```
Производитель кладет: 1
Потребитель забрал: 1
Производитель кладет: 2
Производитель кладет: 3
Производитель кладет: 4
Потребитель забрал: 2
Производитель кладет: 5
Потребитель забрал: 3
```

✅ **Производитель ждет, если очередь заполнена**.  
✅ **Потребитель ждет, если очередь пуста**.

---

## **🔹 Когда использовать `BlockingQueue`?**

✔ Если нужна **безопасная передача данных** между потоками.  
✔ Если **производитель и потребитель работают с разной скоростью**.  
✔ Если важно **ограничить очередь** (например, `ArrayBlockingQueue(5)`).  
✔ В **многопоточных задачах**, где потоки должны **ожидать данные** без `while(true)`.

---

## **🔹 Итог**

✅ `BlockingQueue` – потокобезопасная очередь, которая **блокирует поток при необходимости**.  
✅ `put()` и `take()` **ожидают**, если очередь переполнена или пуста.  
✅ Подходит для **производитель-потребитель**, обработки задач и многопоточных приложений.