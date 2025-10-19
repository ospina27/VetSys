/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package project.vetsys;

import java.sql.Connection;
import java.util.Scanner;
import project.vetsys.dao.ClinicDAO;
import project.vetsys.dao.UserDAO;
import project.vetsys.database.DBConnection;
import project.vetsys.model.Clinic;
import project.vetsys.model.User;


public class VetSys {

    public static void main(String[] args) {
        
        Connection connection = DBConnection.getConnection();
        Scanner scanner = new Scanner(System.in);
        
        ///prueba en consola de la creación de la clinica
        System.out.println("Crear clinica");
        System.out.print("Nombre de la clinica: ");
        String name_clinic = scanner.nextLine();
        System.out.println("Nit: ");
        String nit_clinic = scanner.nextLine();
        System.out.print("Dirección: ");
        String address = scanner.nextLine();
        System.out.print("Telefono: ");
        String phone = scanner.nextLine();
        System.out.print("Fecha de registro: ");
        String registration_date = scanner.nextLine();
        System.out.print("Estado de la clinica: ");
        int id_status = scanner.nextInt();
        scanner.nextLine();
        
        Clinic newClinic = new Clinic();
        newClinic.setName_clinic(name_clinic);
        newClinic.setNit(nit_clinic);
        newClinic.setAddress(address);
        newClinic.setPhone(phone);
        newClinic.setRegistration_date(registration_date);
        newClinic.setId_status(id_status);
        
        ClinicDAO clinicDAO = new ClinicDAO();
        if(clinicDAO.Create(newClinic)){
            System.out.println("Clinica creado con éxito!");
        } else {
            System.out.println("Fallo al crear a clinica.");
        }
        
        ///creacion del usuario con su rol asociado a la clinica
        System.out.print("ID Clínica: ");
        int clinicId = scanner.nextInt();
        System.out.print("ID Rol: ");
        int roleId = scanner.nextInt();
        System.out.print("ID Estado: ");
        int statusId = scanner.nextInt();
        scanner.nextLine();   
        System.out.println("Usuario: ");
        String username = scanner.nextLine();
        System.out.println("Contraseña: ");
        String password = scanner.nextLine();
        
        User user = new User();
        user.setId_clinic(clinicId);
        user.setId_role(roleId);
        user.setId_status(statusId);
        user.setUsername(username);
        user.setPassword(password);
        
        UserDAO dao = new UserDAO();
        
        if (dao.Create(user)) {
            System.out.println("Usuario creado con éxito!");
        } else {
            System.out.println("Error al crear el usuario.");
        }
        
        ///Prueba de login en consola
        System.out.print("Usuario: ");
        String usernameLogin = scanner.nextLine();
        System.out.print("Contraseña: ");
        String passwordLogin = scanner.nextLine();
        
        //UserDAO dao = new UserDAO();
        User userLog = dao.login(usernameLogin, passwordLogin);
        if (user != null) {
            System.out.println("Login exitoso: " + user.getUsername());
            System.out.println(user);
        } else {
            System.out.println("Login no exitoso.");
        }
        
    }
}
