//package manager;
//
//import dao.CircleDao;
//import entity.Circle;
//import java.sql.SQLException;
//
//public class CircleManager {
//
//    private static CircleManager instance;
//    private CircleDao circleDao = CircleDao.getInstance();
//
//    public CircleManager() {
//        super();
//    }
//
//    public static CircleManager getInstance() {
//        if (instance == null) {
//            instance = new CircleManager();
//        }
//        return instance;
//    }
//
//    public void insert(Circle circle) throws SQLException {
//        circleDao.insert(circle);
//    }
//
//    public Circle recoverData(String username) throws SQLException {
//        return (Circle) circleDao.circleInfo(username);
//    }
//}
