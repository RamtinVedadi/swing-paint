package dao;

import entity.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dao {

    public static Connection connection;
    public static PreparedStatement preparedStatement;

    public static String connectURL = "jdbc:mysql://localhost:3306/paint?user=root";

    protected Dao() {
    }

    static {
        String username = "root";
        String pass = "";
        try {
            String url = String.format("jdbc:mysql://localhost/paint?user=%s&password=%s", username, pass);
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void finalize() {
        try {
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            try {
                super.finalize();
            } catch (Throwable ex) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
