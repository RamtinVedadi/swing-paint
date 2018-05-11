//package manager;
//
//import dao.RectangleDao;
//import entity.Rectangle;
//import java.sql.SQLException;
//
//public class RectangleManager {
//
//    private static RectangleManager instance;
//    private RectangleDao rectangleDao = RectangleDao.getInstance();
//
//    public RectangleManager() {
//        super();
//    }
//
//    public static RectangleManager getInstance() {
//        if (instance == null) {
//            instance = new RectangleManager();
//        }
//        return instance;
//    }
//
//    public void insert(Rectangle rectangle) throws SQLException {
//        rectangleDao.insert(rectangle);
//    }
//
//    public Rectangle rectangleInfo(String username) throws SQLException {
//        return (Rectangle) rectangleDao.rectangleInfo(username);
//    }
//
//}
