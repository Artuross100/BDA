package DaoMySQL;

import Entidades.Donante;
import Entidades.TipoIdentificacion;
import Entidades.TipoPersona;
import Entidades.TipoUsuario;
import Entidades.Usuario;
import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DonanteDao implements Serializable {

    private final Conexion conexion;

    public DonanteDao() throws SQLException {
        this.conexion = new Conexion();
    }

    public boolean insertar(long id){
        boolean b = false;
        String cosulta = "INSERT INTO Donante (idUsuario) "
                + "VALUES (?)";
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(cosulta);
            pst.setLong(1, id);
            b = pst.execute();
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return b;
    }
    
    public ArrayList<Donante> listarDonantes() {
        ArrayList<Donante> usuarios = new ArrayList<Donante>();
        String consulta = "SELECT * "
                + "FROM Usuario u, TipoUsuario t, TipoIdentificacion i, TipoPersona p, Donante d "
                + "WHERE u.tipoIdentificacion=i.id AND u.tipoPersona=p.id AND "
                + "u.tipoUsuario=t.id AND u.id=d.idUsuario "
                + "ORDER BY u.fechaRegistro DESC";
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = pst.executeQuery();
            TipoUsuario tu;
            TipoPersona tp;
            TipoIdentificacion ti;
            Donante u;
            while (rs.next()) {
                u = new Donante();
                tu = new TipoUsuario(rs.getLong("t.id"), rs.getString("t.descripcion"));
                tp = new TipoPersona(rs.getLong("p.id"), rs.getString("p.descripcion"));
                ti = new TipoIdentificacion(rs.getLong("i.id"), rs.getString("i.descripcion"));
                u.setNombres(rs.getString("u.nombres"));
                u.setApellidos(rs.getString("u.apellidos"));
                u.setUsuario(rs.getString("u.usuario"));
                u.setDireccion(rs.getString("u.direccion"));
                u.setNumeroDocumento(rs.getString("u.numeroDocumento"));
                u.setTelefonos(rs.getString("u.telefono"));
                u.setFechaNacimiento(rs.getDate("u.fechaNacimiento"));
                u.setId(rs.getLong("u.id"));
                u.setTipoPersona(tp);
                u.setTipoUsuario(tu);
                u.setIdentificacion(ti);
                usuarios.add(u);
            }
            rs.close();
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuarios;
    }
}
