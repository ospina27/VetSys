/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.vetsys.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String Url = "";
    private static String User ="";
    private static String Password = "";

    public static Connection getConnection() {
        Connection connection = null; 
        try {
            connection = DriverManager.getConnection(Url,User,Password);
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.out.println("Error "+e.getMessage() );
        }
        return connection;
    }
    
    
    
}
