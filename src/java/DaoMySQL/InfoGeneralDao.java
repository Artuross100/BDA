package DaoMySQL;

import Entidades.CondicionFisica;
import Entidades.InfoGeneral;
import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoGeneralDao implements Serializable {

    private Conexion conexion;

    public InfoGeneralDao() throws SQLException {
        this.conexion = new Conexion();
    }

    public boolean insertarMision(String mision) {
        String consulta = "UPDATE InfoGeneral "
                + "SET mision=? where id=?";
        try {
            PreparedStatement stmt = this.conexion.getConexion().prepareStatement(consulta);
            stmt.setString(1, mision);
            stmt.setInt(2, 1);
            int x = stmt.executeUpdate();
            stmt.close();
            this.conexion.close();
            if (x == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean insertarVision(String vision) {
        String consulta = "UPDATE InfoGeneral "
                + "SET vision=? where id=?";
        try {
            PreparedStatement stmt = this.conexion.getConexion().prepareStatement(consulta);
            stmt.setString(1, vision);
            stmt.setInt(2, 1);
            int x = stmt.executeUpdate();
            stmt.close();
            this.conexion.close();
            if (x == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean insertarObjetivos(String objetivos) {
        String consulta = "UPDATE InfoGeneral "
                + "SET objetivos=? where id=?";
        try {
            PreparedStatement stmt = this.conexion.getConexion().prepareStatement(consulta);
            stmt.setString(1, objetivos);
            stmt.setInt(2, 1);
            int x = stmt.executeUpdate();
            stmt.close();
            this.conexion.close();
            if (x == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean insertarQuienesSomos(String quienesSomos) {
        String consulta = "UPDATE InfoGeneral "
                + "SET quienesSomos=? where id=?";
        try {
            PreparedStatement stmt = this.conexion.getConexion().prepareStatement(consulta);
            stmt.setString(1, quienesSomos);
            stmt.setInt(2, 1);
            int x = stmt.executeUpdate();
            stmt.close();
            this.conexion.close();
            if (x == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean insertarBancoDescripcion(String bancoDescripcion) {
        String consulta = "UPDATE InfoGeneral "
                + "SET bancoDescripcion=? where id=?";
        try {
            PreparedStatement stmt = this.conexion.getConexion().prepareStatement(consulta);
            stmt.setString(1, bancoDescripcion);
            stmt.setInt(2, 1);
            int x = stmt.executeUpdate();
            stmt.close();
            this.conexion.close();
            if (x == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean insertarPrincipios(String principios) {
        String consulta = "UPDATE InfoGeneral "
                + "SET principios=? where id=?";
        try {
            PreparedStatement stmt = this.conexion.getConexion().prepareStatement(consulta);
            stmt.setString(1, principios);
            stmt.setInt(2, 1);
            int x = stmt.executeUpdate();
            stmt.close();
            this.conexion.close();
            if (x == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }

    public InfoGeneral cargarInfoGeneral() {
        InfoGeneral t = null;
        String consulta = "SELECT mision, vision, objetivos, "
                + "quienesSomos, bancoDescripcion, principios "
                + "FROM InfoGeneral "
                + "WHERE id=?";
        try {
            PreparedStatement stmt = this.conexion.getConexion().prepareStatement(consulta);
            stmt.setInt(1, 1);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                t = new InfoGeneral();
                t.setMision(rs.getString(1));
                t.setVision(rs.getString(2));
                t.setObjetivos(rs.getString(3));
                t.setQuienesSomos(rs.getString(4));
                t.setBancoDescripcion(rs.getString(5));
                t.setPrincipios(rs.getString(6));
            }
            rs.close();
            stmt.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return t;
    }
}
