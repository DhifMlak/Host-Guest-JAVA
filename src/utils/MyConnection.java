/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Firas
 */
public class MyConnection {
    private String url = "jdbc:mysql://localhost:3306/hostguestfinal";
    private String login = "root";
    private String pwd = "";
    private static Connection conn;
    
    private MyConnection() {
        try {
            conn = DriverManager.getConnection(url,login,pwd);
            System.out.println("Connection établie !");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection GetInstance() {
        if (conn==null)
           new MyConnection();
        
        return conn;
    } 
    
}
