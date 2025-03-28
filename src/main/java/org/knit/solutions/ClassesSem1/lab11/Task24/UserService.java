package org.knit.solutions.ClassesSem1.lab11.Task24;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService() throws SQLException {
        this.userDAO = new UserDAOImpl();
    }

    public void registerUser(String name, String email) throws SQLException {
        if (name == null || name.isEmpty()) {
            System.out.println("Имя не должно быть пустым.");
        } else if (email == null || email.isEmpty()) {
            System.out.println("Email не должен быть пуст.");
        } else if (userDAO.emailExists(email)) {
            System.out.println("Email уже существует!");
        } else {
            User user = new User(0, name, email);
            userDAO.create(user);
            System.out.println("Пользователь успешно добавлен.");
        }
    }

    public void listAllUsers() throws SQLException {
        List<User> users = userDAO.findAll();
        for (User user : users) {
            System.out.printf("%d - %s - %s%n", user.getId(), user.getName(), user.getEmail());
        }
    }

    public void deleteUser(int id) throws SQLException {
        if (userDAO.findById(id) != null) {
            userDAO.delete(id);
            System.out.println("Пользователь успешно удалён.");
        } else {
            System.out.println("Пользователь не найден.");
        }
    }

    public void updateUser(int id, String newName, String newEmail) throws SQLException {
        User user = userDAO.findById(id);
        if (user != null) {
            user.setName(newName);
            user.setEmail(newEmail);
            userDAO.update(user);
            System.out.println("Данные пользователя успешно обновлены.");
        } else {
            System.out.println("Пользователь не найден.");
        }
    }
}
