/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Producto;
import servicio.Conexion;
import servicio.FactoriaServicios;

/**
 *
 * @author Jazna
 */
public class ProductoDAO {
//se declara un atributo de tipo producto llamado p

    private Producto p;
//se crea contructor vacio pero sino se creara el sistema lo crea por default

    public ProductoDAO() {
    }

    public ProductoDAO(Producto p) {
        this.p = p;
    }

    //Permite insertar y/o actualizar un registro en la tabla
    public void grabar() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Conexion cdb = FactoriaServicios.getInstancia().getConexionDb();//conecta base de datos
        System.out.println("conectado");
        cdb.un_sql = "SELECT pr_id FROM producto WHERE pr_id = " + p.getId() + "";
        cdb.resultado = cdb.un_st.executeQuery(cdb.un_sql);
        System.out.println("" + p.getId());
        if (cdb.resultado != null) {
            if (cdb.resultado.next()) {
                cdb.un_sql = "UPDATE producto SET pr_nombre ='"
                        + p.getNombre() + "' WHERE pr_id ="
                        + p.getId() + ";";
                cdb.un_st.executeUpdate(cdb.un_sql);
            } else {
                cdb.un_sql = "INSERT INTO producto(pr_id, pr_nombre, pr_moneda, pr_valormoneda) VALUES ("
                        + p.getId() + ",'" + p.getNombre() + ",'" + p.getMoneda() + ",'" + p.getValorMoneda() + "')";
                cdb.un_st.executeUpdate(cdb.un_sql);
                System.out.println("" + p.getId() + "," + p.getNombre() + "," + p.getMoneda() + "," + p.getValorMoneda());
            }
        } else {
            cdb.un_sql = "INSERT INTO producto(pr_id, pr_nombre, pr_moneda, pr_valormoneda) VALUES ("
                    + p.getId() + ",'" + p.getNombre() + ",'" + p.getMoneda() + ",'" + p.getValorMoneda() + "')";
            cdb.un_st.executeUpdate(cdb.un_sql);
            System.out.println("" + p.getId() + "," + p.getNombre() + "," + p.getMoneda() + "," + p.getValorMoneda());
        }
    }
}
