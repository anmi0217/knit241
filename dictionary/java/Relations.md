



![relation_scheme.jpeg](..%2F..%2Fcommon%2Frelation_scheme.jpeg)



### 1. **Пример композиции:**

В этом примере класс `House` композирует объект класса `Room`. Комнаты являются неотъемлемой частью дома, и без дома они не могут существовать.

```java
class Room {
    private String name;

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class House {
    private Room room;

    public House(String roomName) {
        // Композиция: создаем объект Room внутри House
        this.room = new Room(roomName);
    }

    public void showRoom() {
        System.out.println("This house has a " + room.getName());
    }
}

public class Main {
    public static void main(String[] args) {
        House house = new House("Living Room");
        house.showRoom();
    }
}
```

**Объяснение:** В данном примере, класс `House` содержит объект `Room`. Комната не может существовать без дома, и она создается внутри класса `House`. Когда объект `House` будет уничтожен, объект `Room` также будет уничтожен, так как его жизненный цикл связан с домом.

### 2. **Пример агрегации:**

В этом примере класс `School` агрегирует объект класса `Student`. Школа может иметь студентов, но студенты могут существовать и без школы (например, они могут быть записаны в другие школы).

```java
class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class School {
    private Student student;

    // Агрегация: студент передается извне
    public School(Student student) {
        this.student = student;
    }

    public void showStudent() {
        System.out.println("This school has a student named " + student.getName());
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student("John Doe");
        School school = new School(student);
        school.showStudent();
    }
}
```

**Объяснение:** В этом примере объект `Student` создается отдельно и передается в класс `School`. Это означает, что студент может существовать без школы, и его жизненный цикл не зависит от школы. Это отношение агрегации.

В объектно-ориентированном программировании (ООП) важны отношения между классами и объектами. Обобщение, реализация и зависимость — это ключевые типы отношений, которые помогают организовывать и проектировать системы на основе принципов ООП. Рассмотрим каждый из этих типов:

### 3. **Обобщение (Generalization)**

**Обобщение** — это отношение "является" (is-a), которое описывает наследование между классами. Обобщение подразумевает, что один класс является общим представлением для других, более специализированных классов. Это означает, что производный (дочерний) класс наследует поведение и свойства базового (родительского) класса.

- **Пример:** "Кошка" является "Животным" — класс `Cat` наследует свойства и методы класса `Animal`.

**Пример обобщения в Java:**
```java
class Animal {
    public void eat() {
        System.out.println("Animal is eating");
    }
}

class Cat extends Animal {
    public void meow() {
        System.out.println("Cat is meowing");
    }
}

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.eat();  // Наследует метод от Animal
        cat.meow(); // Свой метод
    }
}
```

В этом примере `Cat` является подклассом `Animal`, и наследует его методы (обобщение).

### 4. **Реализация (Realization)**

**Реализация** — это отношение между интерфейсом и классом, который этот интерфейс реализует. В Java интерфейсы содержат только сигнатуры методов, а классы, которые их реализуют, предоставляют конкретные реализации этих методов.

- **Пример:** Класс `Car` реализует интерфейс `Vehicle`, который определяет, как должны работать транспортные средства.

**Пример реализации в Java:**
```java
interface Vehicle {
    void start();
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car is starting");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.start();  // Вызов метода, реализованного в Car
    }
}
```

В этом примере класс `Car` реализует интерфейс `Vehicle`, предоставляя конкретную реализацию метода `start()`.

### 5. **Зависимость (Dependency)**

**Зависимость** — это слабое отношение между двумя классами, когда один класс использует другой в качестве параметра или временно создает объект другого класса для выполнения некоторых действий. Зависимость обычно проявляется в том, что один класс вызывает методы другого класса. Это означает, что изменение одного класса может повлиять на другой, но они не находятся в постоянной связи.

- **Пример:** Класс `Person` зависит от класса `Car`, потому что он использует автомобиль для передвижения, но не владеет им напрямую.

**Пример зависимости в Java:**
```java
class Car {
    public void drive() {
        System.out.println("Car is driving");
    }
}

class Person {
    public void driveCar(Car car) {
        car.drive();
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Person person = new Person();
        person.driveCar(car);  // Person зависит от Car для выполнения действия
    }
}
```

В этом примере класс `Person` зависит от объекта `Car`, потому что он использует его для выполнения действия, но сам не владеет объектом `Car` напрямую.


