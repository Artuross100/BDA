package DaoMySQL;

import Entidades.GrupoAlimentos;
import Entidades.Producto;
import Entidades.UnidadMedida;
import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDao implements Serializable {

    private Conexion conexion;

    public ProductoDao() throws SQLException {
        this.conexion = new Conexion();
    }

    public boolean registrar(Producto p) {
        String consulta = "INSERT INTO Producto (codigo, unidadMedida, nombre, "
                + "peso, medida, grupo) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conexion.getConexion().prepareStatement(consulta);
            ps.setString(1, p.getCodigo());
            ps.setLong(2, p.getUnidad().getId());
            ps.setString(3, p.getNombre());
            ps.setFloat(4, p.getPeso());
            ps.setFloat(5, p.getMedida());
            ps.setLong(6, p.getGrupo().getId());
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
    
    public ArrayList<Producto> cargar() {
        ArrayList<Producto> tipos = new ArrayList<Producto>();
        String consulta = "SELECT u.id, u.descripcion, p.codigo, "
                + "p.nombre, p.peso, p.medida, "
                + "p.precio, g.id, g.descripcion "
                + "FROM UnidadMedida u, Producto p, GrupoAlimentos g "
                + "WHERE u.id=p.unidadMedida AND g.id=p.grupo";
        try {
            PreparedStatement stmt = this.conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery();
            Producto t;
            GrupoAlimentos g;
            UnidadMedida u;
            while (rs.next()) {
                t = new Producto();
                u = new UnidadMedida();
                g = new GrupoAlimentos();
                u.setId(rs.getLong(1));
                u.setDescripcion(rs.getString(2));
                t.setCodigo(rs.getString(3));
                t.setNombre(rs.getString(4));
                t.setPeso(rs.getFloat(5));
                t.setMedida(rs.getFloat(6));
                t.setPrecio(rs.getFloat(7));
                g.setId(rs.getLong(8));
                g.setDescripcion(rs.getString(9));
                t.setUnidad(u);
                t.setGrupo(g);
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

}
