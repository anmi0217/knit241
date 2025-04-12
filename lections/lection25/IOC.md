## 🧠 **3. Inversion of Control (IoC) и контейнер Spring**

---

### 📘 Что такое Inversion of Control (IoC)?

> **IoC** — это принцип, при котором ты **не сам создаёшь зависимости**, а отдаёшь это на управление **внешней системе**.

В контексте Spring — это означает:
- Ты **не создаёшь объекты вручную через `new`**
- Spring сам **создаёт, связывает и управляет** объектами, которые ты описал

Это противоположно классическому стилю программирования, где ты управляешь всем вручную.

---

### 🔧 Пример без IoC (вручную):

```java
UserRepository repo = new UserRepository();
UserService service = new UserService(repo);
```

Ты сам создаёшь и связываешь зависимости.

---

### 🌱 Пример с IoC (Spring):

```java
@Component
public class UserRepository {}

@Service
public class UserService {
    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }
}
```

Теперь ты **только описал зависимости**, а Spring их **внедрит сам**, когда создаст `UserService`.

---

## 🧰 Как работает Spring IoC контейнер

Контейнер Spring'а — это хранилище объектов (бинов), которые он:
1. Создаёт
2. Настраивает
3. Связывает между собой (внедряет зависимости)
4. Управляет их жизненным циклом

Сам контейнер реализуется через интерфейс:

```java
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
```

---

### 💡 Что происходит при запуске?

1. Spring читает конфигурацию (`@Configuration`, `@ComponentScan`, XML)
2. Находит классы с аннотациями (`@Component`, `@Bean`, и т.д.)
3. Создаёт объекты (бины)
4. Связывает их зависимости
5. Готовит их к использованию

---

### 🧱 Виды контейнеров

| Контейнер         | Описание                                      |
|-------------------|-----------------------------------------------|
| `BeanFactory`     | Базовый контейнер, ленивая инициализация      |
| `ApplicationContext` | Расширенный контейнер, чаще используется   |
| `WebApplicationContext` | Контейнер для веб-приложений          |

---

### 🔄 Пример использования IoC:

```java
@Configuration
@ComponentScan("com.example")
public class AppConfig {}

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService service = context.getBean(UserService.class);
        service.register("Alice");
    }
}
```

---

### ✅ Вывод:

- IoC — это **передача контроля** от разработчика к Spring-контейнеру
- Ты больше **не создаёшь зависимости вручную**
- Это делает код **модульным, тестируемым и гибким**

---
