package org.knit.solutions.org2.lab20.repository;

import org.knit.solutions.org2.lab20.model.PasswordEntry;
import java.util.List;

public interface PasswordRepository {
    void addEntry(PasswordEntry entry);
    PasswordEntry getEntry(String site);
    List<PasswordEntry> getAllEntries();
    void deleteEntry(String site);
    void saveData();
    void loadData();
}