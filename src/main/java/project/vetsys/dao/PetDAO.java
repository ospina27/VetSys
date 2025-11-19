package project.vetsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import project.vetsys.database.DBConnection;
import project.vetsys.model.ClienteModel;
import project.vetsys.model.Clinic;
import project.vetsys.model.Pet;
import project.vetsys.model.User;
                
public class PetDAO {
    
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    
    
    ///se crea la mascota buscando la cedula del cliente la cual trae su ID con el metodo creado 
    public boolean Create(Pet pet, String document){

        int idOwner = searchIdOwner(document);
        pet.setId_Client(idOwner);

        if(idOwner == -1){
            System.out.println("No se encontro cliente con cedula "+document);
            return false;
        }
        
        ///se usa para validar que no exista una mascota con los datos inrgesado
        ///relacionado al cliente
        String sqlCheck = "SELECT COUNT(*) FROM mascota "
                        + "WHERE id_cliente =? AND nombre =? AND especie=?"
                            + " AND raza=? AND sexo=? AND fecha_nacimiento =? ";
        
        ///crear la mascota
        String sqlInsert = "Insert into mascota (id_cliente, id_clinica, nombre, "
                        + "especie, raza, color, sexo, fecha_nacimiento)"
                                + " VALUES (?,?,?,?,?,?,?,?)";
        
        PreparedStatement psInsert = null;
        
        try {
            ///realiza primero la validación en la base de datos de la mascota existente
                connection = DBConnection.getConnection();
                ps = connection.prepareStatement(sqlCheck);
                ps.setInt(1, pet.getId_Client());
                ps.setString(2, pet.getName_Pet());
                ps.setString(3, pet.getSpecies());
                ps.setString(4, pet.getBred());
                ps.setString(5, pet.getSex());
                ps.setDate(6, pet.getDate_of_birth());

                ResultSet rs = ps.executeQuery();
                if(rs.next() && rs.getInt(1) > 0)
                {
                    JOptionPane.showMessageDialog(null,
                    "Esta mascota ya existe para este cliente",
                    "DUPLICADO",
                    JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                rs.close();
                ps.close();
                                   
                psInsert = connection.prepareStatement(sqlInsert); 
                psInsert.setInt(1, pet.getId_Client());
                psInsert.setInt(2,pet.getId_Clinic());
                psInsert.setString(3, pet.getName_Pet());
                psInsert.setString(4, pet.getSpecies());
                psInsert.setString(5, pet.getBred());
                psInsert.setString(6, pet.getColor());
                psInsert.setString(7, pet.getSex());
                psInsert.setDate(8, pet.getDate_of_birth());
                    
                int rows = psInsert.executeUpdate();
                     return rows > 0;       
                               
            } catch (Exception e) {
                 System.out.println("Error en la creacion de la mascota: " + e.getMessage());
                return false;
            }finally 
            {
                try 
                {
                    if(rs != null) rs.close();
                    if (ps != null) ps.close();
                    if(psInsert != null) psInsert.close();
                    if (connection != null) connection.close();
                } catch (SQLException ex) 
                {
                    System.out.println("Error, cerrando la conexión: " + ex.getMessage());
                }
            }
    }
       
        
       
    ///seleccionar el id del cliente para encontrar su cedula
    public int searchIdOwner(String document){
        String sql = "SELECT id_cliente FROM cliente WHERE documento = ?";
        try {
               connection = DBConnection.getConnection();
               ps = connection.prepareStatement(sql);
               ps.setString(1,document);
               
               rs = ps.executeQuery();
               if(rs.next()){
                   return rs.getInt("id_cliente");
               }
           } catch (Exception e) {
               System.out.println("Error al obtener el id_cliente: " + e.getMessage());
           }finally {
               try {
                 if (ps != null) ps.close();
                 if (connection != null) connection.close();
                } catch (SQLException ex) {
                 System.out.println("Error cerrando la conexión: " + ex.getMessage());
                }
           }
           return -1;   ///por si el cliente no existe en la clinica        
       }
    
   
    ///listar las mascotas por id para la tabla
    public Pet ReadId(int idPet) {
          
        String sql= "SELECT m.id_mascota, m.id_cliente, m.id_clinica, m.nombre, m.especie, m.raza, m.color, m.sexo, m.fecha_nacimiento, "
                + "c.nombres, c.apellidos, c.documento, c.telefono, c.correo, c.direccion "
                + "FROM mascota m "
                + "INNER JOIN cliente c ON m.id_cliente = c.id_cliente "
                + "WHERE m.id_mascota =? ";
        
        try (Connection con = DBConnection.getConnection();
              PreparedStatement ps = con.prepareStatement(sql)) 
        {
            ps.setInt(1, idPet);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ClienteModel client = new ClienteModel();
                    client.setIdCliente(rs.getInt("id_cliente"));
                    client.setNombres(rs.getString("nombres"));
                    client.setApellidos(rs.getString("apellidos"));
                    client.setDocumento(rs.getString("documento"));
                    client.setTelefono(rs.getString("telefono"));
                    client.setCorreo(rs.getString("correo"));
                    client.setDireccion(rs.getString("direccion"));

                    Pet pet = new Pet();
                    pet.setId_pet(rs.getInt("id_mascota"));
                    pet.setId_Client(rs.getInt("id_cliente"));
                    pet.setId_Clinic(rs.getInt("id_clinica"));
                    pet.setName_Pet(rs.getString("nombre"));
                    pet.setSpecies(rs.getString("especie"));
                    pet.setBred(rs.getString("raza"));
                    pet.setColor(rs.getString("color"));
                    pet.setSex(rs.getString("sexo"));
                    pet.setDate_of_birth(rs.getDate("fecha_nacimiento"));

                    pet.setClient(client);
                    return pet;
                }
            }

        } catch (SQLException e) {
             System.out.println("Error al consultar mascota por ID: " + e.getMessage());
        }
        return null;
     }

       
       

       
       ////metodo para listar todas las mascotas de la clinica del usuario logueado
       ///con la información del cliente
    public List<Pet> ReadAllPets(User logUser) {
        List<Pet> listPets = new ArrayList<>();
        String sql ="SELECT m.id_mascota, m.id_cliente, m.id_clinica, m.nombre, m.especie, m.raza, m.color, m.sexo, m.fecha_nacimiento, "
            + "c.nombres AS cliente_nombres, c.apellidos AS cliente_apellidos, c.documento AS cliente_documento, "
            + "c.telefono AS cliente_telefono, c.correo AS cliente_correo, c.direccion AS cliente_direccion, "
            + "c.id_membresia, c.fecha_inicio, c.fecha_vigencia, c.id_estado_membresia "
            + "FROM mascota m "
            + "INNER JOIN cliente c ON m.id_cliente = c.id_cliente "
                + "WHERE m.id_clinica = ?";

        try (Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) 
        {
            ps.setInt(1, logUser.getId_clinic());
            try (ResultSet rs = ps.executeQuery())
            {
                while (rs.next()) 
                {
                    ClienteModel client = new ClienteModel();
                    client.setIdCliente(rs.getInt("id_cliente"));
                    client.setIdClinica(rs.getInt("id_clinica"));
                    client.setNombres(rs.getString("cliente_nombres"));
                    client.setApellidos(rs.getString("cliente_apellidos"));
                    client.setDocumento(rs.getString("cliente_documento"));
                    client.setTelefono(rs.getString("cliente_telefono"));
                    client.setCorreo(rs.getString("cliente_correo"));
                    client.setDireccion(rs.getString("cliente_direccion"));
                    client.setIdMembresia(rs.getInt("id_membresia"));
                    client.setFechaInicio(String.valueOf(rs.getDate("fecha_inicio")));
                    client.setFechaVigencia(String.valueOf(rs.getDate("fecha_vigencia")));
                    client.setEstadoMembresia(rs.getInt("id_estado_membresia"));

                    Pet pet = new Pet();
                    pet.setId_pet(rs.getInt("id_mascota"));
                    pet.setId_Client(rs.getInt("id_cliente"));
                    pet.setId_Clinic(rs.getInt("id_clinica"));
                    pet.setName_Pet(rs.getString("nombre"));
                    pet.setSpecies(rs.getString("especie"));
                    pet.setBred(rs.getString("raza"));
                    pet.setColor(rs.getString("color"));
                    pet.setSex(rs.getString("sexo"));
                    pet.setDate_of_birth(rs.getDate("fecha_nacimiento"));

                    // Asignar cliente a mascota
                    pet.setClient(client);
                    listPets.add(pet);
                }
            }
        }catch (SQLException e) {
                System.out.println("Error al listar mascotas: " + e.getMessage());
            }
        return listPets;
    }    
  
       
       ///filtar mascota por cliente, mostrando informacion del cliente

    public List<Pet> ReadForClient(int idClient, User logUser) {  
        List<Pet> listPets = new ArrayList<>();

        String sql = "SELECT m.id_mascota, m.nombre, m.raza, m.especie, m.color, m.sexo, m.fecha_nacimiento, " 
                    +"c.id_cliente, c.nombres, c.apellidos, c.documento, c.telefono, c.correo, c.direccion "
                    +"FROM mascota m " 
                    +"INNER JOIN cliente c ON m.id_cliente = c.id_cliente " 
                    +"WHERE m.id_cliente =? AND m.id_clinica = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
           
            ps.setInt(1, idClient);
            ps.setInt(2, logUser.getId_clinic());
            

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Pet pet = new Pet();
                    ClienteModel client = new ClienteModel();

                    pet.setId_pet(rs.getInt("id_mascota"));
                    pet.setName_Pet(rs.getString("nombre"));
                    pet.setSpecies(rs.getString("especie"));
                    pet.setBred(rs.getString("raza"));
                    pet.setColor(rs.getString("color"));
                    pet.setSex(rs.getString("sexo"));
                    pet.setDate_of_birth(rs.getDate("fecha_nacimiento"));
                    
                    client.setIdCliente(rs.getInt("id_cliente"));
                    client.setNombres(rs.getString("nombres"));
                    client.setApellidos(rs.getString("apellidos"));
                    client.setDocumento(rs.getString("documento"));
                    client.setTelefono(rs.getString("telefono"));
                    client.setCorreo(rs.getString("correo"));
                    client.setDireccion(rs.getString("direccion")); 
                    
                    pet.setId_Client(client.getIdCliente());
                    pet.setId_Clinic(logUser.getId_clinic());
                    pet.setClient(client);
                    listPets.add(pet);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar mascotas: " + e.getMessage());
        }

        return listPets;
    }

   
    
    public boolean Update(Pet pet, User logUser){
        
        String sql = "UPDATE mascota SET "
                + "nombre = ?, especie = ?, raza = ?, color = ?, sexo = ?, fecha_nacimiento = ? "
                    + "WHERE id_mascota = ?";
       
        try {
            connection = DBConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, pet.getName_Pet());
            ps.setString(2, pet.getSpecies());
            ps.setString(3, pet.getBred());
            ps.setString(4, pet.getColor());
            ps.setString(5, pet.getSex());
            ps.setDate(6, pet.getDate_of_birth());
            ps.setInt(7,pet.getId_pet());
                   
            int rowUpdate = ps.executeUpdate(); ///verificar en consola si se actualizo o no alguna fila
            return rowUpdate > 0;            
            
        } catch (Exception e) {
            System.out.println("Error al actualizar mascota "+e.getMessage());
        }finally
        {
            try 
            {
                if(ps!= null) ps.close();
                if(connection != null) connection.close();
            } catch (Exception e) 
            {
                System.out.println(e.toString());  
            }     
        }
        return false;
    }
    
    
    
     public boolean Delete(Pet pet, User logUser){
         
        String sql = "DELETE FROM mascota WHERE id_mascota = ?";
        
        try (Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, pet.getId_pet());
        
        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Error desactivando el usuario: " + e.getMessage());
            return false;
        }
    }
    
   

    
}
