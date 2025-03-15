### **3. Дополнительные принципы проектирования**

---

## **3.1. KISS (Keep It Simple, Stupid)**
**"Делай проще, глупец"** – этот принцип говорит о том, что код должен быть максимально **простым и понятным**.

### ❌ **Плохой пример (Нарушение KISS)**
Чрезмерно сложный код, который можно упростить:
```java
public class MathUtil {
    public static int findMax(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}
```
**Проблема:**
- Логика избыточна – `if-else` не нужен.

✅ **Хороший пример (Применение KISS)**
```java
public class MathUtil {
    public static int findMax(int a, int b) {
        return Math.max(a, b);
    }
}
```
**Что улучшилось?**
- **Код стал короче**.
- **Читаемость повысилась** – теперь все понятно **с одного взгляда**.

### 🔹 **Как применять KISS?**
- Уменьшайте **сложность кода** (избегайте ненужных условий, вложенных циклов).
- Используйте **стандартные API** (не нужно изобретать свое колесо).
- Код должен быть **самодокументируемым** – если требуется много комментариев, скорее всего, код можно упростить.

---

## **3.2. DRY (Don't Repeat Yourself)**
**"Не повторяйся"** – этот принцип говорит, что **код не должен содержать дублирования**.

### ❌ **Плохой пример (Нарушение DRY)**
```java
public class OrderService {
    public double calculateTotalPrice(List<Double> prices) {
        double total = 0;
        for (double price : prices) {
            total += price;
        }
        return total;
    }
}

public class InvoiceService {
    public double calculateInvoiceTotal(List<Double> prices) {
        double total = 0;
        for (double price : prices) {
            total += price;
        }
        return total;
    }
}
```
**Проблема:**
- Один и тот же код **повторяется** в разных местах.

✅ **Хороший пример (Применение DRY)**
```java
public class PriceCalculator {
    public static double calculateTotal(List<Double> prices) {
        return prices.stream().mapToDouble(Double::doubleValue).sum();
    }
}

public class OrderService {
    public double calculateTotalPrice(List<Double> prices) {
        return PriceCalculator.calculateTotal(prices);
    }
}

public class InvoiceService {
    public double calculateInvoiceTotal(List<Double> prices) {
        return PriceCalculator.calculateTotal(prices);
    }
}
```
**Что улучшилось?**
- **Код стал переиспользуемым** – теперь логика вычисления вынесена в отдельный метод.
- **Если потребуется изменить логику, нужно править только в одном месте**.

### 🔹 **Как применять DRY?**
- Используйте **методы и классы повторно**, не копируйте код.
- Выносите общие части в **утилитарные классы**.
- Используйте **наследование и композицию**, чтобы избежать дублирования кода.

---

## **3.3. YAGNI (You Ain’t Gonna Need It)**
**"Вам это не понадобится"** – принцип, который предостерегает от **добавления функционала, который сейчас не нужен**.

### ❌ **Плохой пример (Нарушение YAGNI)**
```java
public class ReportGenerator {
    public void generateReport(String format) {
        if (format.equals("PDF")) {
            // Генерация PDF
        } else if (format.equals("Excel")) {
            // Генерация Excel
        } else if (format.equals("CSV")) {
            // Генерация CSV
        } else if (format.equals("XML")) {
            // XML (вдруг когда-нибудь понадобится?)
        }
    }
}
```
**Проблема:**
- Поддержка **ненужных форматов** (XML), которые **никто не запрашивал**.
- Усложнение кода, которое может **никогда не пригодиться**.

✅ **Хороший пример (Применение YAGNI)**
```java
public class ReportGenerator {
    public void generateReport(String format) {
        if (format.equals("PDF")) {
            // Генерация PDF
        } else if (format.equals("Excel")) {
            // Генерация Excel
        }
    }
}
```
**Что улучшилось?**
- Код стал **проще и чище**.
- **Не добавлено ненужного функционала** – если понадобится XML, его можно добавить позже.

### 🔹 **Как применять YAGNI?**
- **Не пишите код "на будущее"**, если он не нужен прямо сейчас.
- **Добавляйте новую функциональность только тогда, когда она действительно требуется**.
- **Избегайте преждевременной оптимизации** – сначала **пишите простой и рабочий код**.

---

### **Вывод**
- **KISS** – код должен быть простым.
- **DRY** – избегайте дублирования.
- **YAGNI** – не пишите лишнего кода.
