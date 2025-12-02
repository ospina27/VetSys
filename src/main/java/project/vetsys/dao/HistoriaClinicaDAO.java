package project.vetsys.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import project.vetsys.database.DBConnection;
import project.vetsys.model.ClienteModel;
import project.vetsys.model.HistoriaClinica;
import project.vetsys.model.HistoriaClinicaDetalle;
import project.vetsys.model.Pet;



public class HistoriaClinicaDAO {

    
    
    public boolean registrarAtencion(HistoriaClinica hc) {
        
        String insertSQL = """
                INSERT INTO historial_clinico (id_clinica, id_mascota, id_veterinario, id_cita, motivo_consulta, diagnostico, tratamiento, peso)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;
        String sql = "UPDATE cita SET estado = 'Realizada' WHERE id_cita = ?";

        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
            connection.setAutoCommit(false);
            // insert historial
            try (PreparedStatement ps = connection.prepareStatement(insertSQL)) {
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
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, hc.getIdCita());
                ps.executeUpdate();
            }
            connection.commit();
            return true;
        } catch (SQLException e) {
            try { if (connection != null) connection.rollback(); } catch (SQLException ignored) {}
            System.out.println("Error en el registro de historia clinica: " + e.getMessage());
            return false;
        } finally {
            try { if (connection != null) connection.setAutoCommit(true); connection.close(); } catch (SQLException ignored) {}
        }
    }


    public List<HistoriaClinica> listarPorMascota(int idMascota) {
        String sql = "SELECT * FROM historial_clinico WHERE id_mascota = ? ORDER BY fecha_registro DESC";
        List<HistoriaClinica> lista = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idMascota);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) lista.add(mapearHistoriaClinica(rs));
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
            if (rs.next()) hc = mapearHistoriaClinica(rs);
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
            while (rs.next()) lista.add(mapearHistoriaClinica(rs));
        } catch (SQLException e) {
            System.out.println("Error listando historial clinicos: " + e.getMessage());
        }
        return lista;
    }



    private HistoriaClinica mapearHistoriaClinica(ResultSet rs) throws SQLException {
        
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
    
    
    private HistoriaClinicaDetalle mapearDetalleHC(ResultSet rs) throws SQLException {

        HistoriaClinicaDetalle detalle = new HistoriaClinicaDetalle();

        detalle.setIdHistoria(rs.getInt("id_historia"));

        Timestamp ts = rs.getTimestamp("fecha_registro");
        if (ts != null) detalle.setFechaRegistro(ts.toLocalDateTime());

        detalle.setIdMascota(rs.getInt("id_mascota"));
        detalle.setNombreMascota(rs.getString("mascota_nombre"));
        detalle.setEspecie(rs.getString("especie"));
        detalle.setRaza(rs.getString("raza"));
        detalle.setColor(rs.getString("color"));
        detalle.setSexo(rs.getString("sexo"));

        Date fn = rs.getDate("fecha_nacimiento");
        if (fn != null) detalle.setFechaNacimiento(fn.toLocalDate());

        detalle.setIdCliente(rs.getInt("cliente_id"));
        detalle.setNombreCliente(rs.getString("cliente_nombre") + " " + rs.getString("cliente_apellidos"));
        detalle.setDocumentoCliente(rs.getString("cliente_documento"));
        detalle.setTelefonoCliente(rs.getString("cliente_telefono"));
        detalle.setCorreoCliente(rs.getString("cliente_correo"));

        detalle.setNombreVeterinario(rs.getString("vet_nombre") + " " + rs.getString("vet_apellidos"));

        detalle.setMotivo(rs.getString("motivo_consulta"));
        detalle.setDiagnostico(rs.getString("diagnostico"));
        detalle.setTratamiento(rs.getString("tratamiento"));
        BigDecimal peso = rs.getBigDecimal("peso");
        detalle.setPeso(peso != null ? peso.toString() : null);

        return detalle;
    }
    
    
    
    public List<HistoriaClinicaDetalle> listarDetallesPorClinica(int idClinica) {

        String sql = """
            SELECT
              hc.id_historia,
              hc.fecha_registro,
              hc.motivo_consulta,
              hc.diagnostico,
              hc.tratamiento,
              hc.peso,
              hc.id_mascota,
              m.nombre AS mascota_nombre,
              m.especie,
              m.raza,
              m.color,
              m.sexo,
              m.fecha_nacimiento,
              m.id_cliente AS cliente_id,
              c.nombres AS cliente_nombre,
              c.apellidos AS cliente_apellidos,
              c.documento AS cliente_documento,
              c.telefono AS cliente_telefono,
              c.correo AS cliente_correo,
              u.nombres AS vet_nombre,
              u.apellidos AS vet_apellidos
            FROM historial_clinico hc
            JOIN mascota m ON hc.id_mascota = m.id_mascota
            JOIN cliente c ON m.id_cliente = c.id_cliente
            JOIN usuario u ON hc.id_veterinario = u.id_usuario
            WHERE hc.id_clinica = ?
            ORDER BY hc.fecha_registro DESC
        """;

        List<HistoriaClinicaDetalle> lista = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idClinica);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
                lista.add(mapearDetalleHC(rs));
        } catch (SQLException e) {
            System.out.println("Error listando detalle historial: " + e.getMessage());
        }
        return lista;
    }
    
    
    public List<HistoriaClinicaDetalle> filtrarPorDocumento(int idClinica, String documento) {

        String sql = """
            SELECT
              hc.id_historia,
              hc.fecha_registro,
              hc.motivo_consulta,
              hc.diagnostico,
              hc.tratamiento,
              hc.peso,
              hc.id_mascota,
              m.nombre AS mascota_nombre,
              m.especie,
              m.raza,
              m.color,
              m.sexo,
              m.fecha_nacimiento,
              m.id_cliente AS cliente_id,
              c.nombres AS cliente_nombre,
              c.apellidos AS cliente_apellidos,
              c.documento AS cliente_documento,
              c.telefono AS cliente_telefono,
              c.correo AS cliente_correo,
              u.nombres AS vet_nombre,
              u.apellidos AS vet_apellidos
            FROM historial_clinico hc
            JOIN mascota m ON hc.id_mascota = m.id_mascota
            JOIN cliente c ON m.id_cliente = c.id_cliente
            JOIN usuario u ON hc.id_veterinario = u.id_usuario
            WHERE hc.id_clinica = ? AND c.documento LIKE ?
            ORDER BY hc.fecha_registro DESC
        """;

        List<HistoriaClinicaDetalle> lista = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idClinica);
            ps.setString(2, documento + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
                lista.add(mapearDetalleHC(rs));
        } catch (SQLException e) {
            System.out.println("Error filtrando historial: " + e.getMessage());
        }
        return lista;
    }
    
    
    public List<HistoriaClinicaDetalle> filtrarPorVeterinario(int idClinica, int idVet) {
        String sql = """
            SELECT
              hc.id_historia,
              hc.fecha_registro,
              hc.motivo_consulta,
              hc.diagnostico,
              hc.tratamiento,
              hc.peso,
              hc.id_mascota,
              m.nombre AS mascota_nombre,
              m.especie,
              m.raza,
              m.color,
              m.sexo,
              m.fecha_nacimiento,
              m.id_cliente AS cliente_id,
              c.nombres AS cliente_nombre,
              c.apellidos AS cliente_apellidos,
              c.documento AS cliente_documento,
              c.telefono AS cliente_telefono,
              c.correo AS cliente_correo,
              u.nombres AS vet_nombre,
              u.apellidos AS vet_apellidos
            FROM historial_clinico hc
            JOIN mascota m ON hc.id_mascota = m.id_mascota
            JOIN cliente c ON m.id_cliente = c.id_cliente
            JOIN usuario u ON hc.id_veterinario = u.id_usuario
            WHERE hc.id_clinica = ? AND u.id_usuario = ?
            ORDER BY hc.fecha_registro DESC
        """;

        List<HistoriaClinicaDetalle> lista = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idClinica);
            ps.setInt(2, idVet);

            ResultSet rs = ps.executeQuery();
            while (rs.next())
                lista.add(mapearDetalleHC(rs));
        } catch (SQLException e) {
            System.out.println("Error filtrando por veterinario: " + e.getMessage());
        }
        return lista;
    }
    
    
    
    public List<HistoriaClinicaDetalle> filtrarPorFecha(int idClinica, Timestamp fecha) {

        List<HistoriaClinicaDetalle> lista = new ArrayList<>();

        String sql = """
            SELECT
              hc.id_historia,
              hc.fecha_registro,
              hc.motivo_consulta,
              hc.diagnostico,
              hc.tratamiento,
              hc.peso,
              hc.id_mascota,
              m.nombre AS mascota_nombre,
              m.especie,
              m.raza,
              m.color,
              m.sexo,
              m.fecha_nacimiento,
              m.id_cliente AS cliente_id,
              c.nombres AS cliente_nombre,
              c.apellidos AS cliente_apellidos,
              c.documento AS cliente_documento,
              c.telefono AS cliente_telefono,
              c.correo AS cliente_correo,
              u.nombres AS vet_nombre,
              u.apellidos AS vet_apellidos
            FROM historial_clinico hc
            JOIN mascota m ON hc.id_mascota = m.id_mascota
            JOIN cliente c ON m.id_cliente = c.id_cliente
            JOIN usuario u ON hc.id_veterinario = u.id_usuario
            WHERE hc.id_clinica = ?
            AND DATE(hc.fecha_registro) = DATE(?)
            ORDER BY hc.fecha_registro DESC
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idClinica);
            ps.setTimestamp(2, fecha);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) 
                    lista.add(mapearDetalleHC(rs));
            }
        } catch (SQLException e) {
            System.out.println("Error filtro por fecha: " + e.getMessage());
        }
        return lista;
    }


    public HistoriaClinicaDetalle obtenerDetallePorId(int idHistoria) {
    
        String sql = """
            SELECT
              hc.id_historia,
              hc.fecha_registro,
              hc.motivo_consulta,
              hc.diagnostico,
              hc.tratamiento,
              hc.peso,
              hc.id_mascota,
              m.nombre AS mascota_nombre,
              m.especie,
              m.raza,
              m.color,
              m.sexo,
              m.fecha_nacimiento,
              m.id_cliente AS cliente_id,
              c.nombres AS cliente_nombre,
              c.apellidos AS cliente_apellidos,
              c.documento AS cliente_documento,
              c.telefono AS cliente_telefono,
              c.correo AS cliente_correo,
              u.nombres AS vet_nombre,
              u.apellidos AS vet_apellidos
            FROM historial_clinico hc
            JOIN mascota m ON hc.id_mascota = m.id_mascota
            JOIN cliente c ON m.id_cliente = c.id_cliente
            JOIN usuario u ON hc.id_veterinario = u.id_usuario
            WHERE id_historia = ?
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idHistoria);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapearDetalleHC(rs);
            }

        } catch (SQLException e) {
            System.out.println("Error obteniendo detalle: " + e.getMessage());
        }

        return null;
    }


              
    
}
