## ✅ Пример: логгирование с `java.util.logging`

```java
import java.util.logging.Logger;
import java.util.logging.Level;

public class SimpleLoggerExample {

    // Создаём логгер с именем класса
    private static final Logger logger = Logger.getLogger(SimpleLoggerExample.class.getName());

    public static void main(String[] args) {
        logger.info("Программа запущена"); // уровень INFO
        logger.warning("Предупреждение: что-то не так"); // уровень WARNING
        logger.severe("ОШИБКА: программа завершится"); // уровень SEVERE

        // Для более детального логгирования
        logger.fine("Отладочная информация (FINE)");
    }
}
```

---

## 🔍 Что делает этот код?

- Логгер создаётся по имени класса: `Logger.getLogger(...)`
- Сообщения записываются с разным уровнем: `info`, `warning`, `severe`, `fine`
- Эти уровни автоматически отображаются в консоли, **если они выше текущего уровня логирования**

---

## 🧪 Проблема: по умолчанию не показываются `FINE`, `FINER`, `FINEST`

Чтобы `fine()` работал, нужно **явно включить более низкий уровень логирования**. Это можно сделать программно:

```java
logger.setLevel(Level.FINE);
```

А также нужно установить уровень и для обработчика консоли:

```java
for (var handler : Logger.getLogger("").getHandlers()) {
    handler.setLevel(Level.ALL);
}
```

Полный рабочий пример:

```java
import java.util.logging.*;

public class FullLoggerExample {
    private static final Logger logger = Logger.getLogger(FullLoggerExample.class.getName());

    public static void main(String[] args) {
        // Устанавливаем уровень логирования
        logger.setLevel(Level.ALL);

        // Устанавливаем уровень логгера для консоли (иначе FINE не увидим)
        for (Handler handler : Logger.getLogger("").getHandlers()) {
            handler.setLevel(Level.ALL);
        }

        logger.severe("SEVERE - критическая ошибка");
        logger.warning("WARNING - предупреждение");
        logger.info("INFO - информационное сообщение");
        logger.config("CONFIG - параметры конфигурации");
        logger.fine("FINE - отладочная информация");
        logger.finer("FINER - очень подробная информация");
        logger.finest("FINEST - максимально подробная информация");
    }
}
```

---

## 📋 Вывод в консоль:

```text
09 апр. 2025 г. 13:00:01 FullLoggerExample main
SEVERE: SEVERE - критическая ошибка
WARNING: WARNING - предупреждение
INFO: INFO - информационное сообщение
FINE: FINE - отладочная информация
...
```


`java.util.logging` (JUL) умеет читать конфигурацию из специального **`.properties` файла** — например, `logging.properties`.

Это позволяет:
- управлять уровнем логирования,
- настраивать формат сообщений,
- задавать вывод в консоль или файл,
- отключать/включать обработчики (`handlers`).

---

## ✅ Как использовать `logging.properties`

### 📁 Структура проекта:

```
src/
├── main/
│   ├── java/
│   │   └── MyApp.java
│   └── resources/
│       └── logging.properties
```

---

### 📄 Пример `logging.properties`:

```properties
# Глобальный уровень логирования
.level = INFO

# Уровень логирования для нашего класса
com.example.MyApp.level = FINE

# Обработчики (куда писать логи)
handlers = java.util.logging.ConsoleHandler

# Уровень и формат для консоли
java.util.logging.ConsoleHandler.level = FINE
java.util.logging.ConsoleHandler.formatter = java.util.logging.SimpleFormatter
```

---

### 📌 Как подключить `logging.properties`?

Есть два способа:

---

### 🔹 1. Через аргумент при запуске Java:

```bash
java -Djava.util.logging.config.file=src/main/resources/logging.properties -cp target/classes com.example.MyApp
```

`-D...` передаёт системное свойство `java.util.logging.config.file`, и JUL сам подхватывает конфигурацию.

---

### 🔹 2. Через код в `main()`:

```java
public class MyApp {
    static {
        try {
            LogManager.getLogManager().readConfiguration(
                MyApp.class.getResourceAsStream("/logging.properties")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final Logger logger = Logger.getLogger(MyApp.class.getName());

    public static void main(String[] args) {
        logger.fine("FINE сообщение");
        logger.info("INFO сообщение");
    }
}
```

🔧 Этот способ удобен, если ты хочешь, чтобы всё работало **автоматически** при запуске JAR.

---

## 📦 Формат `logging.properties`

| Ключ                                    | Что делает                                                |
|-----------------------------------------|-----------------------------------------------------------|
| `.level`                                | Уровень по умолчанию для всех логгеров                   |
| `your.package.ClassName.level`          | Уровень для конкретного логгера                          |
| `handlers`                              | Какие обработчики использовать (например, `ConsoleHandler`) |
| `java.util.logging.ConsoleHandler.level` | Уровень логов для консоли                                |
| `java.util.logging.ConsoleHandler.formatter` | Формат выводимых сообщений                              |

---


Добавь в `logging.properties` для вывода в файл:

```properties
handlers = java.util.logging.ConsoleHandler, java.util.logging.FileHandler

# Пишем в лог-файл
java.util.logging.FileHandler.pattern = logs/app_%u.log
java.util.logging.FileHandler.limit = 50000
java.util.logging.FileHandler.count = 3
java.util.logging.FileHandler.append = true
java.util.logging.FileHandler.level = ALL
java.util.logging.FileHandler.formatter = java.util.logging.SimpleFormatter
```

---
