package org.knit.solutions.task20.repository;

import org.knit.solutions.task20.model.PasswordEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryPasswordRepository implements PasswordRepository {
    private final Map<String, PasswordEntry> storage = new HashMap<>();
    private String masterPassword;

    // Сохраняем мастер-пароль
    public void setMasterPassword(String masterPassword) {
        this.masterPassword = masterPassword;
    }

    // Получаем мастер-пароль
    public String getMasterPassword() {
        return masterPassword;
    }

    @Override
    public void save(PasswordEntry entry) {
        storage.put(entry.getSite(), entry);
    }

    @Override
    public void deleteBySite(String site) {
        storage.remove(site);
    }

    @Override
    public List<PasswordEntry> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public PasswordEntry findBySite(String site) {
        return storage.get(site);
    }
}