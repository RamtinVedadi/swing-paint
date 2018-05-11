package dao;

import entity.Line;
import entity.Shape;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LineDao extends Dao {

    private static LineDao instance;

    public LineDao() {
        super();
    }

    public static LineDao getInstance() {
        if (instance == null) {
            instance = new LineDao();
        }
        return instance;
    }

    public boolean insert(Line line) throws SQLException {
//        String query = ;
        preparedStatement = connection.prepareStatement("INSERT INTO line (x1,x2,y1,y2,r,g,b,user) VALUES(?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, line.getX1());
        preparedStatement.setInt(2, line.getX2());
        preparedStatement.setInt(3, line.getY1());
        preparedStatement.setInt(4, line.getY2());
        preparedStatement.setInt(5, line.getColor().getRed());
        preparedStatement.setInt(6, line.getColor().getGreen());
        preparedStatement.setInt(7, line.getColor().getBlue());
        preparedStatement.setString(8, line.getUsername());
        preparedStatement.executeUpdate();
        return true;
    }

    public ArrayList<Shape> lineInfo(String username) throws SQLException {
        String query = "SELECT * FROM line WHERE user=?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Shape> lines = new ArrayList<>();
        while (resultSet.next()) {
            int x1 = resultSet.getInt("x1");
            int y1 = resultSet.getInt("y1");
            int x2 = resultSet.getInt("x2");
            int y2 = resultSet.getInt("y2");
            int red = resultSet.getInt("r");
            int green = resultSet.getInt("g");
            int blue = resultSet.getInt("b");
            Color color = new Color(red, green, blue);
            
            Line line = new Line(x1, x2, y1, y2, color, username);
            lines.add(line);
        }
        return lines;
    }
}
