package org.knit.solutions.org2.lab20.crypto;

public interface EncryptionService {
    String encrypt(String data, char[] masterPassword) throws Exception;
    String decrypt(String encryptedData, char[] masterPassword) throws Exception;
}