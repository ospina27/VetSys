/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.vetsys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import project.vetsys.database.DBConnection;
import project.vetsys.model.Cita;

/**
 *
 * @author Asus
 */
public class CitaDAO {
    
    // Verificar si el veterinario ya tiene cita 
    public boolean veterinarioOcupado(int idVeterinario, Date fecha) {
        String sql = "SELECT COUNT(*) FROM cita WHERE id_veterinario = ? AND fecha_cita = ? AND estado IN ('programada', 'realizada')";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idVeterinario);
            stmt.setDate(2, fecha);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            System.out.println("Error verificando disponibilidad: " + e.getMessage());
        }

        return true; // ante un error, mejor bloquear la cita
    }

    // Insertar nueva cita
    public boolean registrarCita(Cita cita) {
        String sql = "INSERT INTO cita (id_clinica, id_cliente, id_mascota, id_veterinario, fecha_cita, estado) VALUES (?,?,?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cita.getIdClinica());
            ps.setInt(2, cita.getIdCliente());
            ps.setInt(3, cita.getIdMascota());
            ps.setInt(4, cita.getIdVeterinario());
            ps.setTimestamp(5, cita.getFecha());
            ps.setString(6, cita.getEstado());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error insertando cita: " + e.getMessage());
            return false;
        }
    }
}
    
