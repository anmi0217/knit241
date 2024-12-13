package org.knit.samples.lection9;

import java.sql.*;

public class jdbcApp {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String password = "secret";
        String user = "postgres";

        Connection connection = DriverManager.getConnection(url, user, password);

        PreparedStatement preparedStatement = connection.prepareStatement("select * from users");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            // Извлекаем значения по имени столбца или по индексу
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String role = resultSet.getString("role");
            System.out.printf("%d %s %s\n", id, name, role);
        }
        resultSet.close();
        preparedStatement.close();
        PreparedStatement preparedStatement1 = connection.prepareStatement("insert into users (name, role) values ('andrey', 'moderator')");
        boolean execute = preparedStatement1.execute();
        if (execute) {
            System.out.println("inserted");

        }
    }
}
