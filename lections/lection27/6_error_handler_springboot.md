## 🔹 4. Обработка ошибок в REST API

---

### ❓ Зачем нужна централизованная обработка ошибок

- Клиенту важно **получать осмысленные сообщения**, а не stack trace
- Один стиль ошибок по всему API — признак качественного сервиса
- REST API должен возвращать **корректный HTTP-код** + **понятное JSON-сообщение**

---

### ✅ Как Spring Boot обрабатывает ошибки по умолчанию

Spring Boot автоматически перехватывает исключения и возвращает JSON вроде:

```json
{
  "timestamp": "2025-04-23T14:00:00",
  "status": 400,
  "error": "Bad Request",
  "path": "/api/something"
}
```

---

### 🛠 Реализация: `@RestControllerAdvice` + `@ExceptionHandler`

```java
@RestControllerAdvice
public class GlobalRestExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleBadRequest(IllegalArgumentException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("status", 400);
        error.put("error", "Bad Request");
        error.put("message", ex.getMessage());

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneric(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("status", 500);
        error.put("error", "Internal Server Error");
        error.put("message", "Что-то пошло не так");

        return ResponseEntity.status(500).body(error);
    }
}
```

---

### 📦 Пример: бросаем исключение в контроллере

```java
@GetMapping("/api/divide")
public int divide(@RequestParam int a, @RequestParam int b) {
    if (b == 0) {
        throw new IllegalArgumentException("Деление на ноль недопустимо");
    }
    return a / b;
}
```

### 🔁 Результат:

**Запрос:**  
`GET /api/divide?a=10&b=0`

**Ответ:**
```json
{
  "timestamp": "2025-04-23T14:00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Деление на ноль недопустимо"
}
```
