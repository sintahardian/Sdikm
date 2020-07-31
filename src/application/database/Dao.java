package application.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao extends Configs{
	private DBConnection dbConnection = new DBConnection();
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private Connection connection;
    private static final String SELECT_QUERY = "SELECT * FROM tatausaha WHERE username = ? and password = ?";
    
    public Dao() {
    	
    }
    
    public boolean validate(String username,String password) {
        try {
            connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_QUERY);
//            resultSet = preparedStatement.executeQuery();
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


}
