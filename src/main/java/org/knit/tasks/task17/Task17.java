package org.knit.tasks.task17;

public class Task17 {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User(null, "LongUsername", 16);
        Validator.validate(user);
    }
}
