### **5. Архитектурный паттерн MVC (Model-View-Controller)**

**MVC (Model-View-Controller)** — это один из самых популярных архитектурных паттернов, который помогает разделять **бизнес-логику, интерфейс пользователя и управление потоком данных**.

🔹 **Зачем нужен MVC?**
- Упрощает поддержку и расширение кода.
- Разделяет логику приложения и отображение.
- Позволяет менять UI без изменения бизнес-логики.

---

## **Компоненты MVC**
### **1. Model (Модель)**
📌 **Отвечает за бизнес-логику и хранение данных.**
- Выполняет вычисления, запросы в базу данных.
- Не зависит от интерфейса пользователя.

### **2. View (Представление)**
📌 **Отвечает за отображение данных пользователю.**
- Может быть консоль, графический интерфейс (Swing, JavaFX) или веб (HTML, JSP).
- Не должна содержать бизнес-логику.

### **3. Controller (Контроллер)**
📌 **Связывает Model и View.**
- Обрабатывает пользовательские действия (нажатия кнопок, ввод данных).
- Передает данные от модели в представление.

---

## **Примеры реализации MVC в Java**
Рассмотрим реализацию **простого калькулятора (Swing)** с использованием MVC.

Вот доработанная версия приложения **MVC**, где теперь есть **два View**:
1. **Графический интерфейс (Swing)**
2. **Консольный интерфейс**

Оба представления работают **параллельно**, а данные передаются через **единую модель**.

---

### **Обновленный код**
#### **1. Model (Модель) — без изменений**
```java
public class CalculatorModel {
    private int result;

    public void add(int num1, int num2) {
        result = num1 + num2;
    }

    public int getResult() {
        return result;
    }
}
```

---

#### **2. View (Графический интерфейс Swing)**
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private JTextField num1Field = new JTextField(5);
    private JTextField num2Field = new JTextField(5);
    private JButton addButton = new JButton("Добавить");
    private JTextField resultField = new JTextField(5);

    public CalculatorView() {
        setLayout(new FlowLayout());
        add(new JLabel("Число 1:"));
        add(num1Field);
        add(new JLabel("Число 2:"));
        add(num2Field);
        add(addButton);
        add(new JLabel("Результат:"));
        add(resultField);
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int getNum1() {
        return Integer.parseInt(num1Field.getText());
    }

    public int getNum2() {
        return Integer.parseInt(num2Field.getText());
    }

    public void setResult(int result) {
        resultField.setText(String.valueOf(result));
    }

    public void addCalculateListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }
}
```

---

#### **3. View (Консольный интерфейс)**
Теперь у нас есть **второе представление** (консоль), которое взаимодействует с пользователем **через Scanner**.

```java
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);

    public int getNum1() {
        System.out.print("Введите первое число: ");
        return scanner.nextInt();
    }

    public int getNum2() {
        System.out.print("Введите второе число: ");
        return scanner.nextInt();
    }

    public void showResult(int result) {
        System.out.println("Результат: " + result);
    }
}
```

---

#### **4. Controller **
Теперь контроллер поддерживает **оба View** и работает с моделью.

```java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;
    private ConsoleView consoleView;

    public CalculatorController(CalculatorModel model, CalculatorView view, ConsoleView consoleView) {
        this.model = model;
        this.view = view;
        this.consoleView = consoleView;

        this.view.addCalculateListener(new CalculateListener());

        // Запускаем консольный интерфейс в отдельном потоке
        new Thread(this::runConsoleInterface).start();
    }

    class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int num1 = view.getNum1();
            int num2 = view.getNum2();
            model.add(num1, num2);
            view.setResult(model.getResult());
        }
    }

    private void runConsoleInterface() {
        while (true) {
            int num1 = consoleView.getNum1();
            int num2 = consoleView.getNum2();
            model.add(num1, num2);
            consoleView.showResult(model.getResult());
        }
    }
}
```

---

#### **5. Main (Запуск приложения)**
Теперь мы создаем **оба View** и передаем их в контроллер.

```java
public class Main {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView swingView = new CalculatorView();
        ConsoleView consoleView = new ConsoleView();
        new CalculatorController(model, swingView, consoleView);

        swingView.setVisible(true);
    }
}
```

---

### **Как это работает?**
1. **Графический интерфейс (Swing)**
    - Запускается окно, где можно ввести два числа и нажать "Добавить".
    - Результат отобразится в поле "Результат".

2. **Консольный интерфейс**
    - Вводим два числа в терминале.
    - Видим результат сложения.
    - Процесс повторяется бесконечно, пока не закрыть программу.

---

### **Вывод**
Теперь наше **MVC-приложение** поддерживает **два представления (GUI + консоль)**, используя **одну модель**.

📌 **Дополнительные улучшения:**
- Можно добавить поддержку **умножения, деления, вычитания**.
- Можно организовать ввод команд в консоли (`exit`, `clear`).

**Если нужны доработки — пиши! 🚀**
---

## **Примеры MVC в популярных фреймворках**
- **Spring MVC** — используется для веб-приложений (REST API, JSP, Thymeleaf).
- **JavaFX** — для десктопных GUI-приложений (разделение через `FXML`).
- **Swing (AWT)** — для старых GUI-приложений.

---

### **Вывод**
- **Model** — хранит данные и выполняет вычисления.
- **View** — отвечает за отображение.
- **Controller** — управляет взаимодействием Model и View.