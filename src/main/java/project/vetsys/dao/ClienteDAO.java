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

public class ClienteDAO {
    
    public boolean clienteTieneCitas(int idCliente) {
        String sql = "SELECT COUNT(*) FROM cita WHERE id_cliente = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1) > 0;

        } catch (SQLException e) {
            System.out.println("Error verificando citas: " + e.getMessage());
        }
        return false;
    }
    
    public boolean clienteTieneMascotas(int idCliente){
        String sql = "Select Count(*) From mascota Where id_cliente =?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1) > 0;

        } catch (SQLException e) {
            System.out.println("Error verificando mascotas del cliente: " + e.getMessage());
        }
        return false;
    }
    
    private boolean existeCliente(String documento, int idClinica) {
        String sql = "SELECT COUNT(*) FROM cliente WHERE documento = ? AND id_clinica = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, documento);
            ps.setInt(2, idClinica);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error verificando existencia de cliente: " + e.getMessage());
        }
        return false;
    }

    
    public boolean insertarCliente(ClienteModel client) {
        
        
        if (existeCliente(client.getDocumento(), client.getIdClinica())) {
        JOptionPane.showMessageDialog(null, 
            "El cliente con cédula " + client.getDocumento() + " ya se encuentra registrado en esta clínica.", 
            "Cliente Duplicado", 
            JOptionPane.WARNING_MESSAGE);
            return false;
        }
        String sql = "INSERT INTO cliente (id_clinica, nombres, apellidos, documento, telefono, correo, direccion, id_membresia, fecha_inicio, fecha_vigencia, id_estado_membresia) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setInt(1, client.getIdClinica());
            ps.setString(2, client.getNombres());
            ps.setString(3, client.getApellidos());
            ps.setString(4, client.getDocumento());
            ps.setString(5, client.getTelefono());
            ps.setString(6, client.getCorreo());
            ps.setString(7, client.getDireccion());
            
            //Si no tiene membresia es NULL
            if (client.getIdMembresia() == null || client.getIdMembresia() == 0) {
                ps.setNull(8, java.sql.Types.INTEGER);
                ps.setNull(9, java.sql.Types.DATE);
                ps.setNull(10, java.sql.Types.DATE);
            } else {
                ps.setInt(8, client.getIdMembresia());
                ps.setString(9, client.getFechaInicio());
                ps.setString(10, client.getFechaVigencia());
            
            }
            if (client.getEstadoMembresia() == null || client.getEstadoMembresia() == 0) {
                ps.setInt(11, 1); // Activo por defecto
            } else {
                ps.setInt(11, client.getEstadoMembresia());
            }
            
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error en el registro de cliente: " + e.getMessage());
            return false;
        }
    }

    public List<ClienteModel> listarClientes(int idClinica) {
        List<ClienteModel> lista = new ArrayList<>();
        String sql = "SELECT c.*, m.nombre AS nombre_membresia "
               + "FROM cliente c "
               + "LEFT JOIN membresia m ON c.id_membresia = m.id_membresia "
               + "WHERE c.id_clinica = ?";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idClinica);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ClienteModel cliente = new ClienteModel();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setDocumento(rs.getString("documento"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setIdMembresia((Integer)rs.getObject("id_membresia"));
                cliente.setFechaInicio(rs.getString("fecha_inicio"));
                cliente.setFechaVigencia(rs.getString("fecha_vigencia"));
                cliente.setNombreMembresia(rs.getString("nombre_membresia"));
                lista.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
        return lista;
    }

    public boolean actualizarCliente(ClienteModel client) {
        String sql = "UPDATE cliente SET nombres=?, apellidos=?, documento=?, telefono=?, correo=?, direccion=?, id_membresia=?, fecha_inicio=?, fecha_vigencia=? WHERE id_cliente=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setString(1, client.getNombres());
            ps.setString(2, client.getApellidos());
            ps.setString(3, client.getDocumento());
            ps.setString(4, client.getTelefono());
            ps.setString(5, client.getCorreo());
            ps.setString(6, client.getDireccion());
            
            // validars si el cliente tiene memb
            if (client.getIdMembresia() == null || client.getIdMembresia() == 0) {
                ps.setNull(7, java.sql.Types.INTEGER);
                ps.setNull(8, java.sql.Types.DATE);
                ps.setNull(9, java.sql.Types.DATE);
            } else {
                ps.setInt(7, client.getIdMembresia());
                ps.setString(8, client.getFechaInicio());
                ps.setString(9, client.getFechaVigencia());
            }
            ps.setInt(10, client.getIdCliente());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la actualización de cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarCliente(int idCliente) {
        if (clienteTieneCitas(idCliente)) {
            JOptionPane.showMessageDialog(null,
                    "No se puede eliminar el cliente porque tiene citas registradas.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
            //verificar si el cliente tiene mascotas registradas
        }else if(clienteTieneMascotas(idCliente)){
             JOptionPane.showMessageDialog(null,"No se puede eliminar el cliente porque tiene mascotas registradas.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);   
             return false;
        }
        String sql = "DELETE FROM cliente WHERE id_cliente=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }
    
    public ClienteModel buscarClientesPorDocumento(String documento, int idClinica) {
        
        ClienteModel cliente = null;
        String sql = "SELECT c.*, m.nombre AS nombre_membresia " +
                 "FROM cliente c " +
                 "LEFT JOIN membresia m ON c.id_membresia = m.id_membresia " +
                 "WHERE c.documento = ? AND c.id_clinica = ?";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
                ps.setString(1, documento);
                ps.setInt(2, idClinica);
                System.out.println("Buscando cliente con documento: " + documento + " en clinica " + idClinica);
                
                ResultSet rs = ps.executeQuery();
                System.out.println("Ejecutada la consulta de busqueda.");

                if (rs.next()) {
                    cliente = new ClienteModel();
                    cliente.setIdCliente(rs.getInt("id_cliente"));
                    cliente.setNombres(rs.getString("nombres"));
                    cliente.setApellidos(rs.getString("apellidos"));
                    cliente.setDocumento(rs.getString("documento"));
                    cliente.setTelefono(rs.getString("telefono"));
                    cliente.setCorreo(rs.getString("correo"));
                    cliente.setDireccion(rs.getString("direccion"));
                    cliente.setIdMembresia((Integer)rs.getObject("id_membresia"));
                    cliente.setFechaInicio(rs.getString("fecha_inicio"));
                    cliente.setFechaVigencia(rs.getString("fecha_vigencia"));
                    cliente.setNombreMembresia(rs.getString("nombre_membresia"));
                }
            } catch (SQLException e) {
                System.out.println("Error buscando clientes: " + e.getMessage());
            }
            return cliente;
    }
    
    
    
    public ClienteModel ReadId(int idCliente) {
        
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ClienteModel c = new ClienteModel();
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setNombres(rs.getString("nombres"));
                c.setApellidos(rs.getString("apellidos"));
                c.setDocumento(rs.getString("documento"));
                
                return c;
            }
        } catch (SQLException e) {
            System.out.println("Error al leer cliente: " + e.getMessage());
        }
        return null;
    }

    
    
}
