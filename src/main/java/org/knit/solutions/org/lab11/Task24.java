package org.knit.solutions.org.lab11;

import java.sql.SQLException;
import java.util.List;

public class Task24 {
    public void execute() throws SQLException {

        UserDAO userDAO = new UserDAOImpl();

        userDAO.update(new User("Balica", 1, "balisa@m.ru"));
        userDAO.create(new User("Василий", 12, "что-то@m.ru"));
        System.out.println(userDAO.emailExists("что-то@m.ru"));
        User user = userDAO.findById(1);
        System.out.println(user);
        userDAO.delete(2);

        List<User> all = userDAO.findAll();
        for (User currentUser : all) {
            System.out.println(currentUser);
        }
    }
}