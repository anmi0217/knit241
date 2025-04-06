## 🖼️ Интеграция JavaFX и Spring

### 🔧 Что нужно:
- Java 11
- Maven
- JavaFX SDK (или плагин javafx-maven-plugin)
- Spring Core (без Spring Boot)

---

## 📁 Структура проекта (дополненная)

```
PasswordManager/
├── config/
│   └── AppConfig.java
├── controller/
│   └── MainController.java
├── model/
│   └── PasswordEntry.java
├── repository/
│   └── InMemoryPasswordRepository.java
├── service/
│   └── PasswordService.java
├── ui/
│   └── main-view.fxml
├── App.java
└── pom.xml
```

---

## ⚙️ `pom.xml` — зависимости

```xml
<properties>
    <java.version>11</java.version>
    <javafx.version>17.0.2</javafx.version>
</properties>

<dependencies>
    <!-- Spring -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.30</version>
    </dependency>

    <!-- JavaFX -->
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>${javafx.version}</version>
    </dependency>
</dependencies>

<build>
    <plugins>
        <!-- JavaFX Plugin -->
        <plugin>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-maven-plugin</artifactId>
            <version>0.0.8</version>
            <executions>
                <execution>
                    <id>default-cli</id>
                    <configuration>
                        <mainClass>your.package.App</mainClass>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

---

## 📄 `App.java` — точка входа и Spring Context

```java
public class App extends Application {

    private static AnnotationConfigApplicationContext context;

    @Override
    public void init() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/main-view.fxml"));
        
        // внедрение Spring-бина как контроллера
        loader.setControllerFactory(context::getBean);
        
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Password Manager");
        primaryStage.show();
    }

    @Override
    public void stop() {
        context.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

---

## 🎮 `main-view.fxml` — UI-шаблон

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>

<VBox spacing="10" alignment="CENTER" xmlns="http://javafx.com/javafx" xmlns:fx="http://javafx.com/fxml"
      fx:controller="your.package.controller.MainController">
    <TextField fx:id="siteField" promptText="Site"/>
    <TextField fx:id="loginField" promptText="Login"/>
    <TextField fx:id="passwordField" promptText="Password"/>

    <HBox spacing="10">
        <Button text="Add" onAction="#onAdd"/>
        <Button text="Delete" onAction="#onDelete"/>
    </HBox>

    <TableView fx:id="table">
        <columns>
            <TableColumn fx:id="siteColumn" text="Site"/>
            <TableColumn fx:id="loginColumn" text="Login"/>
            <TableColumn fx:id="passwordColumn" text="Password"/>
        </columns>
    </TableView>
</VBox>
```

---

## 🎯 `MainController.java`

```java
@Component
public class MainController {

    @FXML private TextField siteField;
    @FXML private TextField loginField;
    @FXML private TextField passwordField;
    @FXML private TableView<PasswordEntry> table;
    @FXML private TableColumn<PasswordEntry, String> siteColumn;
    @FXML private TableColumn<PasswordEntry, String> loginColumn;
    @FXML private TableColumn<PasswordEntry, String> passwordColumn;

    private final PasswordService passwordService;

    public MainController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @FXML
    public void initialize() {
        siteColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSite()));
        loginColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLogin()));
        passwordColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPassword()));

        refreshTable();
    }

    @FXML
    public void onAdd() {
        passwordService.addPassword(
                siteField.getText(),
                loginField.getText(),
                passwordField.getText()
        );
        clearFields();
        refreshTable();
    }

    @FXML
    public void onDelete() {
        PasswordEntry selected = table.getSelectionModel().getSelectedItem();
        if (selected != null) {
            passwordService.deletePassword(selected.getSite());
            refreshTable();
        }
    }

    private void refreshTable() {
        table.getItems().setAll(passwordService.getAllPasswords());
    }

    private void clearFields() {
        siteField.clear();
        loginField.clear();
        passwordField.clear();
    }
}
```

---

## 🧠 Советы по JavaFX + Spring:
- Используйте `@Component` на контроллере.
- Не используйте `@Autowired` в JavaFX контроллере напрямую — внедряйте зависимости через **конструктор** и `loader.setControllerFactory(...)`.
- FXML должен находиться в `src/main/resources`.

---
