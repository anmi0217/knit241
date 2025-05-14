## 🔹 7. Интеграция с Thymeleaf

---

### 🆚 `@Controller` vs `@RestController`

| Аннотация         | Назначение                          | Поведение                               |
|------------------|--------------------------------------|------------------------------------------|
| `@RestController` | для REST API, возвращает JSON       | `@ResponseBody` по умолчанию             |
| `@Controller`     | для веб-интерфейса (HTML)           | Возвращает имя шаблона (например, `index`) |

🧠 Если ты хочешь сгенерировать **HTML-страницу**, используй `@Controller`.

---

### 🔌 Подключение Thymeleaf

1. В `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

2. Thymeleaf автоматически ищет HTML-шаблоны в:

```
src/main/resources/templates/
```

---

### 📁 Структура HTML-шаблонов

```
resources/
└── templates/
    ├── index.html
    ├── login.html
    └── error.html
```

---

### ✅ Пример контроллера

```java
@Controller
public class WebController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Добро пожаловать!");
        return "index"; // шаблон templates/index.html
    }
}
```

---

### 📄 Пример `index.html`

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head><meta charset="UTF-8"><title>Главная</title></head>
<body>
<h1 th:text="${message}">Сообщение по умолчанию</h1>
<form th:action="@{/login}" method="post">
    <input type="text" name="username" placeholder="Ваше имя">
    <button type="submit">Войти</button>
</form>
</body>
</html>
```

---

### 🚨 Обработка ошибок (HTML)

#### 1. `application.properties`:

```properties
server.error.whitelabel.enabled=false
server.error.path=/error
```

#### 2. Контроллер:

```java
@Controller
public class ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object code = request.getAttribute("jakarta.servlet.error.status_code");
        model.addAttribute("status", code);
        return "error";
    }
}
```

#### 3. Шаблон `error.html`

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head><meta charset="UTF-8"><title>Ошибка</title></head>
<body>
<h2>Произошла ошибка</h2>
<p>Код: <span th:text="${status}">?</span></p>
<a th:href="@{/}">На главную</a>
</body>
</html>
```

---

### 🎯 Применения Thymeleaf

- Формы авторизации/регистрации
- Страницы администратора
- Ошибки, подтверждения, отчёты
- Упрощённый UI без использования React/Vue

---

https://getbootstrap.com/docs/5.3/getting-started/download/
