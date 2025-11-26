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
import java.util.ArrayList;
import java.util.List;
import project.vetsys.database.DBConnection;
import project.vetsys.model.Cita;

/**
 *
 * @author Asus
 */
public class CitaDAO {
    
    // Horario base disponible
    public static String[] horasbase() {
        return new String[]{
            "08:00","09:00","10:00","11:00",
            "14:00","15:00","16:00"
        };
    }
    
    // Verificar si el veterinario ya tiene cita 
    public List<String> veterinarioOcupado(int idVeterinario, String fecha) {
        String sql = """
            SELECT DATE_FORMAT(fecha_cita, '%H:%i') 
            FROM cita
            WHERE id_veterinario = ?
            AND DATE(fecha_cita) = ?
            AND estado IN ('programada','realizada')
        """;

        List<String> horas = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idVeterinario);
            ps.setString(2, fecha); // yyyy-MM-dd
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                horas.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Error cargando horas ocupadas: " + e.getMessage());
        }
        return horas;
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
    
    
    public List<Cita> listarCitasPorClinica(int idClinica) {
        List<Cita> lista = new ArrayList<>();

        String sql =
            "SELECT c.id_cita, c.fecha_cita, c.estado, " +
            "cli.id_cliente, cli.nombres AS cliente_nombre, cli.apellidos AS cliente_apellido, " +
            "m.id_mascota, m.nombre AS mascota_nombre, " +
            "u.id_usuario AS vet_id, u.nombres AS vet_nombre, u.apellidos AS vet_apellido " +
            "FROM cita c " +
            "JOIN cliente cli ON c.id_cliente = cli.id_cliente " +
            "JOIN mascota m ON c.id_mascota = m.id_mascota " +
            "JOIN usuario u ON c.id_veterinario = u.id_usuario " +
            "WHERE c.id_clinica = ? " +
            "ORDER BY c.fecha_cita ASC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idClinica);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cita cita = new Cita();
                cita.setIdCita(rs.getInt("id_cita"));
                cita.setFecha(rs.getTimestamp("fecha_cita"));
                cita.setEstado(rs.getString("estado"));

                cita.setIdCliente(rs.getInt("id_cliente"));
                cita.setNombreCliente(rs.getString("cliente_nombre") + " " + rs.getString("cliente_apellido"));

                cita.setIdMascota(rs.getInt("id_mascota"));
                cita.setNombreMascota(rs.getString("mascota_nombre"));

                cita.setIdVeterinario(rs.getInt("vet_id"));
                cita.setNombreVeterinario(rs.getString("vet_nombre") + " " + rs.getString("vet_apellido"));

                lista.add(cita);
            }

        } catch (Exception e) {
            System.out.println("Error listando citas: " + e.getMessage());
        }

        return lista;
    }
    
    
    public List<Cita> buscarCitaPorDocumento(int idClinica, String documento) {

        List<Cita> lista = new ArrayList<>();

        String sql =
            "SELECT c.id_cita, c.fecha_cita, c.estado, " +
            "cli.id_cliente, cli.documento, cli.nombres AS cliente_nombre, cli.apellidos AS cliente_apellido, " +
            "m.id_mascota, m.nombre AS mascota_nombre, " +
            "u.id_usuario AS vet_id, u.nombres AS vet_nombre, u.apellidos AS vet_apellido " +
            "FROM cita c " +
            "JOIN cliente cli ON c.id_cliente = cli.id_cliente " +
            "JOIN mascota m ON c.id_mascota = m.id_mascota " +
            "JOIN usuario u ON c.id_veterinario = u.id_usuario " +
            "WHERE c.id_clinica = ? AND cli.documento = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idClinica);
            ps.setString(2, documento);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cita cita = new Cita();
                cita.setIdCita(rs.getInt("id_cita"));
                cita.setFecha(rs.getTimestamp("fecha_cita"));
                cita.setEstado(rs.getString("estado"));

                cita.setIdCliente(rs.getInt("id_cliente"));
                cita.setNombreCliente(rs.getString("cliente_nombre") + " " + rs.getString("cliente_apellido"));

                cita.setIdMascota(rs.getInt("id_mascota"));
                cita.setNombreMascota(rs.getString("mascota_nombre"));

                cita.setIdVeterinario(rs.getInt("vet_id"));
                cita.setNombreVeterinario(rs.getString("vet_nombre") + " " + rs.getString("vet_apellido"));

                lista.add(cita);
            }

        } catch (Exception e) {
            System.out.println("Error al buscar cita: " + e.getMessage());
        }
        return lista;
    }
    
    
    public List<Cita> buscarCitasPorEstado(int idClinica, String estado) {

        List<Cita> lista = new ArrayList<>();

        String sql =
            "SELECT c.id_cita, c.fecha_cita, c.estado, " +
            "cli.id_cliente, cli.documento, cli.nombres AS cliente_nombre, cli.apellidos AS cliente_apellido, " +
            "m.id_mascota, m.nombre AS mascota_nombre, " +
            "u.id_usuario AS vet_id, u.nombres AS vet_nombre, u.apellidos AS vet_apellido " +
            "FROM cita c " +
            "JOIN cliente cli ON c.id_cliente = cli.id_cliente " +
            "JOIN mascota m ON c.id_mascota = m.id_mascota " +
            "JOIN usuario u ON c.id_veterinario = u.id_usuario " +
            "WHERE c.id_clinica = ? AND c.estado = ? " +
            "ORDER BY c.fecha_cita DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idClinica);
            ps.setString(2, estado);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cita cita = new Cita();

                cita.setIdCita(rs.getInt("id_cita"));
                cita.setFecha(rs.getTimestamp("fecha_cita"));
                cita.setEstado(rs.getString("estado"));

                cita.setIdCliente(rs.getInt("id_cliente"));
                cita.setNombreCliente(rs.getString("cliente_nombre") + " " +
                                      rs.getString("cliente_apellido"));

                cita.setIdMascota(rs.getInt("id_mascota"));
                cita.setNombreMascota(rs.getString("mascota_nombre"));

                cita.setIdVeterinario(rs.getInt("vet_id"));
                cita.setNombreVeterinario(rs.getString("vet_nombre") + " " +
                                          rs.getString("vet_apellido"));

                lista.add(cita);
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar citas por estado: " + e.getMessage());
        }

        return lista;
    }
    
    
    public List<Cita> buscarCitaPorDocumentoYEstado(int idClinica, String documento, String estado) {

        List<Cita> lista = new ArrayList<>();

        String sql =
            "SELECT c.id_cita, c.fecha_cita, c.estado, " +
            "cli.id_cliente, cli.documento, cli.nombres AS cliente_nombre, cli.apellidos AS cliente_apellido, " +
            "m.id_mascota, m.nombre AS mascota_nombre, " +
            "u.id_usuario AS vet_id, u.nombres AS vet_nombre, u.apellidos AS vet_apellido " +
            "FROM cita c " +
            "JOIN cliente cli ON c.id_cliente = cli.id_cliente " +
            "JOIN mascota m ON c.id_mascota = m.id_mascota " +
            "JOIN usuario u ON c.id_veterinario = u.id_usuario " +
            "WHERE c.id_clinica = ? ";

        // fiiltros cedula
        if (documento != null) {
            sql += " AND cli.documento = ? ";
        }
        //filtro estado
        if (estado != null) {
            sql += " AND c.estado = ? ";
        }
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int index = 1;
            ps.setInt(index++, idClinica);

            if (documento != null) {
                ps.setString(index++, documento);
            }
            if (estado != null) {
                ps.setString(index++, estado);
            }
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cita cita = new Cita();
                cita.setIdCita(rs.getInt("id_cita"));
                cita.setFecha(rs.getTimestamp("fecha_cita"));
                cita.setEstado(rs.getString("estado"));

                cita.setIdCliente(rs.getInt("id_cliente"));
                cita.setNombreCliente(rs.getString("cliente_nombre") + " " + rs.getString("cliente_apellido"));

                cita.setIdMascota(rs.getInt("id_mascota"));
                cita.setNombreMascota(rs.getString("mascota_nombre"));

                cita.setIdVeterinario(rs.getInt("vet_id"));
                cita.setNombreVeterinario(rs.getString("vet_nombre") + " " + rs.getString("vet_apellido"));

                lista.add(cita);
            }

        } catch (Exception e) {
            System.out.println("Error al buscar cita: " + e.getMessage());
        }
        return lista;
    }
    
    
    public boolean actualizarCita(Cita cita) {
        
        // verificar si la nueva hora esta disponible
        String fecha = cita.getFecha().toString().substring(0,10);
        String hora = cita.getFecha().toString().substring(11,16);

        String sqlCheck = """
            SELECT COUNT(*) 
            FROM cita 
            WHERE id_veterinario = (
                SELECT id_veterinario FROM cita WHERE id_cita = ?
            )
            AND DATE(fecha_cita) = ?
            AND DATE_FORMAT(fecha_cita,'%H:%i') = ?
            AND estado IN ('programada','realizada')
            AND id_cita <> ?
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement psCheck = con.prepareStatement(sqlCheck)) {

            psCheck.setInt(1, cita.getIdCita());
            psCheck.setString(2, fecha);
            psCheck.setString(3, hora);
            psCheck.setInt(4, cita.getIdCita());

            ResultSet rs = psCheck.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Hora ocupada");
                return false;
            }
        } catch(Exception e){
            System.out.println("Error validando disponibilidad: "+e.getMessage());
            return false;
        }
        // si esta disponible entonces actualizar
        String sql = "UPDATE cita SET fecha_cita = ? WHERE id_cita = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setTimestamp(1, cita.getFecha());
            ps.setInt(2, cita.getIdCita());
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("Error actualizando cita: " + e.getMessage());
            return false;
        }
    }
    
    
    public boolean cancelarCita(int idCita) {
        String sql = "UPDATE cita SET estado = 'cancelada' WHERE id_cita = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCita);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error cancelando cita: " + e.getMessage());
            return false;
        }
    }
    
    public boolean eliminarCita(int idCita) {
        String sql = "DELETE FROM cita WHERE id_cita = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCita);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error eliminando cita: " + e.getMessage());
            return false;
        }
    }

    
    public List<Cita> listarCitasPendientes(int idClinica, int idVeterinario) {

        List<Cita> lista = new ArrayList<>();

        String sql =
            "SELECT c.id_cita, c.fecha_cita, c.estado, " +
            "cli.id_cliente, cli.nombres AS cliente_nombre, cli.apellidos AS cliente_apellido, " +
            "m.id_mascota, m.nombre AS mascota_nombre, " +
            "u.id_usuario AS vet_id, u.nombres AS vet_nombre, u.apellidos AS vet_apellido " +
            "FROM cita c " +
            "JOIN cliente cli ON c.id_cliente = cli.id_cliente " +
            "JOIN mascota m ON c.id_mascota = m.id_mascota " +
            "JOIN usuario u ON c.id_veterinario = u.id_usuario " +
            "WHERE c.id_clinica = ? " +
            "AND c.id_veterinario = ? " +
            "AND c.estado = 'programada' " +
            "AND c.fecha_cita >= NOW() " +
            "ORDER BY c.fecha_cita ASC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idClinica);
            ps.setInt(2, idVeterinario);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cita cita = new Cita();

                cita.setIdCita(rs.getInt("id_cita"));
                cita.setFecha(rs.getTimestamp("fecha_cita"));
                cita.setEstado(rs.getString("estado"));

                cita.setIdCliente(rs.getInt("id_cliente"));
                cita.setNombreCliente(rs.getString("cliente_nombre") + " " + rs.getString("cliente_apellido"));

                cita.setIdMascota(rs.getInt("id_mascota"));
                cita.setNombreMascota(rs.getString("mascota_nombre"));

                cita.setIdVeterinario(rs.getInt("vet_id"));
                cita.setNombreVeterinario(rs.getString("vet_nombre") + " " + rs.getString("vet_apellido"));

                lista.add(cita);
            }

        } catch (Exception e) {
            System.out.println("Error al listar citas pendientes: " + e.getMessage());
        }

        return lista;
    }
    
    
    public List<Cita> buscarCitasPendientesPorDocumento(int idClinica, int idVeterinario, String documento) {

        List<Cita> lista = new ArrayList<>();

        String sql =
            "SELECT c.id_cita, c.fecha_cita, c.estado, " +
            "cli.id_cliente, cli.documento, cli.nombres AS cliente_nombre, cli.apellidos AS cliente_apellido, " +
            "m.id_mascota, m.nombre AS mascota_nombre, " +
            "u.id_usuario AS vet_id, u.nombres AS vet_nombre, u.apellidos AS vet_apellido " +
            "FROM cita c " +
            "JOIN cliente cli ON c.id_cliente = cli.id_cliente " +
            "JOIN mascota m ON c.id_mascota = m.id_mascota " +
            "JOIN usuario u ON c.id_veterinario = u.id_usuario " +
            "WHERE c.id_clinica = ? " +
            "AND c.id_veterinario = ? " +
            "AND c.estado = 'programada' " +
            "AND c.fecha_cita >= NOW() " +
            "AND cli.documento LIKE ? " +
            "ORDER BY c.fecha_cita ASC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idClinica);
            ps.setInt(2, idVeterinario);
            ps.setString(3, "%" + documento + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cita cita = new Cita();

                cita.setIdCita(rs.getInt("id_cita"));
                cita.setFecha(rs.getTimestamp("fecha_cita"));
                cita.setEstado(rs.getString("estado"));

                cita.setIdCliente(rs.getInt("id_cliente"));
                cita.setNombreCliente(rs.getString("cliente_nombre") + " " + rs.getString("cliente_apellido"));

                cita.setIdMascota(rs.getInt("id_mascota"));
                cita.setNombreMascota(rs.getString("mascota_nombre"));

                cita.setIdVeterinario(rs.getInt("vet_id"));
                cita.setNombreVeterinario(rs.getString("vet_nombre") + " " + rs.getString("vet_apellido"));

                lista.add(cita);
            }

        } catch (Exception e) {
            System.out.println("Error al buscar pendientes por documento: " + e.getMessage());
        }

        return lista;
    }
    
    
    public boolean marcarCitaComoAtendida(int idCita) {

        String sql = "UPDATE cita SET estado = 'realizada' WHERE id_cita = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCita);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al actualizar estado: " + e.getMessage());
            return false;
        }
    }




}
    
