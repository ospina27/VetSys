package project.vetsys.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import project.vetsys.database.DBConnection;
import project.vetsys.model.Status;
import project.vetsys.model.User;

public class StatusDAO {
    
    public List<Status> getAllStatus(User logUser){
        List<Status> status = new ArrayList<>();
        String sql = "Select * FROM estado";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                status.add(new Status(
                    rs.getInt("id_estado"),
                    rs.getString("nombre")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener estado: " + e.getMessage());
        }
        return status;
    } 
    
}
