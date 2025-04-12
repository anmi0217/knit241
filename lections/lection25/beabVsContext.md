## ⚙️ **7. BeanFactory vs ApplicationContext**

---

### 📘 Что это такое?

Оба — это **контейнеры Spring IoC**, которые управляют созданием, хранением и внедрением бинов.  
Разница в **функциональности, инициализации и удобстве использования**.

---

### 📦 `BeanFactory` (интерфейс из `org.springframework.beans.factory`)

- **Простой** и **лёгкий** контейнер
- Создаёт бины **только по запросу** (ленивая инициализация)
- Подходит для **минималистичных или embedded** приложений
- Поддерживает только базовый функционал (создание и связывание бинов)

```java
Resource res = new ClassPathResource("beans.xml");
BeanFactory factory = new XmlBeanFactory(res);
MyService service = factory.getBean(MyService.class);
```

> ⚠️ `XmlBeanFactory` — устаревший класс, оставлен ради совместимости

---

### 🧠 `ApplicationContext` (расширенный интерфейс из `org.springframework.context`)

- Расширяет `BeanFactory`
- Загружает **все бины сразу при старте** (eager инициализация)
- Поддерживает:
    - **международную локализацию** (i18n)
    - **жизненный цикл бинов**
    - **обработку событий**
    - **аннотации `@PostConstruct`, `@PreDestroy`**
    - **автоматическое связывание компонентов**
    - **AOP, proxy, scopes и т.п.**

```java
ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
MyService service = ctx.getBean(MyService.class);
```

---

### 📊 Сравнительная таблица

| Возможность                   | BeanFactory   | ApplicationContext |
|-------------------------------|---------------|---------------------|
| Создание бинов                | ✅             | ✅                  |
| Ленивая инициализация         | ✅             | ❌ (всё сразу)      |
| `@PostConstruct`/`@PreDestroy`| ❌             | ✅                  |
| Обработка событий             | ❌             | ✅                  |
| Автосвязывание (`@Autowired`) | ❌ (только вручную) | ✅           |
| AOP и прокси                  | ❌             | ✅                  |
| Поддержка аннотаций           | ❌             | ✅                  |
| Рекомендуется использовать    | ❌             | ✅                  |

---

### ✅ Вывод:

- **`BeanFactory`** — низкоуровневый интерфейс, почти не используется в реальных проектах
- **`ApplicationContext`** — стандартный и рекомендуемый контейнер, используется почти всегда
- Если ты пишешь на Spring Boot — ты уже работаешь с `ApplicationContext`

---