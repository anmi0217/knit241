# Лабораторная работа № 8
### Задача Сериализация № 13

#### **Описание задачи:**
Создайте приложение, которое сохраняет информацию о пользователях в файл и позволяет восстанавливать её при следующем запуске программы.

#### **Требования:**
1. Создать класс `User`, который содержит:
    - Имя пользователя (строка).
    - Возраст (целое число).
    - Email (строка).
2. Реализовать возможность сериализации и десериализации объектов класса `User`:
    - Сериализация сохраняет список пользователей в файл.
    - Десериализация восстанавливает список пользователей из файла.
3. Программа должна предоставить пользователю следующий функционал:
    - Добавить нового пользователя.
    - Показать список всех пользователей.
    - Сохранить список в файл.
    - Загрузить список из файла.
4. Если файл с пользователями отсутствует, программа должна корректно обрабатывать это исключение и начинать с пустого списка.
5. Программа должна завершаться без потери данных (данные сохраняются в файл перед выходом).

---

#### **Пример работы программы:**
```
Добро пожаловать в систему управления пользователями!
Выберите действие:
1. Добавить нового пользователя
2. Показать всех пользователей
3. Сохранить список пользователей в файл
4. Загрузить список пользователей из файла
5. Выйти

Введите номер действия: 1
Введите имя пользователя: Alice
Введите возраст: 25
Введите email: alice@example.com
Пользователь добавлен.

Введите номер действия: 2
Список пользователей:
1. Имя: Alice, Возраст: 25, Email: alice@example.com

Введите номер действия: 3
Список успешно сохранён в файл.

Введите номер действия: 4
Список успешно загружен из файла.

Введите номер действия: 5
Программа завершена. До свидания!
```

---

#### **Подсказки для реализации:**

1. **Класс `User`:**
```java
import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private String email;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Возраст: " + age + ", Email: " + email;
    }
}
```

2. **Основная логика программы:**
    - Используйте `ArrayList<User>` для хранения пользователей.
    - Для сериализации и десериализации используйте `ObjectOutputStream` и `ObjectInputStream`.

3. **Методы для сериализации и десериализации:**
```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static final String FILE_NAME = "users.ser";

    public static void saveUsers(List<User> users) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);
        }
    }

    public static List<User> loadUsers() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<User>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
```

4. **Основной класс с меню:**
   Реализуйте меню с использованием цикла `while` и методов для добавления пользователей, сохранения и загрузки данных.

---

#### **Расширенные требования (по желанию):**
- Добавить возможность поиска пользователя по имени.
- Реализовать удаление пользователя из списка.
- Использовать валидацию ввода (например, проверка формата email).