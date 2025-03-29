### **4. Написание Unit тестов (Практика)**

---

#### **4.1. Пример тестируемого класса - Calculator**
Создадим простой класс `Calculator` с базовыми методами для арифметических операций.

📄 **Calculator.java**
```java
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Деление на ноль запрещено.");
        }
        return a / b;
    }
}
```

---

#### **4.2. Написание Unit тестов с использованием JUnit**
Создадим тестовый класс для проверки методов `Calculator`.

📄 **CalculatorTest.java**
```java
import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator(); // Инициализация перед каждым тестом
    }

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3)); // Проверка сложения
    }

    @Test
    public void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3)); // Проверка вычитания
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3)); // Проверка умножения
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        calculator.divide(5, 0); // Проверка выброса исключения при делении на ноль
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(6, 3)); // Проверка деления
    }

    @After
    public void tearDown() {
        calculator = null; // Очистка ресурсов после теста
    }
}
```

---

#### **4.3. Использование Mockito для мокирования зависимостей**
Теперь создадим пример, где мы используем **Mockito** для имитации поведения зависимостей.

📄 **User.java (Пример модели данных)**

```java
public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
```

---

📄 **UserRepository.java (Пример интерфейса репозитория)**

```java
public interface UserRepository {
    User findById(int id);
}
```

---

📄 **UserService.java (Класс, который будем тестировать)**

```java
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String getUserNameById(int userId) {
        User user = repository.findById(userId);
        if (user != null) {
            return user.getName();
        }
        return "Пользователь не найден";
    }
}
```

---

#### **4.4. Написание Unit тестов с использованием Mockito**
Создадим тест для `UserService`, используя **Mockito**.

📄 **UserServiceTest.java**
```java
import org.junit.*;
import org.mockito.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Инициализация моков
    }

    @Test
    public void testGetUserNameById_UserExists() {
        User user = new User(1, "Алиса");
        
        when(repository.findById(1)).thenReturn(user);  // Настраиваем поведение мок-объекта

        String result = userService.getUserNameById(1);

        assertEquals("Алиса", result);
        verify(repository).findById(1); // Проверка вызова метода findById
    }

    @Test
    public void testGetUserNameById_UserNotFound() {
        when(repository.findById(2)).thenReturn(null);

        String result = userService.getUserNameById(2);

        assertEquals("Пользователь не найден", result);
        verify(repository).findById(2);
    }
}
```

---

#### **4.5. Комбинирование JUnit и Mockito**
- JUnit используется для написания тестов и проверки результатов.
- Mockito используется для создания мок-объектов и проверки взаимодействия с ними.
- Тесты могут комбинировать функциональные проверки (JUnit) и поведенческие проверки (Mockito).

---
