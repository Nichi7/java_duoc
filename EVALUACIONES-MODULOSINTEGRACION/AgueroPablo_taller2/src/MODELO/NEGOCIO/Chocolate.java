/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO.NEGOCIO;

/**
 *
 * @author lhernandez
 */
public class Chocolate {
    private int codigo;
    private String nombre;
    private String descripcion;
    private int precioventa;
    private int cantidad;
    private String tipocolor;
    private String tiposabor;
    private String marca;
    private boolean azucar;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(int precioventa) {
        this.precioventa = precioventa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipocolor() {
        return tipocolor;
    }

    public void setTipocolor(String tipocolor) {
        this.tipocolor = tipocolor;
    }

    public String getTiposabor() {
        return tiposabor;
    }

    public void setTiposabor(String tiposabor) {
        this.tiposabor = tiposabor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isAzucar() {
        return azucar;
    }

    public void setAzucar(boolean azucar) {
        this.azucar = azucar;
    }

    @Override
    public String toString() {
        return "CODIGO=" + codigo + ", NOMBRE=" + nombre + ", DESCRIPCION=" + descripcion + ", PRECIOVENTA=" + precioventa + ", CANTIDAD=" + cantidad + ", TIPOCOLOR=" + tipocolor + ", TIPOSABOR=" + tiposabor + ", MARCA=" + marca + ", AZUCAR=" + azucar ;
    }


    

    
}
