

---

#### **1. Подключение к базе данных через JDBC**

##### **Добавление зависимости в `pom.xml` (для Maven)**

Для подключения к PostgreSQL через JDBC необходимо добавить зависимость в ваш файл `pom.xml` (если используется Maven):

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.6.0</version>
</dependency>
```

Эта зависимость подключает драйвер PostgreSQL, который необходим для работы с базой данных через JDBC.

##### **Код для подключения к базе данных**

Для установления соединения с базой данных PostgreSQL используем класс `DriverManager`. Вот пример кода для подключения:

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres"; // URL базы данных
        String user = "postgres";  // Имя пользователя
        String password = "secret"; // Пароль

        // Устанавливаем соединение с базой данных
        return DriverManager.getConnection(url, user, password);
    }
}
```

Здесь:

- `url`: строка подключения к базе данных PostgreSQL (используется локальный сервер с портом `5432`).
- `user` и `password`: учетные данные для подключения к базе данных.

---

#### **2. Создание DAO (Data Access Object)**

**DAO** — это шаблон проектирования, который используется для абстракции и инкапсуляции всех операций с данными (создание, чтение, обновление и удаление) и взаимодействия с базой данных.

##### **Интерфейс для CRUD операций**

Создаем интерфейс, который будет описывать методы для выполнения CRUD операций:

```java
import java.util.List;

public interface MedicineDAO {
    void createMedicine(Medicine medicine); // Создание нового лекарства
    Medicine getMedicineById(int id); // Получение лекарства по ID
    List<Medicine> getAllMedicines(); // Получение списка всех лекарств
    void updateMedicine(Medicine medicine); // Обновление информации о лекарстве
    void deleteMedicine(int id); // Удаление лекарства по ID
}
```

**Описание методов**:

- `createMedicine(Medicine medicine)`: добавляет новое лекарство в базу данных.
- `getMedicineById(int id)`: извлекает лекарство по его ID.
- `getAllMedicines()`: извлекает все лекарства из базы.
- `updateMedicine(Medicine medicine)`: обновляет данные о лекарстве.
- `deleteMedicine(int id)`: удаляет лекарство по его ID.

##### **Модель данных (Entity Class)**

Пример класса `Medicine`, который будет использоваться для представления данных о лекарствах:

```java
import java.math.BigDecimal;
import java.time.LocalDate;

public class Medicine {
    private int id;
    private String name;
    private BigDecimal price;
    private LocalDate expirationDate;

    // Конструкторы, геттеры и сеттеры
    public Medicine(String name, BigDecimal price, LocalDate expirationDate) {
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
```

---

#### **3. Реализация методов DAO**

Теперь давайте реализуем методы интерфейса `MedicineDAO`. Используем `PreparedStatement` для безопасных SQL запросов.

##### **Добавление нового лекарства**

Метод для добавления нового лекарства в базу данных:

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicineDAOImpl implements MedicineDAO {
    private Connection connection;

    public MedicineDAOImpl() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void createMedicine(Medicine medicine) {
        String sql = "INSERT INTO medicines (name, price, expiration_date) VALUES (?, ?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, medicine.getName());
            statement.setBigDecimal(2, medicine.getPrice());
            statement.setDate(3, java.sql.Date.valueOf(medicine.getExpirationDate())); // Преобразуем LocalDate в SQL Date
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Medicine getMedicineById(int id) {
        // Реализация метода для получения лекарства по ID
        return null;
    }

    @Override
    public List<Medicine> getAllMedicines() {
        // Реализация метода для получения всех лекарств
        return null;
    }

    @Override
    public void updateMedicine(Medicine medicine) {
        // Реализация метода для обновления информации о лекарстве
    }

    @Override
    public void deleteMedicine(int id) {
        // Реализация метода для удаления лекарства по ID
    }
}
```

##### **Использование PreparedStatement**

- `PreparedStatement` используется для выполнения параметризованных SQL запросов, что предотвращает SQL инъекции и улучшает производительность.
- Мы передаем параметры в запрос через методы `setString()`, `setBigDecimal()`, `setDate()`.

---

#### **4. Тестирование CRUD операций**

Напишем небольшой код для тестирования CRUD операций.

```java
public class Main {
    public static void main(String[] args) throws SQLException {
        MedicineDAO medicineDAO = new MedicineDAOImpl();

        // Создание нового лекарства
        Medicine medicine = new Medicine("Aspirin", BigDecimal.valueOf(5.99), LocalDate.of(2025, 12, 31));
        medicineDAO.createMedicine(medicine);

        // Тестирование других методов DAO (getMedicineById, getAllMedicines, updateMedicine, deleteMedicine)
    }
}
```

---

