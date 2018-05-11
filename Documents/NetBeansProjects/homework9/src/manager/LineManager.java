//package manager;
//
//import dao.LineDao;
//import entity.Line;
//import java.sql.SQLException;
//
//public class LineManager {
//
//    private static LineManager instance;
//    private LineDao lineDao = LineDao.getInstance();
//
//    public LineManager() {
//        super();
//    }
//
//    public LineManager getInstance() {
//        if (instance == null) {
//            instance = new LineManager();
//        }
//        return instance;
//    }
//
//    public void insert(Line line) throws SQLException {
//        lineDao.insert(line);
//    }
//
//    public Line recoverData(String username) throws SQLException {
//        return (Line) lineDao.lineInfo(username);
//    }
//}
