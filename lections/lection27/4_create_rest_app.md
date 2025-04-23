## 🔹 4. Создание REST API с Spring Boot

---

### 🧱 Что такое REST-контроллер в Spring Boot

В Spring Boot REST API создаётся с помощью аннотаций:
- `@RestController` — указывает, что класс возвращает JSON/текст, а не HTML
- `@RequestMapping` или `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping` — для маршрутизации запросов
- `@RequestBody`, `@RequestParam`, `@PathVariable` — извлекают данные из запроса

---

### ✅ Пример контроллера

```java
@RestController
@RequestMapping("/api")
public class UserController {

    // GET /api/hello
    @GetMapping("/hello")
    public String sayHello() {
        return "Привет от Spring Boot!";
    }

    // GET /api/user/42
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id) {
        return "Пользователь #" + id;
    }

    // POST /api/user
    @PostMapping("/user")
    public String createUser(@RequestBody Map<String, Object> userData) {
        return "Создан пользователь: " + userData.get("name");
    }
}
```

---

### 🧾 Разбор аннотаций

| Аннотация         | Что делает                                         |
|------------------|----------------------------------------------------|
| `@RestController` | Класс — REST API (автоматически `@ResponseBody`)  |
| `@GetMapping`     | Обрабатывает HTTP GET                             |
| `@PostMapping`    | Обрабатывает HTTP POST                            |
| `@RequestParam`   | Читает параметры из строки запроса (?a=1&b=2)      |
| `@PathVariable`   | Читает переменную из URL (/user/5)                |
| `@RequestBody`    | Читает JSON-тело запроса и мапит в объект         |

---

### 📦 Пример JSON-запроса и ответа

#### Запрос:

```http
POST /api/user HTTP/1.1
Content-Type: application/json

{
  "name": "Иван",
  "email": "ivan@example.com"
}
```

#### Ответ:

```json
{
  "status": "success",
  "message": "Создан пользователь: Иван"
}
```

---

### 🔧 Тестирование REST API

#### С помощью Postman:

1. Выбираешь метод (`GET` или `POST`)
2. Указываешь URL, например: `http://localhost:8080/api/user`
3. Вкладка `Body → raw → JSON`, вставляешь JSON
4. Нажимаешь **Send**

#### С помощью `curl`:

```bash
curl -X POST http://localhost:8080/api/user \
  -H "Content-Type: application/json" \
  -d '{"name":"Иван", "email":"ivan@example.com"}'
```

---

### 🧠 Вопросы для аудитории:

- Когда использовать `@PathVariable`, а когда `@RequestParam`?
- Что произойдёт, если забыть `@RequestBody`?
- Как обрабатывать ошибки, если JSON некорректен?

---
