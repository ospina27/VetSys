/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package project.vetsys;

import java.sql.Connection;
import java.util.Scanner;
import project.vetsys.dao.UserDAO;
import project.vetsys.database.DBConnection;
import project.vetsys.model.User;

/**
 *
 * @author User
 */
public class VetSys {

    public static void main(String[] args) {
        
        Connection connection = DBConnection.getConnection();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Usuario: ");
        String username = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        
        UserDAO dao = new UserDAO();
        User user = dao.login(username, password);

        if (user != null) {
            System.out.println("Login exitoso: " + user.getUsername());
            System.out.println(user);
        } else {
            System.out.println("Login no exitoso.");
        }
        
    }
}
