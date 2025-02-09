package dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    
    public static Connection getCon() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            // Establish connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/inventory?useSSL=false",
                "root",
                "Admin123"
            );
            return con;
        } catch (Exception e) {
            System.out.println("Database Connection Failed: " + e);
            return null;
        }
    }
}
