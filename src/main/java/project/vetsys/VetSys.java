package project.vetsys;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import project.vetsys.dao.ClinicDAO;
import project.vetsys.dao.PetDAO;
import project.vetsys.dao.UserDAO;
import project.vetsys.database.DBConnection;
import project.vetsys.model.Clinic;
import project.vetsys.model.Pet;
import project.vetsys.model.User;
import project.vetsys.view.InitPanel;
import project.vetsys.view.security.LogIn;


public class VetSys {
    
    private static final Logger logger = Logger.getLogger(VetSys.class.getName());
    
    public static void main(String[] args) throws ClassNotFoundException {
        
        Connection connection = DBConnection.getConnection();
        Scanner sc = new Scanner(System.in);
        
        
        
        InitPanel Init = new InitPanel();
        Init.setVisible(true);
        Init.pack();
        Init.setLocationRelativeTo(null);
        
        
        
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
       /*UserDAO dao = new UserDAO();
       List<User> users = dao.ReadByClinic(2);
       if(users!=null && !users.isEmpty())
       {
           for(User user : users){
               System.out.println(user);
           }
       }else
       {
           System.out.println("No hay usuarios registrados"); 
       }*/
        
        System.out.print("Usuario: ");
        String usernameLogin = sc.nextLine();
        System.out.print("Contraseña: ");
        String passwordLogin = sc.nextLine();
        UserDAO dao = new UserDAO();
        User logUser = dao.login(usernameLogin, passwordLogin);
        if (logUser != null) {
            System.out.println("Login exitoso: " + logUser.getUsername());
            System.out.println(logUser);
        } else {
            System.out.println("Login no exitoso.");
        }
        
        PetDAO daoPet = new PetDAO();
        
        
        ///crear mascota
        /*Pet newPet = new  Pet();
        newPet.setId_Client(2);
        newPet.setId_Clinic(logUser.getId_clinic());
        newPet.setName_Pet("Max");
        newPet.setSpecies("Perro");
        newPet.setBred("Beagle");
        newPet.setColor("Cafe");
        newPet.setSex("Macho");
        newPet.setDate_of_birth(Date.valueOf("2020-01-15"));
        
        boolean create = daoPet.Create(newPet);
        System.out.println("Resultado de la creación: " + create);*/
        
             
        
        //List<Pet> pets = daoPet.ReadAll(logUser);
        List<Pet> pets = daoPet.ReadForClient(2,logUser);
        System.out.println("=========== LISTA DE MASCOTAS ===========");

        for (Pet p : pets) {
            System.out.println("ID: " + p.getId_pet());
            System.out.println("NOMBRE: " + p.getName_Pet());
            System.out.println("ESPECIE: " + p.getSpecies());
            System.out.println("RAZA: " + p.getBred());
            System.out.println("COLOR: " + p.getColor());
            System.out.println("SEXO: " + p.getSex());
            System.out.println("FECHA NAC: " + p.getDate_of_birth());
            System.out.println("-----------------------------------------");
        }
            
        ///Actualizar mascota
        Pet pet = new Pet();
        pet.setId_pet(1);
        pet.setId_Client(1);
        pet.setId_Clinic(logUser.getId_clinic());
        pet.setName_Pet("Mateo");
        pet.setSpecies("Felino");
        pet.setBred("Angora");
        pet.setColor("Amarillo");
        pet.setSex("macho");
        pet.setDate_of_birth(Date.valueOf("2010-07-18"));

        boolean result = daoPet.Update(pet, logUser);

        System.out.println("Resultado Update: " + result);
        
        System.out.println("Lista de mascotas actualizada de la clinica "+logUser.getClinic().getName_clinic());
        pets = daoPet.Read(logUser);
        for (Pet p : pets) {
            System.out.println("ID: " + p.getId_pet());
            System.out.println("NOMBRE: " + p.getName_Pet());
            System.out.println("ESPECIE: " + p.getSpecies());
            System.out.println("RAZA: " + p.getBred());
            System.out.println("COLOR: " + p.getColor());
            System.out.println("SEXO: " + p.getSex());
            System.out.println("FECHA NAC: " + p.getDate_of_birth());
            System.out.println("-----------------------------------------");
        }
        
        Pet deletePet = new Pet();
        deletePet.setId_pet(5);
        boolean resultDelete = daoPet.Delete(deletePet, logUser);
        System.out.println("Resultado delete "+ resultDelete);
       
      
 

           
    
    }
}
