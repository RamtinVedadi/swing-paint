//package manager;
//
//import dao.UserDao;
//import entity.User;
//import java.sql.SQLException;
//
//public class UserManager {
//
//    private static UserManager instance;
//    private UserDao userDao = UserDao.getInstance();
//
//    public UserManager() {
//        super();
//    }
//
//    public static UserManager getInstance() {
//        if (instance == null) {
//            instance = new UserManager();
//        }
//        return instance;
//    }
//
//    public void insert(User user) throws SQLException {
//        userDao.insert(user);
//    }
//
//    public boolean checkUser(String username) {
//        try {
//            return userDao.checkUser(username);
//        } catch (SQLException e) {
//            e.getMessage();
//            return false;
//        }
//    }
//}
