package org.knit.solutions.task24;

import java.util.List;

public interface UserDAO {
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    User getUserById(int id);

    List<User> getAllUsers();

    boolean isEmailNotExists(String email);
}
