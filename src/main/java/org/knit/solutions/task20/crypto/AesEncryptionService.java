package org.knit.solutions.task20.crypto;

import org.knit.solutions.task20.security.MasterPasswordHolder;
import org.springframework.context.annotation.Lazy;
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
    private static final byte[] IV = "1234567890abcdef".getBytes();
    private static final byte[] SALT = "my-salt-value".getBytes();

    private final SecretKey secretKey;

    @Lazy
    public AesEncryptionService(MasterPasswordHolder holder) {
        this.secretKey = generateKeyFromPassword(holder.getMasterPassword());
    }

    private SecretKey generateKeyFromPassword(String password) {
        if (password == null) {
            throw new IllegalStateException("Мастер-пароль не установлен!");
        }
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
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(IV));
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
            cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(IV));
            byte[] decoded = Base64.getDecoder().decode(input);
            byte[] decrypted = cipher.doFinal(decoded);
            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка дешифровки", e);
        }
    }
}
