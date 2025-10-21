/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package project.vetsys;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import project.vetsys.dao.ClinicDAO;
import project.vetsys.dao.UserDAO;
import project.vetsys.database.DBConnection;
import project.vetsys.model.Clinic;
import project.vetsys.model.User;
import project.vetsys.view.LogIn;


public class VetSys {
    
    private static final Logger logger = Logger.getLogger(VetSys.class.getName());
    
    public static void main(String[] args) throws ClassNotFoundException {
        
        Connection connection = DBConnection.getConnection();
        Scanner scanner = new Scanner(System.in);
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        LogIn LoginFrame = new LogIn();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        
        
        ///prueba en consola de la creación de la clinica
        /*System.out.println("Crear clinica");
        System.out.println("Nombre de la clinica: ");
        String name_clinic = scanner.nextLine();
        System.out.println("Nit: ");
        String nit_clinic = scanner.nextLine();
        System.out.println("Dirección: ");
        String address = scanner.nextLine();
        System.out.println("Telefono: ");
        String phone = scanner.nextLine();
        System.out.println("Fecha de registro: ");
        String registration_date = scanner.nextLine();
        System.out.println("Estado de la clinica: ");
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
        }*/
        
        ///creacion del usuario con su rol asociado a la clinica
        /*System.out.println("Crear usuario:" );
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
        }*/
        
       ///prueba para listar usuarios
       ///el numero entero se debe adaptar desde la interfaz para listar por clinica
       UserDAO dao = new UserDAO();
       List<User> users = dao.Read(2);
       if(users!=null && !users.isEmpty())
       {
           for(User user : users){
               System.out.println(user);
           }
       }else
       {
           System.out.println("No hay usuarios registrados"); 
       }
        
        System.out.print("Usuario: ");
        String usernameLogin = scanner.nextLine();
        System.out.print("Contraseña: ");
        String passwordLogin = scanner.nextLine();
        User userLog = dao.login(usernameLogin, passwordLogin);
        if (userLog != null) {
            System.out.println("Login exitoso: " + userLog.getUsername());
            System.out.println(userLog);
        } else {
            System.out.println("Login no exitoso.");
        }
       
        User userUpdate = new User();
        System.out.println("Ingrese id del usario a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nuevo usuario: ");
        String newUser = scanner.nextLine();
        System.out.println("Ingrese nueva contraseña: ");
        String newPassword = scanner.nextLine();
        System.out.println("Ingrese el nuevo rol: ");
        int newRol = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el estado: ");
        int newStatus = scanner.nextInt();
        scanner.nextLine();
        
        userUpdate.setId_user(id);
        userUpdate.setUsername(newUser);
        userUpdate.setPassword(newPassword);
        userUpdate.setId_role(newRol); 
        userUpdate.setId_status(newStatus);
        
        boolean update = dao.Update(userUpdate, userLog);
        if(update)
        {
            System.out.println("Usuario actualizado");
        }else
        {
            System.out.print("No se actualizo el usuario");
        }    
        
    }
}
