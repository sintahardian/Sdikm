package application.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import application.model.DataGuru;
import application.model.DataKegiatan;
import application.model.DataSurat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class Dao extends Configs{
	private DBConnection dbConnection = new DBConnection();
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private Connection connection;
    private static final String SELECT_QUERY = "SELECT * FROM tatausaha WHERE username = ? and password = ?";
    
    public Dao() {
    	
    }
    public void saveData(String query) {
        try {
            connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.close(connection, preparedStatement, null);
        }
    }
    
    
    public ObservableList<DataGuru> getDataGuru(String query) {
        ObservableList list = FXCollections.observableArrayList();
        try {
            connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new DataGuru(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getDate(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ObservableList<DataGuru> getDataGuruKegiatan(String query) {
        ObservableList list = FXCollections.observableArrayList();
        try {
            connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new DataGuru(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public ObservableList<DataKegiatan> getDataKegiatan(String query) {
        ObservableList list = FXCollections.observableArrayList();
        try {
            connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new DataKegiatan(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public ObservableList<DataSurat> getDataSurat(String query) {
        ObservableList list = FXCollections.observableArrayList();
        try {
            connection = dbConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new DataSurat(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
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
