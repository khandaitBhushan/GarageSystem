package Config;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConfig {
    public static Connection getConnection()throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/garageSystem","root","pass@123");
    }
}
