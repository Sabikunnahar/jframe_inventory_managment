package dao;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class tables {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;

        try {
            con = ConnectionProvider.getCon();

            // Check if connection is successful
            if (con == null) {
                throw new Exception("Database connection failed. Check credentials or server status.");
            }

            st = con.createStatement();

            // Corrected SQL syntax with proper VARCHAR type
            //String insert_query = "CREATE TABLE IF NOT EXISTS appuser (appuser_pk INT AUTO_INCREMENT PRIMARY KEY, userRole VARCHAR(50), name VARCHAR(200), mobileNumber VARCHAR(50), password VARCHAR(200), address VARCHAR(200), status VARCHAR(50))";
            //String insert_query = "Insert into appuser(userRole,name, email mobileNumber, password, address, status) values('superAdmin', 'Super Admin','superadmin@example.com', '01956303893', '1234','Arambagh', '1' )";
            //String insert_query = "CREATE TABLE category (category_pk INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50))";
            //String insert_query = "CREATE TABLE product(product_pk INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), quantity int, price int,description VARCHAR(500), category_fk int)";
            String insert_query = "CREATE TABLE customer(customer_pk INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), mobileNumber VARCHAR(50),email VARCHAR(50))";

            st.executeUpdate(insert_query);
            JOptionPane.showMessageDialog(null, "Table Created Successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Closing Error: " + e);
            }
        }
    }
}
