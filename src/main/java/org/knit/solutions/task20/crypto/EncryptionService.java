package org.knit.solutions.task20.crypto;

public interface EncryptionService {
    String encrypt(String input);
    String decrypt(String input);
}