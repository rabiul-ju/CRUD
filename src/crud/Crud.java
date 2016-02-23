/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import db.connection.DatabaseConnection;
import db.query.DatabaseQuery;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import model.UserProfile;

/**
 *
 * @author janina
 */
public class Crud {
    
     


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        
        Scanner input= new Scanner(System.in);
        
        // inserting intko the user 
        
        UserProfile user=new UserProfile();
        
        System.out.print("For Select = 1\nFor Update==2\n For details ==3Type any number : ");
        
        int select = input.nextInt();
        if(select==1){
        
            System.out.println("userId...user_name...user_city...user..phone...user..email...");
            user.setUser_id(input.nextInt());
            user.setUser_name(input.next());
            user.setUser_city(input.next());
            user.setUser_phone(input.next());
            user.setUser_email(input.next());

            new DatabaseQuery().insertUserProfile(user);
            System.out.println("User profile is created");
        
        }
        
        //inserting into the user
        
        // update into database...
        if(select==2){
            System.out.println("updating city into databasse");
            user.setUser_email(input.next());
            String mobile = input.next();

            new DatabaseQuery().updateUserEmail(user, mobile);
        }
         //update into database...
        
        if(select==3){
        
            System.out.print("Enter Mobile number for details : ");
            String mobile = input.next();
            new DatabaseQuery().selectFromDatbase(mobile);
        }

    }
         
        

        
        
    
//        Connection connection;
//        Statement statement;
//        
//        connection = new DatabaseConnection().getConnection();
//        try{
//            statement = connection.createStatement();
//        }catch(SQLException e){
//            e.printStackTrace();
//            
//        }
        
//    }
    
}
