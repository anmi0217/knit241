

#### **1. [Введение в JDBC и базы данных.md](%D0%92%D0%B2%D0%B5%D0%B4%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%B2%20JDBC%20%D0%B8%20%D0%B1%D0%B0%D0%B7%D1%8B%20%D0%B4%D0%B0%D0%BD%D0%BD%D1%8B%D1%85.md)**

- **Что такое JDBC**:
    - Java Database Connectivity — API для работы с реляционными базами данных.
    - Роль драйверов JDBC.
    - Абстракция JDBC: интерфейсы `Connection`, `Statement`, `ResultSet` и их реализация драйверами.
- **Краткий обзор баз данных**:
    - Что такое реляционные базы данных.
    - Основные понятия: таблицы, строки, столбцы, первичные и внешние ключи.
    - Примеры популярных СУБД: PostgreSQL, MySQL, Oracle.
- **Архитектура взаимодействия с базами**:
    - Клиент-серверная модель.
    - Зачем нужен JDBC, если есть ORM.

---

#### **2. [Поднятие базы данных PostgreSQL через Docker.md](%D0%9F%D0%BE%D0%B4%D0%BD%D1%8F%D1%82%D0%B8%D0%B5%20%D0%B1%D0%B0%D0%B7%D1%8B%20%D0%B4%D0%B0%D0%BD%D0%BD%D1%8B%D1%85%20PostgreSQL%20%D1%87%D0%B5%D1%80%D0%B5%D0%B7%20Docker.md)

- **Настройка PostgreSQL в Docker**:
    - Команда для запуска контейнера:
        
        ```bash
        docker run --name postgres-db -e POSTGRES_PASSWORD=secret -p 5432:5432 -d postgres
        ```
        
    - Объяснение ключей: `-e` (переменные окружения), `-p` (проброс порта), `-d` (фоновый режим).
- **Проверка работы базы**:
    - Подключение к базе с помощью утилиты `psql` (или других инструментов).

---

#### **3. [Подключение к базе через DBeaver.md](%D0%9F%D0%BE%D0%B4%D0%BA%D0%BB%D1%8E%D1%87%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%BA%20%D0%B1%D0%B0%D0%B7%D0%B5%20%D1%87%D0%B5%D1%80%D0%B5%D0%B7%20DBeaver.md)

- **Установка DBeaver**:
    - Краткая инструкция по установке и настройке.
- **Подключение к PostgreSQL**:
    - Добавление нового соединения.
    - Ввод параметров подключения: хост, порт, имя пользователя, пароль.
- **Обзор интерфейса DBeaver**:
    - Как работать с таблицами, запускать SQL-запросы и просматривать результаты.

---

#### **4. [Создание таблицы. DDL и DML запросы.md](%D0%A1%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%20%D1%82%D0%B0%D0%B1%D0%BB%D0%B8%D1%86%D1%8B.%20DDL%20%D0%B8%20DML%20%D0%B7%D0%B0%D0%BF%D1%80%D0%BE%D1%81%D1%8B.md)

- **DDL (Data Definition Language)**:
    - Создание таблицы для хранения данных о препаратах:
        
        ```sql
        CREATE TABLE medicines (
            id SERIAL PRIMARY KEY,
            name VARCHAR(100),
            price DECIMAL(10, 2),
            expiration_date DATE
        );
        ```
        
    - Объяснение команд `CREATE`, `ALTER`, `DROP`.
- **DML (Data Manipulation Language)**:
    - Добавление данных:
        
        ```sql
        INSERT INTO medicines (name, price, expiration_date)
        VALUES ('Aspirin', 5.99, '2025-12-31');
        ```
        
    - Обновление, удаление и выборка данных:
        
        ```sql
        UPDATE medicines SET price = 6.99 WHERE name = 'Aspirin';
        DELETE FROM medicines WHERE id = 1;
        SELECT * FROM medicines;
        ```
        

---

#### **5. [Реализация CRUD операций в Java.md](%D0%A0%D0%B5%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D1%8F%20CRUD%20%D0%BE%D0%BF%D0%B5%D1%80%D0%B0%D1%86%D0%B8%D0%B9%20%D0%B2%20Java.md)

- **Подключение к базе данных через JDBC**:
    
    - Добавление зависимости в `pom.xml` (для Maven):
        
        ```xml
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.6.0</version>
        </dependency>
        ```
        
    - Код для подключения:
        
        ```java
        Connection connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/postgres",
            "postgres",
            "secret"
        );
        ```
        
- **Создание DAO (Data Access Object)**:
    
    - Интерфейс для CRUD операций:
        
        ```java
        public interface MedicineDAO {
            void createMedicine(Medicine medicine);
            Medicine getMedicineById(int id);
            List<Medicine> getAllMedicines();
            void updateMedicine(Medicine medicine);
            void deleteMedicine(int id);
        }
        ```
        
    - Реализация методов:
        - Вставка:
            
            ```java
            String sql = "INSERT INTO medicines (name, price, expiration_date) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, medicine.getName());
            statement.setBigDecimal(2, medicine.getPrice());
            statement.setDate(3, Date.valueOf(medicine.getExpirationDate()));
            statement.executeUpdate();
            ```
            
        - Выборка, обновление и удаление с использованием `PreparedStatement`.
- **Тестирование CRUD операций**:
    
    - Написание тестов для каждого метода DAO.
    - Демонстрация вывода результатов в консоль.

---

#### **6. Завершение**

- **Обсуждение преимуществ и недостатков JDBC**:
    - Преимущества: гибкость, прямой доступ к SQL.
    - Недостатки: сложность управления ресурсами, ручная обработка исключений.
