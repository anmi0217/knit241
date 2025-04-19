### 1. 📌 [Что такое Spring?](%D1%87%D1%82%D0%BE%20%D1%82%D0%B0%D0%BA%D0%BE%D0%B5%20spring.md)
- Лёгкий Java-фреймворк для построения гибких, модульных приложений
- Убирает «рукописный» код, управляет зависимостями
- Core-модуль — это основа всего Spring'а

---

### 2. 💡 [Что такое *бин* в Spring?](%D1%87%D1%82%D0%BE%20%D1%82%D0%B0%D0%BA%D0%BE%D0%B5%20%D0%B1%D0%B8%D0%BD.md)

**Определение**:
> Бин — это объект, управляемый Spring-контейнером.

**Пример**:

```java
@Component
public class Printer {
    public void print(String message) {
        System.out.println(message);
    }
}
```

Когда приложение запускается — Spring создаёт объект этого класса, регистрирует его в контейнере, и ты можешь получить его с помощью `@Autowired`, `getBean()` и т.д.

**Бины создаются, настраиваются, соединяются и уничтожаются контейнером Spring.**

---

### 3. 🧠 [Inversion of Control (IoC) и контейнер Spring](IOC.md)

- Контейнер управляет созданием объектов и внедрением зависимостей
- Типы контейнеров:
    - `ApplicationContext` (чаще всего)
    - `BeanFactory` (более "низкоуровневый", используется редко)

**Пример:**

```java
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
Printer printer = context.getBean(Printer.class);
printer.print("Hello");
```

---

### 4. 🏭 [Как создаются бины: фабрики и конфигурация.md](%D1%81%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%20%D0%B1%D0%B8%D0%BD%D0%BE%D0%B2.md)

#### Способы регистрации бинов:
1. **Аннотации**
    - `@Component`, `@Service`, `@Repository`, `@Controller`
    - `@ComponentScan`

```java
@Component
public class UserService {}

@Configuration
@ComponentScan("com.example")
public class AppConfig {}
```

2. **Java-конфигурация через `@Bean`**

```java
@Configuration
public class AppConfig {
    @Bean
    public Printer printer() {
        return new Printer();
    }
}
```

3. **XML-конфигурация**

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       ...>

    <bean id="printer" class="com.example.Printer"/>
</beans>
```

```java
ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
Printer p = ctx.getBean("printer", Printer.class);
```

---

### 5. 🔄 [Жизненный цикл бина](%D0%B6%D0%B8%D0%B7%D0%BD%D0%B5%D0%BD%D0%BD%D1%8B%D0%B9%20%D1%86%D0%B8%D0%BA%D0%BB.md)

- Создание
- Внедрение зависимостей
- Настройка (`@PostConstruct`)
- Использование
- Уничтожение (`@PreDestroy`)

**Пример:**

```java
@Component
public class Printer {

    @PostConstruct
    public void init() {
        System.out.println("Printer создан");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Printer уничтожен");
    }

    public void print(String msg) {
        System.out.println(msg);
    }
}
```

**Важно:** Уничтожение бина работает только при закрытии контекста.

---

### 6. 📦 [Скоупы бинов](%D1%81%D0%BA%D0%BE%D1%83%D0%BF%D1%8B%20%D0%B1%D0%B8%D0%BD%D0%BE%D0%B2.md)

Spring по умолчанию создаёт бины в **синглтон-скоупе** (один экземпляр на весь контекст).

| Скоуп       | Описание                                      |
|-------------|-----------------------------------------------|
| singleton   | (по умолчанию) — один бин на весь контейнер   |
| prototype   | каждый `getBean()` создаёт новый экземпляр    |
| request     | (для web) — один бин на HTTP-запрос           |
| session     | (для web) — один бин на сессию                |

**Пример:**

```java
@Component
@Scope("prototype")
public class TaskProcessor {}
```

```java
TaskProcessor t1 = ctx.getBean(TaskProcessor.class);
TaskProcessor t2 = ctx.getBean(TaskProcessor.class);
System.out.println(t1 == t2); // false
```

---

### 7. ❓ BeanFactory vs ApplicationContext

| Характеристика           | BeanFactory              | ApplicationContext         |
|--------------------------|--------------------------|----------------------------|
| Ленивая инициализация    | ✅                        | ❌ (все бины создаются сразу) |
| Поддержка событий        | ❌                        | ✅                          |
| Поддержка интернационал. | ❌                        | ✅                          |
| Используется чаще всего  | ❌                        | ✅                          |

---

### 8. 🧪 Демонстрация / обсуждение
- Мини-консольный проект с `@Component`, `@Autowired`, `@Scope`, `@PostConstruct`
- Вызов `getBean()` и сравнение поведения singleton / prototype

---

## 📚 **Книги**

### 1. **Craig Walls — Spring in Action (6-е издание)**
🔗 [Spring in Action на Manning](https://www.manning.com/books/spring-in-action-sixth-edition)
- Очень популярная книга, охватывает Spring Core, Boot, Data, Security
- Хорошо подходит для начинающих и продолжающих
- Примеры кода, объяснения концепций, практические советы

### 2. **Josh Long — Cloud Native Java**
🔗 [Cloud Native Java на O'Reilly](https://www.oreilly.com/library/view/cloud-native-java/9781449374648/)
- Если интересует Spring Boot, микросервисы и Spring Cloud
- Много практики по CI/CD, Docker, CloudFoundry

### 3. **Pro Spring 5 (Iuliana Cosmina и др.)**
🔗 [Pro Spring 5 на Apress](https://link.springer.com/book/10.1007/978-1-4842-3170-1)
- Более академичен, глубоко раскрывает Spring Core, контекст, AOP
- Много XML-конфигурации, полезно для понимания «что под капотом»

---

## 🌐 **Официальная документация**

### 1. **Spring Documentation (Core, Boot и др.)**
🔗 https://docs.spring.io
- Все модули: Spring Core, Spring Boot, Spring Data, Security и т.д.
- Хорошо структурировано, с примерами

### 2. **Spring Guides — короткие обучающие туториалы**
🔗 https://spring.io/guides
- Простые и короткие практические руководства
- Примеры: создание REST API, доступ к БД, конфигурация безопасности

### 3. **Spring Initializr — генератор проектов**
🔗 https://start.spring.io
- Быстрый старт проекта с нужными зависимостями
- Можно выбрать Gradle/Maven, версии Java и Spring

---

## 🎓 **Обучающие курсы и видео**

### 1. **Baeldung — статьи и гайды по Spring и Java**
🔗 https://www.baeldung.com
- Подробные статьи по всем аспектам Spring
- Spring Security, REST, JPA, тестирование и многое другое

