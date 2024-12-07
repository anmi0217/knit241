Вот обновленный список задач на тему Generics в Java без задач 4, 5 и 9:

---

### **18. Создание универсального класса**
**Задача:**  
Создайте универсальный класс `Pair`, который будет хранить две связанные сущности. Напишите методы для получения и изменения значений.

**Пример:**
```java
Pair<String, Integer> pair = new Pair<>("Age", 30);
System.out.println(pair.getFirst()); // Age
System.out.println(pair.getSecond()); // 30
pair.setSecond(35);
System.out.println(pair.getSecond()); // 35
```

---

### **19. Универсальный метод поиска максимального элемента**
**Задача:**  
Напишите универсальный метод `findMax`, который принимает массив элементов любого типа, реализующего интерфейс `Comparable`, и возвращает максимальный элемент.

**Пример:**
```java
Integer[] numbers = {1, 2, 3, 4, 5};
System.out.println(findMax(numbers)); // 5

String[] words = {"apple", "banana", "cherry"};
System.out.println(findMax(words)); // cherry
```

---

### **20. Универсальный контейнер с ограничениями**
**Задача:**  
Создайте класс `Box` с ограничением типа `T extends Number`. Реализуйте метод для вычисления суммы всех чисел, хранящихся в контейнере.

**Пример:**
```java
Box<Integer> integerBox = new Box<>();
integerBox.add(10);
integerBox.add(20);
System.out.println(integerBox.sum()); // 30

Box<Double> doubleBox = new Box<>();
doubleBox.add(1.5);
doubleBox.add(2.5);
System.out.println(doubleBox.sum()); // 4.0
```

---

### **21. Фильтрация элементов** *
**Задача:**  
Напишите универсальный метод `filter`, который принимает список элементов и предикат (интерфейс `Predicate<T>`). Метод должен возвращать новый список, содержащий только те элементы, которые удовлетворяют предикату.

**Пример:**
```java
List<String> words = Arrays.asList("apple", "banana", "cherry");
List<String> filtered = filter(words, s -> s.startsWith("b"));
System.out.println(filtered); // [banana]
```

---

### **22. Универсальный словарь** *
**Задача:**  
Создайте класс `Dictionary<K, V>`, который будет работать как словарь (ключ-значение). Реализуйте методы для добавления, удаления и получения элементов.

**Пример:**
```java
Dictionary<String, Integer> dictionary = new Dictionary<>();
dictionary.put("Alice", 25);
dictionary.put("Bob", 30);
System.out.println(dictionary.get("Alice")); // 25
```

---

### **23. Печать типа объекта**
**Задача:**  
Напишите универсальный метод `printType`, который принимает объект любого типа и выводит на экран имя его класса.

**Пример:**
```java
printType(123); // java.lang.Integer
printType("Hello"); // java.lang.String
```

---

