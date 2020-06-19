package executor;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Executor {
    public static Connection getMySQLConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String sql = "jdbc:mysql://localhost:3306/project_112?user=root&password=root&serverTimezone=UTC";
            Connection connection = DriverManager.getConnection(sql);
            return connection;
        } catch (SQLException e) { //catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

}
