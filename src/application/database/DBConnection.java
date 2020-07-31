package application.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection extends Configs{
	private Connection connection;

    public DBConnection() {
    }

    public Connection getConnection() {
        try {
            String connectionString = "jdbc:mysql://" + dbHost + ":"
                    + dbPort + "/"
                    + dbName;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (connection != null || preparedStatement != null || resultSet != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close(Connection connection, PreparedStatement preparedStatement) {
        try {
            close(connection, preparedStatement, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close(PreparedStatement preparedStatement) {
        try {
            close(null, preparedStatement, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
