/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.vetsys.database;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/vetsys?useSSL=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "root";
    private static boolean mensaje = false;
    
    
    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            if (!mensaje) {
                System.out.println("Se conecto correctamente a la base de datos");
                mensaje = true; // se marca como mostrado
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return connection;
    }

    
}
