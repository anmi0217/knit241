package org.knit.solutions.org.lab11;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public void create(User user) throws SQLException {
        String sql = "insert into users (id, name, email) values (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from users")) {
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getString("name"),
                        resultSet.getInt("id"),
                        resultSet.getString("email")));

            }
        }
        return users;
    }


    @Override
    public void update(User user) throws SQLException {
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("update users set name = ?, email = ? where id = ?")){
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setInt(3, user.getId());
            ps.executeUpdate();
        }
        //throw new UnsupportedOperationException("Операция обновления не поддерживается без ID");
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "delete from users where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }


    @Override
    public boolean emailExists(String email) throws SQLException {
        String sql = "select count(*) from users where email = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }


    @Override
    public User findById(int id) throws SQLException {
        String sql = "select * from users where id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getString("name"),
                            rs.getInt("id"),
                            rs.getString("email")
                    );
                } else {
                    throw new SQLException("пользователь c id" + id + " не найден");
                }
            }
        }
    }
}
