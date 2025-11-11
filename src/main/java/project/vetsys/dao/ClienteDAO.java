/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.vetsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import project.vetsys.database.DBConnection;
import project.vetsys.model.ClienteModel;

/**
 *
 * @author Asus
 */
public class ClienteDAO {
    
    public boolean insertarCliente(ClienteModel client) {
        String sql = "INSERT INTO cliente (id_clinica, nombres, apellidos, documento, telefono, correo, direccion, id_membresia, fecha_inicio, fecha_vigencia, estado_membresia) "
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
            ps.setInt(8, client.getIdMembresia());
            ps.setString(9, client.getFechaInicio());
            ps.setString(10, client.getFechaVigencia());
            ps.setInt(11, client.getEstadoMembresia());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en el registro de cliente: " + e.getMessage());
            return false;
        }
    }

    public List<ClienteModel> listarClientes(int idClinica) {
        List<ClienteModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE id_clinica = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idClinica);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ClienteModel c = new ClienteModel();
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setNombres(rs.getString("nombres"));
                c.setApellidos(rs.getString("apellidos"));
                c.setDocumento(rs.getString("documento"));
                c.setTelefono(rs.getString("telefono"));
                c.setCorreo(rs.getString("correo"));
                c.setDireccion(rs.getString("direccion"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
        return lista;
    }

    public boolean actualizarCliente(ClienteModel client) {
        String sql = "UPDATE cliente SET nombres=?, apellidos=?, telefono=?, correo=?, direccion=?, id_membresia=?, fecha_inicio=?, fecha_vigencia=?, estado_membresia=? WHERE id_cliente=? AND id_clinica=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setString(1, client.getNombres());
            ps.setString(2, client.getApellidos());
            ps.setString(3, client.getTelefono());
            ps.setString(4, client.getCorreo());
            ps.setString(5, client.getDireccion());
            ps.setInt(6, client.getIdMembresia());
            ps.setString(7, client.getFechaInicio());
            ps.setString(8, client.getFechaVigencia());
            ps.setInt(9, client.getEstadoMembresia());
            ps.setInt(10, client.getIdCliente());
            ps.setInt(11, client.getIdClinica());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la actualización de cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarCliente(int idCliente, int idClinica) {
        String sql = "DELETE FROM cliente WHERE id_cliente=? AND id_clinica=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            ps.setInt(2, idClinica);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }
    
    
    
}
