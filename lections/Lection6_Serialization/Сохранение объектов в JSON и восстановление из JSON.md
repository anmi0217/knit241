### Сохранение объектов в JSON и восстановление из JSON (30 минут)

#### 1. Введение в формат JSON и его преимущества для сериализации (5 минут)
   - **JSON (JavaScript Object Notation):** текстовый формат обмена данными, который используется для представления структурированных данных.
   - **Преимущества JSON:**
     - Читаемый человеком и легко парсируется.
     - Широко поддерживается и стандартен для веб-API и межъязыкового обмена данными.
     - Гибкий и лёгкий формат, подходящий для сериализации и передачи объектов.
   - **Основная структура JSON:** JSON состоит из пар "ключ-значение" и поддерживает типы данных, такие как строки, числа, массивы и вложенные объекты.

#### 2. Библиотека Gson
   - **Установка и настройка библиотеки:**
     - Для добавления Gson в проект с использованием Maven добавьте следующую зависимость в файл `pom.xml`:
       ```xml
       <dependency>
           <groupId>com.google.code.gson</groupId>
           <artifactId>gson</artifactId>
           <version>2.8.9</version>
       </dependency>
       ```
     - В Gradle:
       ```groovy
       implementation 'com.google.code.gson:gson:2.8.9'
       ```

   - **Пример кода: сериализация и десериализация с Gson**
     ```java
     import com.google.gson.Gson;

     class User {
         private String name;
         private int age;

         public User(String name, int age) {
             this.name = name;
             this.age = age;
         }

         @Override
         public String toString() {
             return "User{name='" + name + "', age=" + age + "}";
         }
     }

     public class GsonExample {
         public static void main(String[] args) {
             Gson gson = new Gson();

             // Сериализация
             User user = new User("Alice", 25);
             String json = gson.toJson(user);
             System.out.println("JSON: " + json);

             // Десериализация
             User deserializedUser = gson.fromJson(json, User.class);
             System.out.println("Deserialized User: " + deserializedUser);
         }
     }
     ```
     - **Результат:**
       ```plaintext
       JSON: {"name":"Alice","age":25}
       Deserialized User: User{name='Alice', age=25}
       ```

   - **Особенности работы с `Gson`:**
     - **Исключение полей:** с помощью ключевого слова `transient` поля могут быть исключены из JSON (как и в стандартной сериализации).
     - **Форматирование JSON:** можно создать объект `Gson` с помощью `GsonBuilder` для форматирования JSON:
       ```java
       Gson gson = new GsonBuilder().setPrettyPrinting().create();
       ```

#### 3. Библиотека Jackson
   - **Установка и настройка библиотеки:**
     - Maven:
       ```xml
       <dependency>
           <groupId>com.fasterxml.jackson.core</groupId>
           <artifactId>jackson-databind</artifactId>
           <version>2.13.3</version>
       </dependency>
       ```
     - Gradle:
       ```groovy
       implementation 'com.fasterxml.jackson.core:jackson-databind:2.13.3'
       ```

   - **Пример кода: сериализация и десериализация с Jackson**
     ```java
     import com.fasterxml.jackson.databind.ObjectMapper;
     import com.fasterxml.jackson.annotation.JsonProperty;

     class Product {
         @JsonProperty("product_name")
         private String name;
         private double price;

         public Product(String name, double price) {
             this.name = name;
             this.price = price;
         }

         @Override
         public String toString() {
             return "Product{name='" + name + "', price=" + price + "}";
         }
     }

     public class JacksonExample {
         public static void main(String[] args) {
             ObjectMapper mapper = new ObjectMapper();

             try {
                 // Сериализация
                 Product product = new Product("Laptop", 1200.0);
                 String json = mapper.writeValueAsString(product);
                 System.out.println("JSON: " + json);

                 // Десериализация
                 Product deserializedProduct = mapper.readValue(json, Product.class);
                 System.out.println("Deserialized Product: " + deserializedProduct);

             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
     }
     ```
     - **Результат:**
       ```plaintext
       JSON: {"product_name":"Laptop","price":1200.0}
       Deserialized Product: Product{name='Laptop', price=1200.0}
       ```

   - **Основные аннотации Jackson:**
     - **`@JsonProperty`:** задаёт имя поля в JSON, позволяя, например, переименовать поле `name` в `product_name`.
     - **`@JsonIgnore`:** исключает поле из JSON.
     - **`@JsonInclude`:** определяет условия для включения поля в JSON (например, только если оно не равно null).

#### 4. Сравнение Gson и Jackson
   - **Gson:**
     - Простой и лёгкий в использовании.
     - Хорош для базовых операций сериализации и десериализации.
     - Более ограничен в настройках и расширяемости по сравнению с Jackson.
   - **Jackson:**
     - Поддерживает более сложные функции и аннотации, позволяющие контролировать процесс сериализации.
     - Быстрее работает с большими объёмами данных и поддерживает более широкий набор форматов (например, XML).
     - Имеет обширные возможности для расширяемости, настройки и оптимизации.
   - **Когда использовать:**
     - **Gson** подходит для простых задач, где требуется минимальная настройка.
     - **Jackson** лучше использовать в крупных проектах или там, где требуется точный контроль над процессом сериализации.



### Дополнительно

[Получение коллекций Json](%D0%9F%D0%BE%D0%BB%D1%83%D1%87%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%BA%D0%BE%D0%BB%D0%BB%D0%B5%D0%BA%D1%86%D0%B8%D0%B9%20Json.md)