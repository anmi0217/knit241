package org.knit.tasks.task24;

import java.sql.*;

public class Task24 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\sosnovskiima\\AppData\\Roaming\\DBeaverData\\workspace6\\.metadata\\sample-database-sqlite-1\\Chinook.db");
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM Album");
        statement.execute();
        ResultSet set = statement.getResultSet();
        while (set.next()) {
            System.out.println(set.getString("Title"));
        }
    }
}
