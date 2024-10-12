# Лабораторная работа № 5

## Цель работы:
- Научиться переопределять методы hashcode и equals
- Научиться работать с Comparator
- 
---

## Задача №8

Создайте класс Модель товарной позиции (ShopItem). Добавьте минимум 3 поля/свойства объекту ShopItem.
Переопределите метод toString, equals и hashcode. 

Пусть одно из полей класса ShopItem будет **String name**

Отдельно создайте массив с именами товарных позиций

Пример

```java
import java.util.Random;

String[] names = {"книга", "ручка", "линейка", "пинал"};
Random random = new Random();
int index = random.nextInt(4);
ShopItem item = new ShopItem(names[index]);
```

Сгенерируйте 100 объектов (TestData) ShopItem таким образом, чтобы некоторые поля были случайными, но и некоторые поля были бы одинаковыми и положите их в массив.

- Отсортируйте массив по любому из полей (Воспользуйтесь компаратором). 
- Выведите объекты в консоль.
- Выведите количество одинаковых ShopItem.

## Задача №9 *

Создайте консольное приложение, которое в течение минуты, берет случайные слова из списка и
предлагает пользователю их ввести.


Приложение должно засекать время на 1 минуту. Через минуту последнее введенное слово не учитывается.
Если слово совпало с предложенным, то увеличиваем счетчик на 1.
Через минуту подводим итог.

- количество слов всего было.
- количество правильных слов.
- количество введенных символов, скорость символов в секунду ** 

```java
import java.util.ArrayList;
import java.util.List;

//пример
public class Keyboard {

    public static void main(String[] args) {
        //получает текущее время в миллисекундах
        long timeMillis = System.currentTimeMillis();

    }

    //Возвращает список слов из файла
    public static List<String> getWords(String path) {
        Scanner scanner = new Scanner(new File("misc/dictionary.txt"));
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            words.add(scanner.nextline());
        }
        scanner.close;
        return words;
    }
}
```


