package dao;

import entity.Circle;
import entity.Shape;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CircleDao extends Dao {

    private static CircleDao instance;

    public CircleDao() {
        super();
    }

    public static CircleDao getInstance() {
        if (instance == null) {
            instance = new CircleDao();
        }
        return instance;
    }

    public boolean insert(Circle circle) throws SQLException {
        String query = "INSERT INTO circle (x1,x2,y1,y2,r,g,b,user) VALUES (?,?,?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, circle.getX1());
        preparedStatement.setInt(2, circle.getX2());
        preparedStatement.setInt(3, circle.getY1());
        preparedStatement.setInt(4, circle.getY2());
        preparedStatement.setInt(5, circle.getColor().getRed());
        preparedStatement.setInt(6, circle.getColor().getGreen());
        preparedStatement.setInt(7, circle.getColor().getBlue());
        preparedStatement.setString(8, circle.getUsername());
        preparedStatement.executeUpdate();
        return true;
    }

    public ArrayList<Shape> circleInfo(String username) throws SQLException {
        String query = "SELECT * FROM circle WHERE user=?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Shape> circles = new ArrayList<>();
        while (resultSet.next()) {
            int x1 = resultSet.getInt("x1");
            int y1 = resultSet.getInt("y1");
            int x2 = resultSet.getInt("x2");
            int y2 = resultSet.getInt("y2");
            int red = resultSet.getInt("r");
            int green = resultSet.getInt("g");
            int blue = resultSet.getInt("b");
            Color color = new Color(red, green, blue);
            
            Circle circle = new Circle(x1, x2, y1, y2, color, username);
            circles.add(circle);
        }
        return circles;
    }
}
