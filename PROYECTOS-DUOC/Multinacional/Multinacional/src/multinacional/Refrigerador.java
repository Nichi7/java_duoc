/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multinacional;

/**
 *
 * @author Xberto
 */
public class Refrigerador extends Electrodomestico{
    private int cantidadPies;

    public Refrigerador(int cantidadPies, String marca, int codigo, int preciobase, int stock) {
        super(marca, codigo, preciobase, stock);
        this.cantidadPies = cantidadPies;
    }
   
    public int getCantidadPies() {
        return cantidadPies;
    }

    public void setCantidadPies(int cantidadPies) {
        this.cantidadPies = cantidadPies;
    }

    @Override
    public double calcularDescuento(String horario) {
        if(horario.equals("Nocturno") && super.getMarca().equals("Acme") && this.cantidadPies==15)
            return porcentajeDescuento*super.getPreciobase();
        return super.getPreciobase();
    }
    
    @Override
    public String toString(){
        String cadena="Pies: "+this.cantidadPies+"\t";
        return "Refrigerador: "+super.toString()+cadena;
    }
    
}
