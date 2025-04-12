package org.knit.solutions.task20.repository;

import org.knit.solutions.task20.model.PasswordEntry;

import java.util.List;

public interface PasswordRepository {
    void save(PasswordEntry passwordEntry);
    void deleteBySite(String site);
    PasswordEntry findBySite(String site);
    List<PasswordEntry> findAll();
}
