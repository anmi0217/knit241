- Пользователь вводит **мастер-пароль** один раз при запуске приложения.
- Этот мастер-пароль используется для **AES-шифрования** всех сохраняемых паролей.
- Для упрощения мастер-пароль не сохраняется — используется только в памяти.

---

## 🔧 Шаги по реализации

### 1. Интерфейс `EncryptionService`

```java
public interface EncryptionService {
    String encrypt(String input);
    String decrypt(String input);
}
```

---

### 2. Реализация `AesEncryptionService.java` с мастер-паролем

```java
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.*;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

@Component
public class AesEncryptionService implements EncryptionService {

    private static final String SECRET_ALGO = "AES/CBC/PKCS5Padding";
    private static final String SECRET_KEY_ALGO = "PBKDF2WithHmacSHA256";
    private static final byte[] IV = "1234567890abcdef".getBytes(); // 16-byte IV (пример)
    private static final byte[] SALT = "my-salt-value".getBytes(); // можно заменить

    private final SecretKey secretKey;

    public AesEncryptionService(MasterPasswordHolder holder) {
        this.secretKey = generateKeyFromPassword(holder.getMasterPassword());
    }

    private SecretKey generateKeyFromPassword(String password) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_ALGO);
            KeySpec spec = new PBEKeySpec(password.toCharArray(), SALT, 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            return new SecretKeySpec(tmp.getEncoded(), "AES");
        } catch (Exception e) {
            throw new RuntimeException("Ошибка генерации ключа", e);
        }
    }

    @Override
    public String encrypt(String input) {
        try {
            Cipher cipher = Cipher.getInstance(SECRET_ALGO);
            IvParameterSpec ivSpec = new IvParameterSpec(IV);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
            byte[] encrypted = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка шифрования", e);
        }
    }

    @Override
    public String decrypt(String input) {
        try {
            Cipher cipher = Cipher.getInstance(SECRET_ALGO);
            IvParameterSpec ivSpec = new IvParameterSpec(IV);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
            byte[] decoded = Base64.getDecoder().decode(input);
            byte[] decrypted = cipher.doFinal(decoded);
            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка дешифровки", e);
        }
    }
}
```

---

### 3. Класс `MasterPasswordHolder.java` — хранит мастер-пароль в памяти

```java
import org.springframework.stereotype.Component;

@Component
public class MasterPasswordHolder {
    private String masterPassword;

    public void setMasterPassword(String masterPassword) {
        this.masterPassword = masterPassword;
    }

    public String getMasterPassword() {
        return masterPassword;
    }
}
```

---

### 4. Установка мастер-пароля при запуске

В `App.java` (или JavaFX `start()` методе):

```java
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

// Получаем бин и задаём мастер-пароль
MasterPasswordHolder passwordHolder = context.getBean(MasterPasswordHolder.class);

Scanner scanner = new Scanner(System.in);
System.out.print("Введите мастер-пароль: ");
String masterPassword = scanner.nextLine();

passwordHolder.setMasterPassword(masterPassword);
```

➡️ Теперь при создании `AesEncryptionService` Spring передаёт ему `MasterPasswordHolder`, откуда берётся мастер-пароль, и создаётся ключ для шифрования.

---

## ✅ Результат:
- Все сохранённые пароли будут **зашифрованы AES**.
- Пароли можно **расшифровать только при наличии правильного мастер-пароля**.
- Мастер-пароль не сохраняется, и при перезапуске вводится заново.

