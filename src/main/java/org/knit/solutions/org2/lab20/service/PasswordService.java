package org.knit.solutions.org2.lab20.service;

import org.knit.solutions.org2.lab20.clipboard.ClipboardService;
import org.knit.solutions.org2.lab20.crypto.EncryptionService;
import org.knit.solutions.org2.lab20.model.PasswordEntry;
import org.springframework.stereotype.Service;
import org.knit.solutions.org2.lab20.repository.PasswordRepository;
import org.knit.solutions.org2.lab20.security.MasterPasswordHolder;

import java.util.List;

@Service
public class PasswordService {
    private final PasswordRepository passwordRepository;
    private final EncryptionService encryptionService;
    private final ClipboardService clipboardService;
    private final MasterPasswordHolder masterPasswordHolder;

    public PasswordService(PasswordRepository passwordRepository,
                           EncryptionService encryptionService,
                           ClipboardService clipboardService,
                           MasterPasswordHolder masterPasswordHolder) {
        this.passwordRepository = passwordRepository;
        this.encryptionService = encryptionService;
        this.clipboardService = clipboardService;
        this.masterPasswordHolder = masterPasswordHolder;
    }

    public void addEntry(String site, String login, String password) throws Exception {
        String encryptedPassword = encryptionService.encrypt(password, masterPasswordHolder.getMasterPassword());
        PasswordEntry entry = new PasswordEntry(site, login, encryptedPassword);
        passwordRepository.addEntry(entry);
    }

    public List<PasswordEntry> getAllEntries() {
        return passwordRepository.getAllEntries();
    }

    public void copyPasswordToClipboard(String site) throws Exception {
        PasswordEntry entry = passwordRepository.getEntry(site);
        if (entry != null) {
            String decryptedPassword = encryptionService.decrypt(
                    entry.getEncryptedPassword(),
                    masterPasswordHolder.getMasterPassword()
            );
            clipboardService.copyToClipboard(decryptedPassword);
        }
    }

    public void deleteEntry(String site) {
        passwordRepository.deleteEntry(site);
    }
}