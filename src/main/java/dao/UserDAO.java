package dao;
import User.User;
import executor.Executor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public boolean addUser(User user) throws SQLException{
        Connection connection = null;
        PreparedStatement prepStmt = null;
        try {
            connection = Executor.getMySQLConnection();
            String sql = "INSERT INTO USERS (NAME, AGE) VALUE (?, ?)";
            connection.setAutoCommit(false);
            prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, user.getName());
            prepStmt.setLong(2, user.getAge());
            int result = prepStmt.executeUpdate();
            connection.commit();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            prepStmt.close();
            connection.close();
        }
    }

    public boolean deleteUser(long id) throws SQLException{
        PreparedStatement prepSttmnt = null;
        Connection connection = null;
        try  {
            String sql = "DELETE FROM USERS WHERE ID = ?";
            int result;
            connection = Executor.getMySQLConnection();
            connection.setAutoCommit(false);
            prepSttmnt = connection.prepareStatement(sql);
            prepSttmnt.setLong(1, id);
            result = prepSttmnt.executeUpdate();
            connection.commit();
            return result == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
            prepSttmnt.close();
            connection.close();
        }
    }

    public List<User> getAllUsers() throws SQLException{
        List<User> bankClients = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepSttmnt = null;
        try {
            connection = Executor.getMySQLConnection();
            connection.setAutoCommit(false);
            prepSttmnt = connection.prepareStatement("SELECT * FROM USERS;");
            ResultSet result = prepSttmnt.executeQuery();
            while (result.next()) {
                bankClients.add(new User(result.getLong(1), result.getString(2), result.getLong(3)));
            }
            return bankClients;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
            prepSttmnt.close();
            connection.close();
        }
    }

    public User getUser(long id) throws SQLException{
        User user = new User();
        PreparedStatement prepStmnt = null;
        Connection connection = null;
        try {
            String sql = "SELECT * FROM USERS WHERE ID=?;";
            connection = Executor.getMySQLConnection();
            connection.setAutoCommit(false);
            prepStmnt = connection.prepareStatement(sql);
            prepStmnt.setLong(1, id);
            ResultSet result = prepStmnt.executeQuery();
            while (result.next()){
                user.setID(result.getLong("id"));
                user.setName(result.getString("name"));
                user.setAge(result.getLong("age"));
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
            prepStmnt.close();
            connection.close();
        }
    }

    public boolean updateUser(User user) throws SQLException{
        PreparedStatement prepStmt = null;
        Connection connection = null;
        try {
            String sql = "UPDATE USERS SET NAME=?, AGE=? WHERE ID=?";
            connection = Executor.getMySQLConnection();
            connection.setAutoCommit(false);
            prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, user.getName());
            prepStmt.setLong(2, user.getAge());
            prepStmt.setLong(3, user.getId());
            int result = prepStmt.executeUpdate();
            connection.commit();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            prepStmt.close();
            connection.close();
        }
    }
}
