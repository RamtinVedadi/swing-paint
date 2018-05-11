package dao;

import entity.Rectangle;
import entity.Shape;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RectangleDao extends Dao {

    private static RectangleDao instance;

    public RectangleDao() {
        super();
    }

    public static RectangleDao getInstance() {
        if (instance == null) {
            instance = new RectangleDao();
        }
        return instance;
    }

    public boolean insert(Rectangle rectangle) throws SQLException {
        String query = "INSERT INTO rectangle (x1,x2,y1,y2,r,g,b,user) VALUES (?,?,?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, rectangle.getX1());
        preparedStatement.setInt(2, rectangle.getX2());
        preparedStatement.setInt(3, rectangle.getY1());
        preparedStatement.setInt(4, rectangle.getY2());
        preparedStatement.setInt(5, rectangle.getColor().getRed());
        preparedStatement.setInt(6, rectangle.getColor().getGreen());
        preparedStatement.setInt(7, rectangle.getColor().getBlue());
        preparedStatement.setString(8, rectangle.getUsername());
        preparedStatement.executeUpdate();
        return true;
    }

    public ArrayList<Shape> rectangleInfo(String username) throws SQLException {
        String query = "SELECT * FROM rectangle WHERE user=?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Shape> rectangles = new ArrayList<>();

        while (resultSet.next()) {
            int x1 = resultSet.getInt("x1");
            int y1 = resultSet.getInt("y1");
            int x2 = resultSet.getInt("x2");
            int y2 = resultSet.getInt("y2");
            int red = resultSet.getInt("r");
            int green = resultSet.getInt("g");
            int blue = resultSet.getInt("b");
            Color color = new Color(red, green, blue);

            Rectangle rectangle = new Rectangle(x1, x2, y1, y2, color, username);
            rectangles.add(rectangle);
        }
        return rectangles;
    }
}
