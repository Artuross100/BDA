package Util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion implements Serializable {

    private Connection conexion;
    private final String schemaPpal = "ufps_6";
    private final String db_url = "jdbc:mysql://sandbox2.ufps.edu.co/" + schemaPpal;
    private final String db_driver = "com.mysql.jdbc.Driver";
    private final String db_usuario = "ufps_6";
    private final String db_contrasena = "ufps_29";

    public Conexion() throws SQLException {
        try {
            Class.forName(db_driver).newInstance();
            conexion = DriverManager.getConnection(db_url, db_usuario, db_contrasena);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (InstantiationException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() throws SQLException {

        if (conexion != null) {
            try {
                conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    throw e;
                } catch (Exception ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public long obtenerConsecutivo(String tabla) {
        long id = 0;
        try {
            String consulta = "SELECT `AUTO_INCREMENT` "
                    + "FROM  INFORMATION_SCHEMA.TABLES "
                    + "WHERE TABLE_SCHEMA = '" + this.schemaPpal + "' "
                    + "AND TABLE_NAME  = '" + tabla + "'";
            PreparedStatement pst = this.conexion.prepareStatement(consulta);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getLong(1);
            }
            rs.close();
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public String getSchema() {
        return this.schemaPpal;
    }

    public Connection getConexion() {
        return conexion;
    }

    public static void main(String[] args) {
        try {
            Conexion co = new Conexion();
            System.out.println(co.obtenerConsecutivo("TipoUsuario"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
