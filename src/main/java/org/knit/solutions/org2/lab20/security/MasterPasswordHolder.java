package org.knit.solutions.org2.lab20.security;

import org.springframework.stereotype.Component;

@Component
public class MasterPasswordHolder {
    private char[] masterPassword;

    public void setMasterPassword(char[] masterPassword) {
        this.masterPassword = masterPassword;
    }

    public char[] getMasterPassword() {
        return masterPassword;
    }

    public void clear() {
        if (masterPassword != null) {
            for (int i = 0; i < masterPassword.length; i++) {
                masterPassword[i] = '\0';
            }
            masterPassword = null;
        }
    }
}