/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package project.vetsys;

import java.sql.Connection;
import project.vetsys.database.DBConnection;

/**
 *
 * @author User
 */
public class VetSys {

    public static void main(String[] args) {
        Connection connection = DBConnection.getConnection();
        
    }
}
