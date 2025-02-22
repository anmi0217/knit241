package org.knit.lab11.task24;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(String name, String email) throws SQLException {
        if (userDAO.emailExists(email)) {
            throw new IllegalArgumentException("Email уже существует");
        }
        userDAO.create(new User(0, name, email));
    }

    public List<User> listAllUsers() throws SQLException {
        return userDAO.findAll();
    }

    public void deleteUser(int id) throws SQLException {
        if (userDAO.findById(id) == null) {
            throw new IllegalArgumentException("Пользователь не найден");
        }
        userDAO.delete(id);
    }

    public void updateUser(int id, String newName, String newEmail) throws SQLException {
        if (!userDAO.emailExists(newEmail) || userDAO.findById(id).getEmail().equals(newEmail)) {
            User user = userDAO.findById(id);
            if (user == null) {
                throw new IllegalArgumentException("Пользователь не найден");
            }
            user.setName(newName);
            user.setEmail(newEmail);
            userDAO.update(user);
        } else {
            throw new IllegalArgumentException("Email уже существует");
        }
    }
}