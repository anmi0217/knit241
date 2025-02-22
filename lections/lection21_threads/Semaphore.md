# **📌 `Semaphore` в Java**
### **Что такое `Semaphore`?**
🔹 `Semaphore` (Семафор) – это механизм, который **ограничивает количество потоков, имеющих доступ к ресурсу**.

📌 **Применяется в многопоточных задачах, где есть ограниченные ресурсы**, например:
✔ Ограниченное количество подключений к серверу.  
✔ Контроль за количеством машин на заправке.  
✔ Регулирование доступа к базе данных.

---

## **🔹 Основные методы `Semaphore`**
| Метод | Описание |
|-----------------|-------------------------------------------|
| `acquire()` | Захватывает 1 разрешение (если нет – ждет). |
| `acquire(int permits)` | Захватывает несколько разрешений. |
| `tryAcquire()` | Захватывает разрешение, но не ждет (возвращает `false`, если нет доступных). |
| `release()` | Освобождает 1 разрешение (увеличивает семафор). |
| `release(int permits)` | Освобождает несколько разрешений. |
| `availablePermits()` | Показывает, сколько разрешений доступно. |

---

## **🔹 Пример 1: Ограничение доступа к ресурсу**
📌 **Условие:**  
У нас есть **3 рабочих места**, но **5 потоков** пытаются их занять.

```java
import java.util.concurrent.*;

class Worker extends Thread {
    private final Semaphore semaphore;
    private final String name;

    public Worker(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(); // Захват разрешения
            System.out.println(name + " начал работу.");
            Thread.sleep(2000); // Симуляция работы
            System.out.println(name + " завершил работу.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Освобождение разрешения
        }
    }
}

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3); // Разрешаем только 3 потока одновременно

        for (int i = 1; i <= 5; i++) {
            new Worker(semaphore, "Рабочий " + i).start();
        }
    }
}
```

### **📌 Вывод (пример)**
```
Рабочий 1 начал работу.
Рабочий 2 начал работу.
Рабочий 3 начал работу.
(2 секунды)
Рабочий 1 завершил работу.
Рабочий 4 начал работу.
Рабочий 2 завершил работу.
Рабочий 5 начал работу.
```
✅ **Только 3 потока работают одновременно!** Остальные **ждут**, пока кто-то освободит место.

---

### **2️⃣ Альтернативное решение: Библиотека (Ограниченное количество книг)** 📚
**🔹 Условие:**
- В библиотеке есть **3 книги**.
- **Студенты** пытаются взять книгу.
- Если книг **нет**, студенты **ждут**.
- Когда книга **возвращается**, следующий студент может взять её.

```java
import java.util.concurrent.*;

class Library {
    private final Semaphore books;

    public Library(int availableBooks) {
        this.books = new Semaphore(availableBooks);
    }

    public void borrowBook(String student) {
        try {
            System.out.println(student + " 📖 ждет книгу...");
            books.acquire(); // Ждет, если книг нет
            System.out.println(student + " 📚 взял книгу и читает...");
            Thread.sleep(3000); // Имитация чтения
            System.out.println(student + " 📖 вернул книгу в библиотеку.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            books.release(); // Освобождаем книгу
        }
    }
}

public class LibraryDemo {
    public static void main(String[] args) {
        Library library = new Library(3); // 3 доступные книги

        for (int i = 1; i <= 5; i++) {
            final String student = "Студент " + i;
            new Thread(() -> library.borrowBook(student)).start();
        }
    }
}
```

### **📌 Вывод**
```
Студент 1 📖 ждет книгу...
Студент 2 📖 ждет книгу...
Студент 3 📖 ждет книгу...
Студент 1 📚 взял книгу и читает...
Студент 2 📚 взял книгу и читает...
Студент 3 📚 взял книгу и читает...
(3 секунды)
Студент 1 📖 вернул книгу в библиотеку.
Студент 4 📚 взял книгу и читает...
Студент 2 📖 вернул книгу в библиотеку.
Студент 5 📚 взял книгу и читает...
```
✅ **Максимум 3 студента читают одновременно!** Остальные **ждут, пока кто-то вернет книгу**.

📌 **Такой вариант подходит для моделирования реальной ситуации, где ресурсы (книги) ограничены. 🚀**

## **🔹 Пример 3: `tryAcquire()` (не ждет)**
📌 **Условие:**  
Если ресурс недоступен – поток **не ждет**, а выполняет другое действие.

```java
import java.util.concurrent.*;

public class TryAcquireExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        Runnable task = () -> {
            if (semaphore.tryAcquire()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " получил доступ.");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + " освобождает ресурс.");
                    semaphore.release();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " не получил доступ и выполняет другую задачу.");
            }
        };

        for (int i = 1; i <= 4; i++) {
            new Thread(task, "Поток " + i).start();
        }
    }
}
```

### **📌 Вывод**
```
Поток 1 получил доступ.
Поток 2 получил доступ.
Поток 3 не получил доступ и выполняет другую задачу.
Поток 4 не получил доступ и выполняет другую задачу.
(3 секунды)
Поток 1 освобождает ресурс.
Поток 2 освобождает ресурс.
```
✅ **Если `tryAcquire()` не может захватить семафор – поток выполняет что-то другое.**

---

## **🔹 Пример 4: `release(int permits)`**
📌 **Условие:**  
Разрешаем сразу **2 потока** вместо одного.

```java
import java.util.concurrent.*;

public class ReleaseExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);

        Runnable task = () -> {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " выполняет работу.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(task, "Поток 1").start();
        new Thread(task, "Поток 2").start();

        try {
            Thread.sleep(2000);
            System.out.println("Разрешаем двум потокам работать.");
            semaphore.release(2); // Освобождаем сразу 2 потока
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

### **📌 Вывод**
```
Разрешаем двум потокам работать.
Поток 1 выполняет работу.
Поток 2 выполняет работу.
```
✅ **Оба потока начинают работать одновременно, так как `release(2)` сразу освобождает два разрешения.**

---

## **📌 Вывод**
✔ `Semaphore` **ограничивает количество потоков, имеющих доступ к ресурсу**.  
✔ Используется в **базах данных, серверных системах, многопоточности**.  
✔ `acquire()` – **ждет разрешение**, `tryAcquire()` – **не ждет**.  
✔ `release()` – освобождает ресурс, можно освободить несколько (`release(2)`).
