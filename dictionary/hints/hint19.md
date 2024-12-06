### Полное решение задачи

---

#### 1. Реализация обобщенного метода `filterUniqueByField`

Метод принимает список объектов и функцию для извлечения ключа (`keyExtractor`). Используем `Stream API` и `Collectors.toMap` для фильтрации уникальных объектов:

```java
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FilterUtils {

    public static <T, K> List<T> filterUniqueByField(List<T> list, Function<T, K> keyExtractor) {
        return list.stream()
                .collect(Collectors.toMap(
                        keyExtractor,            // Извлечение уникального ключа (например, id)
                        Function.identity(),     // Значение - сам объект
                        (existing, replacement) -> existing // В случае дубликатов оставляем первый объект
                ))
                .values()                      // Получаем коллекцию уникальных объектов
                .stream()
                .toList();                     // Преобразуем в список
    }
}
```

---

#### 2. Создание класса `Employee`

Класс `Employee` включает поля `id`, `name` и `department`. Для удобного отображения добавляем метод `toString`:

```java
public class Employee {
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', department='%s'}", id, name, department);
    }
}
```

---

#### 3. Тестирование

Напишем тест, чтобы проверить, как работает метод `filterUniqueByField` с объектами `Employee`:

```java
import java.util.Arrays;
import java.util.List;

public class TestFilterUtils {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "HR"),
                new Employee(2, "Bob", "Engineering"),
                new Employee(3, "Charlie", "HR"),
                new Employee(2, "Duplicate Bob", "Engineering"), // Дубликат по id
                new Employee(4, "David", "Finance")
        );

        // Фильтруем уникальных сотрудников по id
        List<Employee> uniqueEmployees = FilterUtils.filterUniqueByField(employees, Employee::getId);

        System.out.println("Unique Employees:");
        uniqueEmployees.forEach(System.out::println);
    }
}
```

---

#### 4. Вывод программы

```
Unique Employees:
Employee{id=1, name='Alice', department='HR'}
Employee{id=2, name='Bob', department='Engineering'}
Employee{id=3, name='Charlie', department='HR'}
Employee{id=4, name='David', department='Finance'}
```

---

### Объяснение решения:

1. **Метод `filterUniqueByField`:**
   - Используем `Stream API` для обработки списка.
   - Преобразуем поток в `Map` с помощью `Collectors.toMap`:
     - Ключ (`keyExtractor`) извлекается из каждого объекта.
     - Значение — это сам объект (`Function.identity()`).
     - Если ключ повторяется, оставляем первый объект (`(existing, replacement) -> existing`).
   - Получаем только значения из `Map` (`.values()`) и преобразуем их в список.

2. **Гибкость обобщенного метода:**
   - Метод работает с любым типом объектов `T`.
   - Функция `keyExtractor` позволяет извлечь уникальный ключ любого типа `K`.

3. **Тестирование:**
   - Для `List<Employee>` уникальность определяется по полю `id`.

Этот метод универсален и подходит для обработки любых коллекций с дубликатами, где требуется сохранить уникальные объекты на основе определенного критерия.