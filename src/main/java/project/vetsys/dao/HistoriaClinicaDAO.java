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
import project.vetsys.model.HistoriaClinica;

/**
 *
 * @author Asus
 */
public class HistoriaClinicaDAO {
    
    public boolean registrarAtencion(HistoriaClinica hc) {
        
        String insertSQL = """
                INSERT INTO historial_clinico
                (id_clinica, id_mascota, id_veterinario, id_cita, motivo_consulta, diagnostico, tratamiento, peso)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;
        String sql = "UPDATE cita SET estado = 'Realizada' WHERE id_cita = ?";

        Connection con = null;
        
        try {
            con = DBConnection.getConnection();
            con.setAutoCommit(false);

            // insert historial
            try (PreparedStatement ps = con.prepareStatement(insertSQL)) {
                ps.setInt(1, hc.getIdClinica());
                ps.setInt(2, hc.getIdMascota());
                ps.setInt(3, hc.getIdVeterinario());
                ps.setInt(4, hc.getIdCita());
                ps.setString(5, hc.getMotivoConsulta());
                ps.setString(6, hc.getDiagnostico());
                ps.setString(7, hc.getTratamiento());
                ps.setBigDecimal(8, hc.getPeso());
                ps.executeUpdate();
            }

            // update estado cita 
            try (PreparedStatement ps2 = con.prepareStatement(sql)) {
                ps2.setInt(1, hc.getIdCita());
                ps2.executeUpdate();
            }

            con.commit();
            return true;

        } catch (SQLException e) {
            try { if (con != null) con.rollback(); } catch (SQLException ignored) {}
            System.out.println("Error en el registro de historia clinica: " + e.getMessage());
            return false;

        } finally {
            try { if (con != null) con.setAutoCommit(true); con.close(); } catch (SQLException ignored) {}
        }
    }


    public List<HistoriaClinica> listarPorMascota(int idMascota) {
        String sql = "SELECT * FROM historial_clinico WHERE id_mascota = ? ORDER BY fecha_registro DESC";
        List<HistoriaClinica> lista = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idMascota);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) lista.add(mapear(rs));

        } catch (SQLException e) {
            System.out.println("Error listando historial por mascota: " + e.getMessage());
        }

        return lista;
    }



    public HistoriaClinica obtenerPorCita(int idCita) {
        String sql = "SELECT * FROM historial_clinico WHERE id_cita = ?";
        HistoriaClinica hc = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCita);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) hc = mapear(rs);

        } catch (SQLException e) {
            System.out.println("Error buscando historial por cita: " + e.getMessage());
        }

        return hc;
    }



    public List<HistoriaClinica> listarPorClinica(int idClinica) {
        String sql = "SELECT * FROM historial_clinico WHERE id_clinica = ? ORDER BY fecha_registro DESC";
        List<HistoriaClinica> lista = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idClinica);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) lista.add(mapear(rs));

        } catch (SQLException e) {
            System.out.println("Error listando historial clinicos: " + e.getMessage());
        }

        return lista;
    }



    private HistoriaClinica mapear(ResultSet rs) throws SQLException {
        HistoriaClinica hc = new HistoriaClinica();

        hc.setIdHistoria(rs.getInt("id_historia"));
        hc.setIdClinica(rs.getInt("id_clinica"));
        hc.setIdMascota(rs.getInt("id_mascota"));
        hc.setIdVeterinario(rs.getInt("id_veterinario"));
        hc.setIdCita(rs.getInt("id_cita"));
        hc.setFechaRegistro(rs.getTimestamp("fecha_registro").toLocalDateTime());
        hc.setMotivoConsulta(rs.getString("motivo_consulta"));
        hc.setDiagnostico(rs.getString("diagnostico"));
        hc.setTratamiento(rs.getString("tratamiento"));
        hc.setPeso(rs.getBigDecimal("peso"));

        return hc;
    }
              
    
}
