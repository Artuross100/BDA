package DaoMySQL;

import Entidades.Donacion;
import Entidades.Producto;
import Entidades.ProductoDonacion;
import Entidades.UnidadMedida;
import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDonacionDao implements Serializable {

    private Conexion conexion;

    public ProductoDonacionDao() throws SQLException {
        this.conexion = new Conexion();
    }

    public boolean insertarProductosDonacion(String con) {
        String consulta = "INSERT INTO ProductoDonacion (donacion, producto, cantidadProducto, conforme) VALUES " + con;
        boolean b = false;
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(consulta);
            b = pst.execute();
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return b;
    }

    public ArrayList<ProductoDonacion> listarProductoDonadosSinAlmacenar() {
        String consulta = "SELECT p.nombre, p.medida, u.descripcion, "
                + "d.cantidadProducto, d.conforme, p.codigo, "
                + "d.donacion "
                + "FROM Producto p, ProductoDonacion d, UnidadMedida u, Donacion do, Donante dn "
                + "WHERE p.codigo=d.producto AND u.id=p.unidadMedida AND do.id=d.donacion AND "
                + "dn.idUsuario=do.donante AND d.producto "
                + "NOT IN (SELECT a.productoDonacion "
                + "FROM Almacenamiento a where a.codDonacion=d.donacion "
                + "AND d.producto=a.productoDonacion AND d.conforme=a.cantidadAlmacenada)";
        ArrayList<ProductoDonacion> productos = new ArrayList<ProductoDonacion>();
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = pst.executeQuery();
            ProductoDonacion pd = null;
            Producto p = null;
            UnidadMedida u = null;
            while(rs.next()){
                p = new Producto();
                pd = new ProductoDonacion();
                u = new UnidadMedida();
                pd.setDonacion(rs.getLong(7));
                p.setCodigo(rs.getString(6));
                p.setNombre(rs.getString(1));
                u.setDescripcion(rs.getString(3));
                p.setMedida(rs.getLong(2));
                pd.setCantidad(rs.getLong(4));
                pd.setConforme(rs.getLong(5));
                p.setUnidad(u);
                pd.setProducto(p);
                productos.add(pd);
            }
            rs.close();
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productos;
    }
    
    public List<ProductoDonacion> listarProductosDonacionPorDivision(long idDivision){
        
        List<ProductoDonacion> listadoProductos;
        String consulta;
        PreparedStatement state;
        ResultSet rs;
        ProductoDonacion productoDonacion;
        Producto producto;
        
        try{
            consulta = "SELECT p.*, pd.donacion, pd.cantidadProducto, pd.conforme FROM ProductoDonacion pd LEFT JOIN producto p"
                    + " ON p.codigo = pd.producto LEFT JOIN almacenamiento a"
                    + " ON a.productoDonacion = pd.donacion WHERE a.division = ?";
            state = this.conexion.getConexion().prepareStatement(consulta);
            state.setLong(1, idDivision);
            
            rs = state.executeQuery();
            
            listadoProductos = new ArrayList<>(0);
            
            while(rs.next()){
                producto = new Producto( rs.getString("codigo"), new UnidadMedidaDao().buscarUnidadPorId(rs.getLong("unidadMedida")), 
                        rs.getString("nombre"), rs.getFloat("peso"), rs.getFloat("medida"), rs.getFloat("precio"), 
                        new GrupoAlimentosDao().buscarGrupoAlimentosPorId(rs.getLong("grupo")));
                productoDonacion = new ProductoDonacion(producto, rs.getLong("cantidad"), rs.getLong("conforme"));
                listadoProductos.add(productoDonacion);
            }
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        
        return listadoProductos;
    }
}
