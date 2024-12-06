Вот реализация метода **compareLists**, который выполняет указанные действия:

```java
import java.util.*;
import java.util.stream.Collectors;

public class ListComparison {

    public static <T> Map<String, List<T>> compareLists(List<T> list1, List<T> list2) {
        // Создаем списки для хранения результатов
        List<T> onlyInFirst = new ArrayList<>(list1);
        List<T> onlyInSecond = new ArrayList<>(list2);
        List<T> inBoth = new ArrayList<>();

        // Найти общие элементы
        inBoth.addAll(list1.stream()
                .filter(list2::contains)
                .distinct()
                .collect(Collectors.toList()));

        // Элементы, присутствующие только в первом списке
        onlyInFirst.removeAll(list2);

        // Элементы, присутствующие только во втором списке
        onlyInSecond.removeAll(list1);

        // Подготовить результат
        Map<String, List<T>> result = new HashMap<>();
        result.put("onlyInFirst", onlyInFirst);
        result.put("onlyInSecond", onlyInSecond);
        result.put("inBoth", inBoth);

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);

        Map<String, List<Integer>> result = compareLists(list1, list2);

        System.out.println("Elements only in first list: " + result.get("onlyInFirst"));
        System.out.println("Elements only in second list: " + result.get("onlyInSecond"));
        System.out.println("Common elements: " + result.get("inBoth"));
    }
}
```

### Пояснение:

1. **Общие элементы:**
    - Используем `stream` и `filter`, чтобы отфильтровать элементы из `list1`, которые содержатся в `list2`. Также применяем `distinct()`, чтобы избежать дублирования.

2. **Элементы только в первом/втором списке:**
    - Создаем копии списков (`onlyInFirst`, `onlyInSecond`) и используем `removeAll`, чтобы удалить элементы, присутствующие в другом списке.

3. **Результат:**
    - Результат помещается в `Map` с ключами `onlyInFirst`, `onlyInSecond`, и `inBoth`.

### Пример вывода:
Для `list1 = [1, 2, 3, 4, 5]` и `list2 = [4, 5, 6, 7, 8]`:
```
Elements only in first list: [1, 2, 3]
Elements only in second list: [6, 7, 8]
Common elements: [4, 5]
```