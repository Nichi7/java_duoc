package DAO;

import Conexion.Conectar;
import VO.ProductoVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProductoDAO{

/*Metodo listar*/
    public ArrayList<ProductoVO> Listar_ProductoVO(){
        ArrayList<ProductoVO> list = new ArrayList<ProductoVO>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM producto;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ProductoVO vo = new ProductoVO();
                vo.setId_Producto(rs.getInt(1));
                vo.setNombre_prod(rs.getString(2));
                vo.setPrecio(rs.getDouble(3));
                vo.setMarca(rs.getString(4));
                vo.setActivo(rs.getObject(5));
                list.add(vo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }

}
