package VO;

public class ProductoVO {

/*Todos los atributos*/
    int id_Producto;
    String nombre_prod;
    double precio;
    String marca;
    Object activo;

public ProductoVO(){}

/*Todos los codigos get*/
    public int getId_Producto(){
        return id_Producto;
    }
    public String getNombre_prod(){
        return nombre_prod;
    }
    public double getPrecio(){
        return precio;
    }
    public String getMarca(){
        return marca;
    }
    public Object getActivo(){
        return activo;
    }


/*Todos los codigos set*/
    public void setId_Producto(int id_Producto){
        this.id_Producto = id_Producto;
    }
    public void setNombre_prod(String nombre_prod){
        this.nombre_prod = nombre_prod;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public void setActivo(Object activo){
        this.activo = activo;
    }

}
