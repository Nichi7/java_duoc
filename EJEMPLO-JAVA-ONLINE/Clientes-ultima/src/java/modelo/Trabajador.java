/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author daniela
 */
public class Trabajador implements Serializable {

    private String run;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private double sueldoBase;
    //estos atributos se calculasn
    private double afp /*13%*/;
    private double salud /*7*/;
    private double sueldoLiquido;
    private int aguilnaldo;
    public final int BONO_PRODUCCION = 30000;

    public Trabajador(String run, String nombre, String apellidoPaterno, String apellidoMaterno, double sueldoBase) {
        this.run = run;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sueldoBase = sueldoBase;
        
        afp = sueldoBase * 0.13;
        salud = sueldoBase * 0.07;
        sueldoLiquido = (sueldoBase + BONO_PRODUCCION - afp - salud);
       
        if (sueldoBase <= 200000) {
            aguilnaldo = 80000; 
        } else if (sueldoBase > 200000 && sueldoBase <= 500000) {
            aguilnaldo = 40000;   
        } else {
            aguilnaldo = 5000;   
        }
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(int sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getAfp() {
         return (int)afp;
    }

    public void setAfp(double afp) {
        this.afp = afp;
    }

    public int getSalud() { 
        return (int)salud;
    }

    public void setSalud(double salud) {
        this.salud = salud;
    }

    public double getSueldoLiquido() {
        return sueldoLiquido;
    }

    public void setSueldoLiquido(int sueldoLiquido) {
        this.sueldoLiquido = sueldoLiquido;
    }

    public int getAguilnaldo() {
        return aguilnaldo;
       
    }

    public void setAguilnaldo(int aguilnaldo) {
        this.aguilnaldo = aguilnaldo;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "sueldoBase=" + sueldoBase + ", afp=" + afp + ", salud=" + salud + ", sueldoLiquido=" + sueldoLiquido + ", aguilnaldo=" + aguilnaldo + ", BONO_PRODUCCION=" + BONO_PRODUCCION + '}';
    }
    
//meotod para hacer prueba si funciona o no
    /*public static void main(String[] args) {
        Trabajador t1, t2;
        t1 = new Trabajador(null,null,null,null, 100000);
        t2 = new Trabajador(null,null,null,null, 600000);
        
        System.out.println("SL t1: "+t1.getSueldoLiquido());
        System.out.println("AG t1: "+t1.getAguilnaldo());
        System.out.println(t2);
    }*/
}
