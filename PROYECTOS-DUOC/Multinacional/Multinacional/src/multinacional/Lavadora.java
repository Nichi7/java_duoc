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
public class Lavadora extends Electrodomestico {

    private String carga;

    public String getCarga() {
        return carga;
    }

    public Lavadora(String carga, String marca, int codigo, int preciobase, int stock) {
        super(marca, codigo, preciobase, stock);
        this.carga = carga;
    }

    public void setCarga(String carga) {
        this.carga = carga; 
    }
    
    @Override
    public double calcularDescuento(String horario) {
        if(horario.equals("Nocturno") && super.getMarca().equals("Zoni") && this.carga.equals("Por Arriba"))
            return 0.11*super.getPreciobase();
        return super.getPreciobase();
    }
    
    @Override
    public String toString(){
        String cadena="";
        cadena+="Carga: "+this.getCarga()+"\t";
        return "Lavadora: "+super.toString()+cadena;    
    }
}
