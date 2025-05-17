package org.knit.solutions.org2.lab20.repository;

import org.knit.solutions.org2.lab20.model.PasswordEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryPasswordRepository implements PasswordRepository {
    private final Map<String, PasswordEntry> entries = new HashMap<>();

    @Override
    public void addEntry(PasswordEntry entry) {
        entries.put(entry.getSite(), entry);
    }

    @Override
    public PasswordEntry getEntry(String site) {
        return entries.get(site);
    }

    @Override
    public List<PasswordEntry> getAllEntries() {
        return new ArrayList<>(entries.values());
    }

    @Override
    public void deleteEntry(String site) {
        entries.remove(site);
    }

    @Override
    public void saveData() {
        // Реализация сохранения данных будет добавлена позже
    }

    @Override
    public void loadData() {
        // Реализация загрузки данных будет добавлена позже
    }
}