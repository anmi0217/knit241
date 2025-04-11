package org.knit.solutions.task20.model;

public class PasswordEntry {
    private String site;
    private String login;
    private String encryptedPassword;

    public PasswordEntry(String site, String login, String encryptedPassword){
        this.site = site;
        this.login = login;
        this.encryptedPassword = encryptedPassword;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public String getLogin() {
        return login;
    }

    public String getSite() {
        return site;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
