В Java можно получить коллекцию из JSON с помощью библиотек Gson или Jackson. Ниже приведены примеры для обеих библиотек.

### 1. Получение коллекции с использованием Gson

С помощью Gson можно десериализовать JSON-массив в коллекцию (например, `List`). Для этого обычно используется `TypeToken`, так как `List<T>` является параметризованным типом, и его нужно явно указать для корректной десериализации.

#### Пример кода
```java
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class GsonCollectionExample {
    public static void main(String[] args) {
        // JSON-строка, представляющая коллекцию
        String json = "[{\"name\":\"Alice\",\"age\":30},{\"name\":\"Bob\",\"age\":25}]";

        // Определяем тип коллекции, которую будем десериализовать
        Type userListType = new TypeToken<List<User>>(){}.getType();

        // Десериализуем JSON в коллекцию List<User>
        Gson gson = new Gson();
        List<User> users = gson.fromJson(json, userListType);

        // Выводим полученную коллекцию
        users.forEach(System.out::println);
    }
}

// Класс User
class User {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}
```

### Объяснение
- **TypeToken:** `TypeToken<List<User>>(){}.getType()` позволяет получить тип `List<User>`, который необходим для правильной десериализации JSON-массива.
- **fromJson:** `gson.fromJson(json, userListType)` выполняет преобразование JSON-строки в список объектов `User`.

### 2. Получение коллекции с использованием Jackson

Jackson также поддерживает десериализацию JSON-массивов в коллекции, но здесь мы используем `TypeReference` для указания типа коллекции.

#### Пример кода
```java
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

public class JacksonCollectionExample {
    public static void main(String[] args) {
        // JSON-строка, представляющая коллекцию
        String json = "[{\"name\":\"Alice\",\"age\":30},{\"name\":\"Bob\",\"age\":25}]";

        // Десериализуем JSON в коллекцию List<User>
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<User> users = mapper.readValue(json, new TypeReference<List<User>>() {});
            users.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Класс User
class User {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}
```

### Объяснение
- **TypeReference:** `new TypeReference<List<User>>() {}` указывает Jackson, что целевой тип данных — это `List<User>`.
- **readValue:** `mapper.readValue(json, new TypeReference<List<User>>() {})` десериализует JSON в коллекцию `List<User>`.

### Результат для обоих примеров
Для обоих подходов вывод будет таким:
```plaintext
User{name='Alice', age=30}
User{name='Bob', age=25}
```