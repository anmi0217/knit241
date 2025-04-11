package org.knit.solutions.task20.security;

import org.knit.solutions.task20.repository.InMemoryPasswordRepository;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MasterPasswordHolder {
    private final InMemoryPasswordRepository repository;
    private String masterPassword;


    public MasterPasswordHolder(InMemoryPasswordRepository repository) {
        this.repository = repository;
        masterPassword = repository.getMasterPassword();
        if (masterPassword == null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите мастер-пароль: ");
            String masterPassword = scanner.nextLine();
            setMasterPassword(masterPassword);
        }
    }

    public void setMasterPassword(String masterPassword) {
        this.masterPassword = masterPassword;
    }

    public String getMasterPassword() {
        return masterPassword;
    }

    public void clear() {
        if (masterPassword != null) {
            masterPassword = null;
        }
    }
}