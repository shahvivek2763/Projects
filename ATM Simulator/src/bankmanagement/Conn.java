package bankmanagement;

import java.sql.*;

public class Conn {
    String url,username,password;
    Connection con;
    Statement st;

    public Conn(){
        try{
            url = "jdbc:mysql://localhost:3306/bankmanagementsystem";
            username = "root";
            password = "Cap@70098";
            con = DriverManager.getConnection(url,username,password); 
            st = con.createStatement();
            // System.out.println("Connection established successfull");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
