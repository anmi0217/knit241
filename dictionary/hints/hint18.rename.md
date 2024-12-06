### Полное решение задачи 18:

---

#### Шаг 1: Реализация метода `filterUniqueByField`

Обобщенный метод использует Stream API и `Collectors.toMap`, чтобы выбрать уникальные элементы на основе указанного поля:

```java
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FilterUtils {

    public static <T, K> List<T> filterUniqueByField(List<T> list, Function<T, K> keyExtractor) {
        return list.stream()
                .collect(Collectors.toMap(
                        keyExtractor, // Извлечение уникального ключа
                        Function.identity(), // Значение - сам объект
                        (existing, replacement) -> existing // В случае конфликта оставляем первый объект
                ))
                .values()
                .stream()
                .toList(); // Возвращаем список уникальных объектов
    }
}
```

---

#### Шаг 2: Создание класса `Employee`

Класс `Employee` с переопределением метода `toString` для удобного отображения результатов:

```java
public class Employee {
    int id;
    String name;
    String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', department='%s'}", id, name, department);
    }
}
```

---

#### Шаг 3: Тестирование метода

Пример тестирования с `List<Employee>`:

```java
import java.util.Arrays;
import java.util.List;

public class TestFilterUtils {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "HR"),
                new Employee(2, "Bob", "Engineering"),
                new Employee(3, "Charlie", "HR"),
                new Employee(2, "Bob Duplicate", "Engineering"), // Дубликат по id
                new Employee(4, "David", "Finance")
        );

        // Оставляем уникальных сотрудников по id
        List<Employee> uniqueEmployees = FilterUtils.filterUniqueByField(employees, Employee::id);

        System.out.println("Unique Employees:");
        uniqueEmployees.forEach(System.out::println);
    }
}
```

---

#### Вывод:
```
Unique Employees:
Employee{id=1, name='Alice', department='HR'}
Employee{id=2, name='Bob', department='Engineering'}
Employee{id=3, name='Charlie', department='HR'}
Employee{id=4, name='David', department='Finance'}
```

---

### Объяснение:
1. **`Collectors.toMap`**:
   - Создает карту, где ключ — это значение, извлеченное через `keyExtractor` (например, `id`).
   - Значение — это сам объект `T`.
   - В случае дубликатов по ключу (`id`) выбирается первый объект (`existing`).

2. **Применение Generics**:
   - Метод работает с любым типом объекта (`T`), а ключ может быть любым типом (`K`).
   - Поле, по которому фильтруются уникальные элементы, задается с помощью лямбда-выражения (`keyExtractor`).

3. **Универсальность**:
   - Метод можно использовать с любыми классами, передавая `Function` для извлечения уникального ключа.

---

Этот подход гибок и универсален, а также демонстрирует силу Stream API в сочетании с Generics.