# Лабораторная работа № 3

## Цель работы:
- Научиться моделировать объекты используя принципы ООП

**Задача № 6** *

Смоделировать персонажей классической 2d RPG

Дана следующая иерархия:

### Общий класс персонаж Player

Player должен иметь свойства:
- Имя
- Текущее здоровье
- Максимальное здоровье
- Статус (жив/мертв)  
- Позиция X 
- Позиция Y
- урон
- защита

Player должен иметь поведение:
- увеличить здоровье
- уменьшить здоровье
- подвинуться на позицию x и y


### Подклассы

- Персонаж может выбрать класс Mage, Priest, Warrior
- Воин имеет подтип Guard
### Поведение
- Маг умеет бросать атакующее заклинание на любого игрока
- Священник умеет лечить другого игрока
- Воин умеет атаковать любого игрока

### Свойства
- Tank имеет бонусное свойство Дополнительная защита


## Задание 
 Создайте соответствующую иерархию классов. Добавьте интерфейсы там где это необходимо.
Постарайтесь вывести в консоль как можно больше информации. Переопределите метод toString для классов.

### подсказки

Класс клиент (класс где будут использоваться объекты) 

```java
WarriorTank warrior = new WarriorGuard("Some Ork");
Mage mage = new Mage("Some Mage");
Priest priest = new Priest("Some Healer");
warrior.attak(mage);
priest.heal(mage);
mage.castSpell(warrior);


```

Пример реализации метода attak и heal
```java
void heal(Player player) {
    player.increaseHealth(healPower);
}

void attak(Player player) {
    player.decreaseHealth(attakPower);
}

```

Пример реализации метода decreaseHealth для Player

```java
void decreaseHealth(int value){
    health = health + defence - value;
    if (health < 0){
        isAlife = false;
    }
}

```

Пример переопределения метода decreaseHealth для Warrior с подтипом Tank

```java
/*
 * /.../ 
 * */

private int additionalDefence = 10;

@Override
void decreaseHealth(int value){
    health = defence + additionalDefence -  value;
    if (health < 0){
        isAlife = false;
    }
}
```
---


### Дополнительное задание  -  Усложнить 
- Добавить в класс Player ссылку на класс Race который дает бонусы (Защита, Атака, Лечение, Заклинания) и внести правки в код для учета этих бонусов
- Воин не может нанести урон если его позиция дальше его радиуса атаки. 


