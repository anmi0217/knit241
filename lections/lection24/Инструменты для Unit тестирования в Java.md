---

### **3. Инструменты для Unit тестирования в Java**

Java предоставляет множество инструментов для написания и выполнения Unit тестов. Основные из них — **JUnit**, **Mockito** и **Hamcrest**.

---

#### **3.1. JUnit (Версия 4.12)**
**JUnit** — это самый распространённый фреймворк для написания Unit тестов в Java.

---

##### **Основные аннотации JUnit**
- `@Test`: Указывает, что метод является тестом.
- `@Before`: Выполняется перед каждым тестом. Используется для настройки общего состояния (инициализация объектов и пр.).
- `@After`: Выполняется после каждого теста. Применяется для очистки ресурсов.
- `@BeforeClass`: Выполняется один раз перед всеми тестами. Используется для инициализации ресурсов, которые не нужно пересоздавать перед каждым тестом.
- `@AfterClass`: Выполняется один раз после завершения всех тестов. Применяется для освобождения ресурсов.
- `@Ignore`: Игнорирует выполнение теста (временное отключение теста).

---

##### **Основные методы утверждений (assert)**
JUnit предоставляет набор методов для проверки условий. Самые популярные:

```java
assertEquals(expected, actual);        // Проверка равенства значений
assertTrue(condition);                 // Проверка истинности условия
assertFalse(condition);                // Проверка ложности условия
assertNull(object);                    // Проверка на null
assertNotNull(object);                 // Проверка на не null
assertSame(expected, actual);          // Проверка, что объекты ссылаются на одно и то же место в памяти
assertNotSame(expected, actual);       // Проверка, что объекты не ссылаются на одно и то же место в памяти
```

---

##### **Пример использования JUnit**
```java
import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();  // Создание нового экземпляра перед каждым тестом
    }

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));  // Проверка корректного результата сложения
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        calculator.divide(5, 0);  // Проверка, что метод выбрасывает исключение
    }

    @After
    public void tearDown() {
        calculator = null;  // Очистка ресурсов
    }
}
```

---

#### **3.2. Mockito (Основы мокирования)**
**Mockito** — библиотека для создания **мок-объектов** и тестирования взаимодействий между компонентами.

---

##### **Основные аннотации Mockito**
- `@Mock`: Создание мок-объектов.
- `@InjectMocks`: Внедрение моков в тестируемый объект.
- `@Captor`: Используется для захвата аргументов, передаваемых в мок-объекты.
- `MockitoAnnotations.initMocks(this);`: Инициализация мок-объектов.

---

##### **Основные методы Mockito**
- `when()`: Настройка поведения мок-объекта.
- `verify()`: Проверка, что метод был вызван с определёнными параметрами.
- `doThrow()`: Настройка мок-объекта для генерации исключений.
- `reset()`: Сброс мок-объектов.

---

##### **Пример использования Mockito**
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
        MockitoAnnotations.initMocks(this);  // Инициализация моков
    }

    @Test
    public void testGetUserNameById() {
        User user = new User(1, "Алиса");
        when(repository.findById(1)).thenReturn(user);  // Настройка поведения мок-объекта

        String result = userService.getUserNameById(1);

        assertEquals("Алиса", result);
        verify(repository).findById(1);  // Проверка вызова метода findById
    }
}
```

---

#### **3.3. Hamcrest (Кратко)**
Hamcrest — библиотека для создания удобочитаемых утверждений. Используется совместно с JUnit.

---

##### **Примеры утверждений Hamcrest**
```java
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

assertThat("Hello World", containsString("World"));
assertThat(5, is(5));
assertThat(Arrays.asList("Java", "Python", "C++"), hasItem("Java"));
```

---


### **3.4. Установка библиотек и настройка проекта**

---

#### **Установка JUnit и Mockito с помощью Maven и Gradle**

Сначала нужно подключить библиотеки **JUnit** и **Mockito** к вашему проекту. Рассмотрим оба варианта: **Maven** и **Gradle**.

---

#### ✅ **Настройка Maven (pom.xml)**
Если вы используете Maven, нужно добавить зависимости в файл **pom.xml**:

```xml
<dependencies>
    <!-- JUnit 4.12 -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
    
    <!-- Mockito -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>3.12.4</version>
        <scope>test</scope>
    </dependency>
    
    <!-- Hamcrest (входит в JUnit, но можно подключить отдельно для дополнительных матчеров) -->
    <dependency>
        <groupId>org.hamcrest</groupId>
        <artifactId>hamcrest-core</artifactId>
        <version>1.3</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

#### ✅ **Настройка Gradle (build.gradle)**
Если проект использует Gradle, добавьте зависимости в файл **build.gradle**:

```groovy
dependencies {
    // JUnit 4.12
    testImplementation 'junit:junit:4.12'
    
    // Mockito
    testImplementation 'org.mockito:mockito-core:3.12.4'
    
    // Hamcrest (необязательно, если используете стандартные матчера JUnit)
    testImplementation 'org.hamcrest:hamcrest-core:1.3'
}
```

---

#### 📁 **Структура Maven/Gradle проекта для тестов**

```
📂 my-java-project/
├── 📂 src/
│   ├── 📂 main/
│   │   └── 📂 java/          (Код программы)
│   └── 📂 test/
│       └── 📂 java/          (Код тестов)
├── 📄 pom.xml                (для Maven)
├── 📄 build.gradle           (для Gradle)
```

---

#### 💡 **Запуск тестов**

- **IntelliJ IDEA:**
    - Нажмите правой кнопкой мыши на папке `src/test/java/` и выберите **Run 'All Tests'**.
    - Или запустите отдельные тесты через кнопку запуска рядом с методом.

- **Командная строка (Maven):**
```bash
mvn test
```

- **Командная строка (Gradle):**
```bash
gradle test
```

---

#### 📊 **Отчёты о тестировании**
- Maven и Gradle автоматически создают отчёты о выполнении тестов.
- **Maven:** Отчёты создаются в каталоге `target/surefire-reports/`.
- **Gradle:** Отчёты можно найти в `build/reports/tests/test/`.

---

