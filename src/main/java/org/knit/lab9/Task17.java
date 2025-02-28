package org.knit.lab9;

public class Task17 {
    public void execute() throws IllegalAccessException {
        User user = new User(null, "LongUsernameHere", 16);
        Validator.validate(user);
    }
}
