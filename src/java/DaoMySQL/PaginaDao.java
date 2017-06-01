package DaoMySQL;

import Entidades.Pagina;
import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaginaDao implements Serializable{
    
    private Conexion conexion;

    public PaginaDao() throws SQLException {
        this.conexion = new Conexion();
    }
    
    public boolean registrar(Pagina p) {
        String consulta = "INSERT INTO Pagina (carpeta, ruta, "
                + "titulo) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = this.conexion.getConexion().prepareStatement(consulta);
            ps.setLong(1, p.getIdCarpeta());
            ps.setString(2, p.getRuta());
            ps.setString(3, p.getTitulo());
            int x = ps.executeUpdate();
            ps.close();
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
    
    public ArrayList<Pagina> cargar() {
        ArrayList<Pagina> tipos = new ArrayList<Pagina>();
        String consulta = "SELECT p.id, p.carpeta, p.titulo, "
                + "p.ruta "
                + "FROM Pagina p";
        try {
            PreparedStatement stmt = this.conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery();
            Pagina t;
            while (rs.next()) {
                t = new Pagina();
                t.setId(rs.getLong(1));
                t.setIdCarpeta(rs.getLong(2));
                t.setTitulo(rs.getString(3));
                t.setRuta(rs.getString(4));
                tipos.add(t);
            }
            rs.close();
            stmt.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return tipos;
    }
    
    public ArrayList<Pagina> cargarPorRol(long id) {
        ArrayList<Pagina> tipos = new ArrayList<Pagina>();
        String consulta = "SELECT p.id, p.carpeta, p.titulo, "
                + "p.ruta "
                + "FROM Pagina p, Permiso e, Rol r, RolUsuario u "
                + "WHERE p.id=e.pagina AND e.rol=r.id AND u.rol=r.id AND u.idUsuario=?";
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(consulta);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            Pagina t;
            while (rs.next()) {
                t = new Pagina();
                t.setId(rs.getLong(1));
                t.setIdCarpeta(rs.getLong(2));
                t.setTitulo(rs.getString(3));
                t.setRuta(rs.getString(4));
                tipos.add(t);
            }
            rs.close();
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return tipos;
    }
    
    public ArrayList<Pagina> cargarRolSinDefinir(long id) {
        ArrayList<Pagina> tipos = new ArrayList<Pagina>();
        String consulta = "SELECT p.id, p.carpeta, p.titulo, "
                + "p.ruta "
                + "FROM Pagina p "
                + "WHERE p.id NOT IN (SELECT p.id "
                + "FROM Pagina pi, Permiso ee "
                + "WHERE pi.id=ee.pagina AND ee.rol=?)";
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(consulta);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            Pagina t;
            while (rs.next()) {
                t = new Pagina();
                t.setId(rs.getLong(1));
                t.setIdCarpeta(rs.getLong(2));
                t.setTitulo(rs.getString(3));
                t.setRuta(rs.getString(4));
                tipos.add(t);
            }
            rs.close();
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return tipos;
    }
}
