package service;

import User.User;
import dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    public static void addUser(User user) {
        UserDAO userDAO = new UserDAO();
        try{
            userDAO.addUser(user);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static List<User> getAllUsers(){
        UserDAO userDAO = new UserDAO();
        try{
            return userDAO.getAllUsers();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static User getUsers(long id){
        UserDAO userDAO = new UserDAO();
        try{
            return userDAO.getUser(id);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static boolean deleteUser(long id) {
        UserDAO userDAO = new UserDAO();
        try{
            return userDAO.deleteUser(id);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean updateUser(User user){
        UserDAO userDAO = new UserDAO();
        try{
            return userDAO.updateUser(user);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public static boolean isAddReqValid(HttpServletRequest request){
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        return name != null && name.length() > 0 &&
                age !=null && age.length() > 0 &&
                age.matches("[+]?\\d+");
    }

    public static boolean isReqValid(HttpServletRequest request){
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        return name != null && name.length() > 0 &&
                age !=null && age.length() > 0 &&
                age.matches("[+]?\\d+") &&
                id !=null && id.length() > 0 &&
                id.matches("[+]?\\d+");
    }

    public static boolean isIDValid(HttpServletRequest request){
        String id = request.getParameter("id");
        return id !=null && id.length() > 0 && id.matches("[+]?\\d+");
    }
}
