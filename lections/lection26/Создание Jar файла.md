## Сборка Jar файла с зависимостями
---

### ✅ Шаги:

#### 📄 1. Добавь в `pom.xml` плагин:

```xml
<build>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*</include>
            </includes>
        </resource>
    </resources>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-shade-plugin</artifactId>
      <version>3.5.0</version>
      <executions>
        <execution>
          <phase>package</phase>
          <goals>
            <goal>shade</goal>
          </goals>
          <configuration>
            <transformers>
              <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                <mainClass>com.example.Main</mainClass> 
              </transformer>
            </transformers>
          </configuration>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
```

> 🔁 Заменить `com.example.Main` на твой основной класс, где `public static void main(String[] args)`.

---

#### ▶️ 2. Собери проект:
```bash
mvn clean package
```

---

#### 📦 3. Готовый запускаемый JAR будет в:
```
target/имя-проекта-версия-shaded.jar
```

Пример:
```
target/password-manager-1.0-SNAPSHOT-shaded.jar
```

---

#### 🚀 4. Запусти JAR:
```bash
java -jar target/your-app-name-version-shaded.jar
```

---

