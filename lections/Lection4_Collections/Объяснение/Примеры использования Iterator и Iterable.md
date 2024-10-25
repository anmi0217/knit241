### 5. Примеры использования Iterator и Iterable

#### 5.1 Что такое Iterator и Iterable

**`Iterator`** и **`Iterable`** — это интерфейсы в Java, которые позволяют последовательно проходить по элементам коллекции. Они играют ключевую роль в циклах и работе с коллекциями, предоставляя универсальный способ доступа к элементам независимо от типа коллекции.

##### 5.1.1 `Iterable`
- **Описание:** `Iterable` — это интерфейс, который определяет, что объект поддерживает итерацию. Он содержит только один метод:
  ```java
  Iterator<T> iterator();
  ```
  Этот метод возвращает объект `Iterator`, который позволяет обойти элементы коллекции. Все коллекции в Java (например, `List`, `Set`, `Queue`) реализуют интерфейс `Iterable`, что позволяет использовать их с циклом `for-each`.

##### 5.1.2 `Iterator`
- **Описание:** `Iterator` — это интерфейс, который предоставляет методы для обхода элементов коллекции:
  - `boolean hasNext()`: возвращает `true`, если в коллекции есть следующий элемент.
  - `T next()`: возвращает следующий элемент коллекции.
  - `void remove()`: удаляет текущий элемент из коллекции (необязательный метод, поддерживается не всеми коллекциями).

- **Назначение:** `Iterator` позволяет обойти элементы коллекции последовательно, не зная заранее её реализацию (будь то массив, связный список или дерево). Это упрощает код и повышает его гибкость.

#### 5.2 Реализация своего итератора

Чтобы продемонстрировать, как работает `Iterator`, создадим простой класс, который реализует интерфейсы `Iterable` и `Iterator`. Например, создадим коллекцию чисел `CustomNumberCollection`.

```java
import java.util.Iterator;

public class CustomNumberCollection implements Iterable<Integer> {
    private Integer[] numbers;

    public CustomNumberCollection(Integer[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<Integer> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < numbers.length;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more elements to iterate.");
            }
            return numbers[index++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported.");
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};
        CustomNumberCollection collection = new CustomNumberCollection(nums);

        for (Integer num : collection) {
            System.out.println(num);
        }
    }
}
```

**Объяснение:**
- Класс `CustomNumberCollection` реализует интерфейс `Iterable`, и метод `iterator()` возвращает новый экземпляр `CustomIterator`.
- Вложенный класс `CustomIterator` реализует интерфейс `Iterator` и предоставляет методы `hasNext()` и `next()` для обхода элементов массива.
- В методе `main` мы создаем экземпляр `CustomNumberCollection` и используем цикл `for-each` для итерации по элементам коллекции. Это возможно благодаря тому, что класс реализует `Iterable`.

#### 5.3 Как использовать итераторы с коллекциями и зачем это может быть полезно

##### 5.3.1 Использование итераторов с коллекциями
Итераторы предоставляют гибкий способ обхода коллекций. Вот пример использования итератора с коллекцией типа `ArrayList`:

```java
import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }
    }
}
```

**Объяснение:**
- Метод `iterator()` у коллекции `ArrayList` возвращает объект `Iterator`.
- Мы используем цикл `while` для итерации по элементам коллекции. `hasNext()` проверяет, есть ли еще элементы, а `next()` возвращает текущий элемент и переходит к следующему.

##### 5.3.2 Зачем это полезно
- **Универсальность**: Итераторы работают с любыми коллекциями, поддерживающими интерфейс `Iterable`. Это позволяет писать код, который не зависит от конкретной реализации коллекции.
- **Удаление элементов**: Используя метод `remove()` в итераторе, можно безопасно удалять элементы из коллекции во время итерации, что невозможно сделать с циклом `for-each`.
- **Инкапсуляция и безопасность**: Итераторы обеспечивают безопасный доступ к элементам коллекции, скрывая внутренние детали её реализации. Это помогает поддерживать инкапсуляцию данных и защиту от непредвиденных изменений.

##### Пример удаления элемента с использованием итератора:
```java
import java.util.ArrayList;
import java.util.Iterator;

public class RemoveElementExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.equals("Bob")) {
                iterator.remove(); // Удаляем "Bob" из коллекции
            }
        }

        System.out.println(names); // Вывод: [Alice, Charlie]
    }
}
```

**Объяснение:**
- В этом примере мы удаляем элемент `"Bob"` из списка во время итерации, используя метод `remove()`. Это безопасный способ удаления, который не нарушает целостность коллекции.

### Заключение
Интерфейсы `Iterator` и `Iterable` предоставляют мощные и гибкие инструменты для работы с коллекциями в Java. Они позволяют обходить элементы коллекций независимо от их реализации, упрощают удаление элементов и защищают структуру данных от непредвиденных изменений. Понимание и правильное использование этих интерфейсов является важным навыком при работе с коллекциями в Java.