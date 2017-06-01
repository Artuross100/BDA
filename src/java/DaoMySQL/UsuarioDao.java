package DaoMySQL;

import Entidades.TipoIdentificacion;
import Entidades.TipoPersona;
import Entidades.TipoUsuario;
import Entidades.Usuario;
import Util.Conexion;
import Util.Encriptador;
import java.io.Serializable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDao implements Serializable {

    private Conexion conexion;

    public UsuarioDao() throws SQLException {
        this.conexion = new Conexion();
    }

    public boolean validarUsuario(String usuario) {
        String consulta = "SELECT count(*) "
                + "FROM Usuario "
                + "WHERE usuario = ?";
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean insertarUsuario(Usuario usuario) {
        boolean b = false;
        String consulta = "INSERT INTO Usuario (tipoIdentificacion, tipoPersona, tipoUsuario,"
                + " usuario, contrasena, nombres, "
                + "apellidos, direccion, telefono, "
                + "fechaNacimiento, numeroDocumento) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareCall(consulta);
            pst.setLong(1, usuario.getIdentificacion().getId());
            pst.setLong(2, usuario.getTipoPersona().getId());
            pst.setLong(3, usuario.getTipoUsuario().getId());
            pst.setString(4, usuario.getUsuario());
            pst.setString(5, Encriptador.encriptar(usuario.getContra()));
            pst.setString(6, usuario.getNombres());
            pst.setString(7, usuario.getApellidos());
            pst.setString(8, usuario.getDireccion());
            pst.setString(9, usuario.getTelefonos());
            pst.setDate(10, new Date(usuario.getFechaNacimiento().getTime()));
            pst.setString(11, usuario.getNumeroDocumento());
            b = pst.execute();
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return b;
    }

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        String consulta = "SELECT * "
                + "FROM Usuario u, TipoUsuario t, TipoIdentificacion i, TipoPersona p "
                + "WHERE u.tipoIdentificacion=i.id AND u.tipoPersona=p.id AND "
                + "u.tipoUsuario=t.id";
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = pst.executeQuery();
            TipoUsuario tu;
            TipoPersona tp;
            TipoIdentificacion ti;
            Usuario u;
            while (rs.next()) {
                u = new Usuario();
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

    public Usuario validarSesion(String usuario, String contra) {
        String consulta = "SELECT * "
                + "FROM Usuario u, TipoUsuario t, TipoIdentificacion i, TipoPersona p "
                + "WHERE u.tipoIdentificacion=i.id AND u.tipoPersona=p.id AND "
                + "u.tipoUsuario=t.id AND u.usuario=? AND u.contrasena=?";
        Usuario u = null;
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = pst.executeQuery();
            pst.setString(1, usuario);
            pst.setString(2, Encriptador.encriptar(contra));
            TipoUsuario tu;
            TipoPersona tp;
            TipoIdentificacion ti;
            while (rs.next()) {
                u = new Usuario();
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
            }
            rs.close();
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return u;
    }

}
