/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logins;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class DBCon {
     public Driver d = null;
    public Connection con = null;
    public Statement stmt = null;
    public ResultSet rs = null;

    public void conOpen() {
        try {
            d = new com.mysql.jdbc.Driver();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info_ms_db", "root", "");
            stmt = con.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(DBCon.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void nonSelect(String query) {
        try {
            conOpen();
            stmt.executeUpdate(query);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Select(String query) {
        try {
            conOpen();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBCon.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
}
