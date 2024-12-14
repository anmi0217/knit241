#  Лабораторная работа № 11

## Цель работы:
- Научиться подключаться к Базе данных
- Научиться выполнять простые DDL и DML запросы
- Научиться работать с JDBC 
- Научиться реализовывать CRUD операции используя паттерн DAO

### **24. Реализация CRUD через командную строку** *

**Задача:**  
Реализовать консольное приложение, которое:
1. Позволяет пользователю вводить команды для добавления, удаления, просмотра и обновления пользователей.
2. Использует паттерн DAO для работы с базой данных.
3. Реализует бизнес-логику в классе `UserService`.

---

### **Описание функциональности**
1. **Команды для управления пользователями через консоль:**
    - `add [name] [email]` — добавляет нового пользователя, если email уникален.
    - `list` — выводит список всех пользователей.
    - `delete [id]` — удаляет пользователя по ID.
    - `update [id] [new_name] [new_email]` — обновляет имя и email пользователя.
    - `exit` — завершает выполнение программы.

2. **Валидация:**
    - Проверка на уникальность email перед добавлением.
    - Проверка существования пользователя перед удалением и обновлением.

---

### **Требуемые классы**

#### **1. Интерфейс `UserDAO`**
Содержит методы:
```java
public interface UserDAO {
    void create(User user) throws SQLException;
    User findById(int id) throws SQLException;
    List<User> findAll() throws SQLException;
    void update(User user) throws SQLException;
    void delete(int id) throws SQLException;
    boolean emailExists(String email) throws SQLException;
}
```

#### **2. Класс `UserDAOImpl`**
Реализация методов интерфейса `UserDAO` с использованием JDBC.

#### **3. Класс `DatabaseConnection`**
Singleton для управления подключением к базе данных.
```java
public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/your_database";
    private static final String USER = "your_user";
    private static final String PASSWORD = "your_password";
    private static Connection connection;

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}
```

#### **4. Класс `UserService`**
Содержит бизнес-логику, взаимодействует с `UserDAO`.  
Методы:
- `registerUser(String name, String email)` — проверяет уникальность email, добавляет пользователя.
- `listAllUsers()` — возвращает список пользователей.
- `deleteUser(int id)` — удаляет пользователя.
- `updateUser(int id, String newName, String newEmail)` — обновляет данные пользователя.

#### **5. Класс `User`**
POJO с полями `id`, `name`, `email` и соответствующими геттерами и сеттерами.

Пример DDL-запроса для создания таблицы `users` и вставки тестовых данных:

```sql
-- Создание таблицы users
CREATE TABLE users (
    id SERIAL PRIMARY KEY,             -- Уникальный идентификатор пользователя
    name VARCHAR(100) NOT NULL,        -- Имя пользователя
    email VARCHAR(100) NOT NULL UNIQUE -- Email пользователя, уникальное значение
);

-- Вставка тестовых данных
INSERT INTO users (name, email) VALUES
('John Doe', 'john.doe@example.com'),
('Jane Smith', 'jane.smith@example.com'),
('Alice Johnson', 'alice.johnson@example.com'),
('Bob Brown', 'bob.brown@example.com'),
('Charlie White', 'charlie.white@example.com');
```

### Описание:
1. **Таблица `users`:**
    - `id` — первичный ключ, автоматически увеличивается (`SERIAL`).
    - `name` — имя пользователя, строка до 100 символов, не может быть пустой.
    - `email` — email пользователя, строка до 100 символов, должно быть уникальным и не может быть пустым.

2. **Тестовые данные:**  
   В таблицу добавлено 5 пользователей с уникальными именами и email-адресами.

----

----


### **Задача 25: Создание консольного приложения для сохранения файлов в базу данных** **

**Описание:**

Необходимо создать консольное приложение, которое принимает на вход путь к папке или файлу, и сохраняет все файлы размером менее 10 MB в базу данных. В базе данных создается таблица, в которой хранятся имена файлов и их содержимое в виде бинарных данных.

---

### **Шаги выполнения:**

1. **Создание таблицы в базе данных:** 

Создайте таблицу в базе данных PostgreSQL (или другой СУБД) для хранения файлов. Таблица должна содержать следующие поля:
- `id` — уникальный идентификатор файла.
- `file_name` — имя файла.
- `file_binary` — бинарное содержимое файла.

**DDL для таблицы:**

```sql
CREATE TABLE files (
    id SERIAL PRIMARY KEY,
    file_name VARCHAR(255) NOT NULL,
    file_binary BYTEA NOT NULL
);
```

- **`id`** — поле с автоинкрементом для уникальности записей.
- **`file_name`** — имя файла, которое будет сохранено в базе данных.
- **`file_binary`** — поле для хранения бинарных данных файла в формате BYTEA.

2. **Консольное приложение:**

Консольное приложение должно выполнить следующие действия:
- Получить путь к файлу или папке от пользователя.
- Проверить размер каждого файла (если он меньше 10 MB).
- Сохранить файлы в таблицу базы данных, включая имя и содержимое файла в бинарном формате.

---

### **Пример реализации:**

#### 1. **Класс `DatabaseConnection`:**

Для управления подключением к базе данных.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "sa";

    private static Connection connection;

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}
```

#### 2. **Класс `FileDAO`:**

Для сохранения файла в базу данных.

```java
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileDAO {

    private static final String INSERT_FILE_SQL = "INSERT INTO files (file_name, file_binary) VALUES (?, ?)";

    public void saveFile(File file) throws SQLException, IOException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_FILE_SQL)) {

            statement.setString(1, file.getName());  // Имя файла

            // Чтение содержимого файла в бинарный формат
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] fileBytes = new byte[(int) file.length()];
                fis.read(fileBytes);
                statement.setBytes(2, fileBytes);  // Содержимое файла в формате BYTEA
            }

            statement.executeUpdate();  // Выполняем запрос на добавление
        }
    }
}
```

#### 3. **Главный класс `FileApp`:**

Для получения пути от пользователя и запуска обработки.

```java
import java.util.Scanner;

public class FileApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу или папке: ");
        String path = scanner.nextLine();

        FileProcessor processor = new FileProcessor();
        processor.processFiles(path);
    }
}
```

---

### **Запуск приложения:**

1. Скомпилируйте все классы.
2. Запустите класс `FileApp`.
3. Введите путь к папке или файлу, и приложение сохранит все файлы размером менее 10 MB в базу данных.

### Дополнительное задание:
Внесем изменения в приложение, чтобы добавить следующие функции:
В консоли ввести list —> выводит список файлов с их названиями и ID из базы данных.
В консоли ввести saveLocal [id] — сохраняет файл из БД по [id] в локальную папку текущего проекта.
