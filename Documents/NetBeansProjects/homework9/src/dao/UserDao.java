package dao;

import entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends Dao {

    private static UserDao instance;
    private UserDao(){}
    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    public boolean insert(User user) throws SQLException {

        String query = "INSERT INTO user(username , password) VALUES(?,?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.executeUpdate();
        return true;
    }

    public boolean checkUser(String username) throws SQLException {
        String query = "SELECT * FROM user WHERE username=?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        resultSet.last();
        if (resultSet.getRow() == 1) 
            return true;
        return false;
    }
}
