### **Лабораторная работа # 2.1: Паттерны проектирования**

#### **Задача 2.1 Chain of Responsibility (Цепочка обязанностей)**
**Описание:**  
Этот паттерн используется для передачи запроса по цепочке обработчиков, пока один из них не обработает его. Каждый обработчик в цепочке может либо обработать запрос, либо передать его дальше.

**Пример из жизни:**  
Рассмотрим систему поддержки пользователей. Запрос от клиента сначала поступает к оператору первого уровня (обычный оператор), затем, если он не может решить проблему, передается специалисту второго уровня (инженеру), а если и он не справляется – ведущему инженеру.

**Задача:**  
Реализуйте систему обработки жалоб клиентов в банке.
1. Жалоба сначала поступает в колл-центр.
2. Если проблема сложная, запрос передается менеджеру. 
3. Если даже менеджер не может решить проблему, запрос уходит в юридический отдел.
4. Каждый уровень обработки либо решает проблему, либо передает ее дальше. (не менее 4х уровней поддержки) 
5. Представить проблему в виде объекта, с описанием, уровнем сложности.


![chain.png](..%2Fcommon%2Fchain.png)

>Подсказка

```java
// Абстрактный класс обработчика
abstract class Approver {
    protected Approver nextApprover; // Следующий обработчик в цепочке

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public void processRequest(int amount) {
        if (canApprove(amount)) {
            approve(amount);
        } else if (nextApprover != null) {
            nextApprover.processRequest(amount); // Передача запроса дальше
        } else {
            System.out.println("Запрос на сумму $" + amount + " отклонен: превышает лимит.");
        }
    }

    protected abstract boolean canApprove(int amount); // Проверка лимита
    protected abstract void approve(int amount); // Логика одобрения
}

// Конкретные обработчики
class JuniorManager extends Approver {
    @Override
    protected boolean canApprove(int amount) {
        return amount <= 1000;
    }

    @Override
    protected void approve(int amount) {
        System.out.println("Младший менеджер одобрил запрос на $" + amount);
    }
}

class SeniorManager extends Approver {
    @Override
    protected boolean canApprove(int amount) {
        return amount <= 10000;
    }

    @Override
    protected void approve(int amount) {
        System.out.println("Старший менеджер одобрил запрос на $" + amount);
    }
}

class Director extends Approver {
    @Override
    protected boolean canApprove(int amount) {
        return amount <= 50000; // Директор одобряет до 50,000
    }

    @Override
    protected void approve(int amount) {
        System.out.println("Директор одобрил запрос на $" + amount);
    }
}

// Демонстрация работы цепочки
public class Main {
    public static void main(String[] args) {
        // Создаем обработчиков
        Approver junior = new JuniorManager();
        Approver senior = new SeniorManager();
        Approver director = new Director();

        // Устанавливаем цепочку: junior -> senior -> director
        junior.setNextApprover(senior);
        senior.setNextApprover(director);

        // Запросы на одобрение разных сумм
        junior.processRequest(500);   // Младший менеджер одобряет
        junior.processRequest(5000);  // Старший менеджер одобряет
        junior.processRequest(20000); // Директор одобряет
        junior.processRequest(100000); // Превышает лимит – запрос отклонен
    }
}

```
---


#### **Задача 2.2 Decorator (Декоратор)**
**Описание:**  
Декоратор позволяет динамически добавлять новую функциональность объектам без изменения их кода. Это достигается путем обертывания объектов в дополнительные классы.

**Пример из жизни:**  
Рассмотрим кофейню, где клиент может заказывать кофе с различными добавками. Вместо создания отдельных классов для каждого вида кофе, можно использовать декораторы:
- Основной кофе
- Декораторы: сахар, молоко, карамель и т. д.

**Задача:**  
Реализуйте систему онлайн-заказов кофе.
1. У вас есть базовый класс `Coffee`, который имеет метод `getCost()` и `getDescription()`.
2. Напишите декораторы для добавления различных ингредиентов (молоко, карамель, шоколад).
3. Каждый декоратор изменяет стоимость и описание кофе.
4. Расширьте решение, добавив калорийность и разные виды напитков

Пример клиента для решения![img.png](img.png)

```java
public class Main {
    public static void main(String[] args) {
        // Базовый кофе
        Coffee coffee = new Espresso();
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        // Добавляем размер (medium)
        coffee = new SizeDecorator(coffee, "medium");
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        // Добавляем молоко
        coffee = new Milk(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        // Добавляем карамель
        coffee = new Caramel(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        // Добавляем шоколад
        coffee = new Chocolate(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");
    }
}
```
Вывод
```
Эспрессо | Цена: $2.5 | Калорийность: 5 ккал
MEDIUM Эспрессо | Цена: $3.0 | Калорийность: 25 ккал
MEDIUM Эспрессо, молоко | Цена: $3.5 | Калорийность: 75 ккал
MEDIUM Эспрессо, молоко, карамель | Цена: $4.25 | Калорийность: 135 ккал
MEDIUM Эспрессо, молоко, карамель, шоколад | Цена: $5.25 | Калорийность: 215 ккал
```

![decorator.png](..%2Fcommon%2Fdecorator.png)

> Подсказка

```java
// 1. Базовый интерфейс для пиццы
interface Pizza {
    double getCost();         // Цена пиццы
    String getDescription();  // Описание пиццы
}

// 2. Конкретная реализация пиццы (базовый объект)
class MargheritaPizza implements Pizza {
    @Override
    public double getCost() {
        return 5.00; // Цена базовой пиццы
    }

    @Override
    public String getDescription() {
        return "Маргарита (томаты, сыр, базилик)";
    }
}

// 3. Абстрактный класс-декоратор (наследуется от Pizza)
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza; // Оборачиваемый объект

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }
}

// 4. Конкретные декораторы (добавки)
class Cheese extends PizzaDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.50; // Добавляем цену сыра
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", сыр";
    }
}

class Olives extends PizzaDecorator {
    public Olives(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.75; // Добавляем цену оливок
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", оливки";
    }
}

class Bacon extends PizzaDecorator {
    public Bacon(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.00; // Добавляем цену бекона
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", бекон";
    }
}

// 5. Демонстрация использования
public class Main {
    public static void main(String[] args) {
        // Создаем базовую пиццу Маргарита
        Pizza pizza = new MargheritaPizza();
        System.out.println(pizza.getDescription() + " | Цена: $" + pizza.getCost());

        // Добавляем сыр
        pizza = new Cheese(pizza);
        System.out.println(pizza.getDescription() + " | Цена: $" + pizza.getCost());

        // Добавляем оливки
        pizza = new Olives(pizza);
        System.out.println(pizza.getDescription() + " | Цена: $" + pizza.getCost());

        // Добавляем бекон
        pizza = new Bacon(pizza);
        System.out.println(pizza.getDescription() + " | Цена: $" + pizza.getCost());
    }
}

```
---

### **2.3 Factory (Фабрика)**
**Описание:**  
Паттерн Factory используется для создания объектов без указания конкретного класса. Это полезно, когда необходимо создавать объекты на основе входных параметров и логики выбора.

**Пример из жизни:**  
Представьте систему бронирования транспортных средств. В зависимости от типа поездки клиенту предлагается соответствующий вид транспорта: для деловой поездки – бизнес-седан, для семейного отдыха – минивэн, а для экспресс-доставки – мотоцикл.

**Задача:**  
Реализуйте фабрику по созданию различных видов транспортных средств в системе каршеринга.
1. **Создайте интерфейс `Transport`** с методом `getSpecifications()`, который возвращает характеристики транспортного средства.
2. **Создайте классы `BusinessCar`, `FamilyVan` и `Motorbike`**, реализующие `Transport`.
    - `BusinessCar` должен иметь комфортный салон и кожаные сиденья.
    - `FamilyVan` должен поддерживать перевозку 6+ пассажиров.
    - `Motorbike` предназначен для быстрой доставки.
3. **Создайте класс `TransportFactory`**, который:
    - Принимает параметр типа поездки (`"business"`, `"family"`, `"delivery"`).
    - Возвращает соответствующий объект (`BusinessCar`, `FamilyVan`, `Motorbike`).
4. Добавьте обработку исключений, если передан неизвестный тип транспорта.
5. Вызов `TransportFactory.createTransport("business")` должен возвращать объект `BusinessCar`.

![fabric.png](..%2Fcommon%2Ffabric.png)