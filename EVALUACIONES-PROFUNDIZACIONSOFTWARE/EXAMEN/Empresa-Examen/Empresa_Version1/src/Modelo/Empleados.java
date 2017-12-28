/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author daniela
 */
public class Empleados {
    private int codigo;
    private String rut;
    private String nombre;
    private String apellido;
    private int celular;
    private String email;
    private int sueldo;
    private String estado;
    private String depto;
    
    //crear constructor con argumentos

    public int getCodigo() {
        return codigo;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public int getSueldo() {
        return sueldo;
    }

    public String getEstado() {
        return estado;
    }

    public String getDepto() {
        return depto;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }  
}
