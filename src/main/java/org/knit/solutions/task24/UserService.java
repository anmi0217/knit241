package org.knit.solutions.task24;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService() throws SQLException {
        this.userDAO = new UserDAOImpl();
    }

    public String addUser(String name, String email) {
        if (userDAO.isEmailNotExists(email)) {
            userDAO.addUser(new User(name, email));
            return "Пользователь " + email + " успешно добавлен.";
        }
        return "Пользователь " + email + " уже существует.";
    }

    public String updateUser(int id, String name, String email) {
        User user = userDAO.getUserById(id);
        if (user != null) {
            if (userDAO.isEmailNotExists(email)) {
                user.setName(name);
                user.setEmail(email);
                userDAO.updateUser(user);
                return "Данные пользователя " + email + " успешно обновлены.";
            }
            return "Пользователь " + email + " уже существует.";
        }
        return "Пользователя с номером " + id + " не существует.";
    }

    public String deleteUser(int id) {
        User user = userDAO.getUserById(id);
        if (user != null) {
            userDAO.deleteUser(id);
            return "Пользователь " + user.getEmail() + " успешно удален.";
        }
        return "Пользователя с номером " + id + " не существует.";
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
