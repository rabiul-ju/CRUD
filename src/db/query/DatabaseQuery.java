/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.query;

import db.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserProfile;

/**
 *
 * @author janina
 */
public class DatabaseQuery {
    
    
        Connection connection;
        Statement statement;
        
        public void insertUserProfile(UserProfile user_profile){
        
            initConnection();
            String sqlInsert;
            sqlInsert = "insert into user_profile values ('"+user_profile.getUser_id()+"','"+user_profile.getUser_name()
                    +"','"+user_profile.getUser_city()+"','"+user_profile.getUser_phone()+"','"+user_profile.getUser_email()+"')";
            try {
                statement.executeUpdate(sqlInsert);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            closeConnection();
        }
        
        
        public void selectFromDatbase(String mobile){
        
            initConnection();
            
            String sqlSelect;
            ResultSet rs;
            mobile = 
            sqlSelect = "select * from user_profile where user_phone = "+mobile+"";
            System.out.println(sqlSelect);
            try {
                rs=statement.executeQuery(sqlSelect);
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnNumber= rsmd.getColumnCount();
                
                while(rs.next()){
                    for(int i=1;i<=columnNumber;i++){
                    
                        if(i>1)
                            System.out.print(", ");
                        String columnValue = rs.getString(i);
                        System.out.print(rsmd.getColumnName(i)+"=="+columnValue);
                    }
                    System.out.println("");
                
                    
                }
                    
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            closeConnection();
        
        }
        
        
        
        
        public void updateUserEmail(UserProfile user_profile, String mobile){
        
            initConnection();
            
            String sqlUpdate = "update user_profile set user_email='"+user_profile.getUser_email()+"' where user_phone='"
                    +mobile+"'";
            try {
                statement.executeUpdate(sqlUpdate);
                System.out.println("Update completed");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            closeConnection();
        }
        
    
    
    
        private void initConnection(){
    

        connection = new DatabaseConnection().getConnection();
        try{
            statement = connection.createStatement();
        }catch(SQLException e){
            e.printStackTrace();
            
        }
        
    }
        
        private void closeConnection(){
        
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    
}
