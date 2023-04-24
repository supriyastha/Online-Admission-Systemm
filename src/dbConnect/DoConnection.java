package dbConnect;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DoConnection {
    Connection conn = null;
    String driver;
    String host;
    String user;
    String password;
    public DoConnection(){
            this.driver = "com.mysql.cj.jdbc.Driver";
            this.host = "jdbc:mysql://localhost:3306/oas";
            this.user = "root";
            this.password = "";
    }
    public Connection getConnection(){
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(host,user,password);
        }catch (ClassNotFoundException error1){
            throw new RuntimeException(error1);
        }catch(SQLException error2){
            throw new RuntimeException(error2);
        }
        return conn;
    }
}
