/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author janina
 */
public class DatabaseConnection {
    
    public Connection getConnection(){
        
        final String db_url = "jdbc:mysql://localhost/crud";
        final String user = "root";
        final String pass = "";
        
        Connection conn;
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("connecting databse");
            conn = DriverManager.getConnection(db_url, user, pass);
            
            return conn;
        }
        
        catch(SQLException se){
            se.printStackTrace();
        
        }
        catch(Exception e){
        
            e.printStackTrace();
        }
                
        
        return null;
    }
    
    
}
