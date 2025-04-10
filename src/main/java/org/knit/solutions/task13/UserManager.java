package org.knit.solutions.task13;

import java.io.*;
import java.util.List;

public class UserManager {
    private static final String FILE_PATH = "src/main/java/org/knit/tasks/task13/users.ser";

    public static void uploadUsers(List<User> users) throws IOException {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            stream.writeObject(users);
        }
    }

    public static List<User> downloadUsers() throws IOException, ClassNotFoundException {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<User>) stream.readObject();
        }
    }
}
