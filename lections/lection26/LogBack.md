## 🔹 **4. Конфигурация логгирования с помощью Logback (`logback.xml`)**

Когда ты используешь **SLF4J + Logback**, вся настройка логирования — через файл конфигурации **`logback.xml`** (или `logback-spring.xml`, если ты в Spring Boot).

---

### 📁 Где должен лежать `logback.xml`?

В папке:
```
src/main/resources/logback.xml
```

➡ Тогда Logback автоматически его найдёт и применит при запуске приложения.

---

## 🔧 Пример простого `logback.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <!-- Консольный вывод -->
    <appender name="Console" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss} %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <!-- Корневой логгер -->
    <root level="debug">
        <appender-ref ref="Console"/>
    </root>

</configuration>
```

---

## 📘 Что тут происходит:

### 1. `<appender name="Console" ...>`
- Настраивает **куда** пишутся логи (в консоль, в файл и т.д.)
- Можно создать несколько аппендеров — например, один в консоль, другой в файл

---

### 2. `<encoder> → <pattern>`
- Формат вывода строки
- Пример:
  ```
  13:45:12 INFO  MyClass - Привет!
  ```

📌 Частые паттерны:
- `%d{HH:mm:ss}` → время
- `%level` или `%-5level` → уровень
- `%logger{36}` → имя логгера
- `%msg` → само сообщение
- `%n` → перенос строки

---

### 3. `<root level="debug">`
- Уровень логирования по умолчанию
- Можно указать: `trace`, `debug`, `info`, `warn`, `error`

💡 Уровень фильтрует всё, что **ниже**:
```xml
<root level="info">
```
→ `debug` и `trace` **не будут выводиться**

---

## 📁 Вывод в файл

Хочешь писать логи в файл? — Добавь второй аппендер:

```xml
<appender name="FileAppender" class="ch.qos.logback.core.FileAppender">
    <file>logs/app.log</file>
    <append>true</append>
    <encoder>
        <pattern>%d{yyyy-MM-dd HH:mm:ss} %-5level %logger{36} - %msg%n</pattern>
    </encoder>
</appender>
```

И подключи его:

```xml
<root level="info">
    <appender-ref ref="Console"/>
    <appender-ref ref="FileAppender"/>
</root>
```

Теперь логи будут писаться **и в консоль**, и в файл `logs/app.log`.

---

## 🎯 Настройка отдельных логгеров (по классам или пакетам)

```xml
<logger name="com.mycompany.service" level="debug"/>
```

Можно задать отдельный уровень для определённого пакета.

---

## 🎓 Выводы:

| Что можно настроить        | Как                                          |
|----------------------------|-----------------------------------------------|
| Куда писать логи           | через `<appender>` (Console, File и т.д.)     |
| Что писать (формат)        | через `<encoder><pattern>`                    |
| Какие уровни логировать    | через `<root level="...">`                    |
| Разделить логи по классам  | через `<logger name="...">`                   |

---
