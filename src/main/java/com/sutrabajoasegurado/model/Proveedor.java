package com.sutrabajoasegurado.model;

import java.util.Calendar;

public class Proveedor {

    private Long codigo;

    private String nombre;

    private Calendar fechaRegistro;

    private String telefono;

    private String direccion;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if(isPalindromo(nombre.toUpperCase())){
            throw new Exception("El nombre no puede ser palindrom");
        }
        this.nombre = nombre;
    }

    public Calendar getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Calendar fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) throws Exception {
        if(!direccionIsCorrect(direccion)){
            throw new Exception("La direccion no es correcta");
        }
        this.direccion = direccion;
    }

    private boolean isPalindromo(String nombre){

        boolean retorno = false;
        String nombreInverse= new StringBuilder(nombre).reverse().toString();

        if (nombre.equals(nombreInverse)){
            retorno = true;
        }
        return retorno;
    }

    private boolean direccionIsCorrect(String direccion){

        int c = 0;

        String vocales = "AEIOUaeiou";
        for (char e: direccion.toCharArray()){
            if(vocales.contains(Character.toString(e))){
                c += 1;
            }
        }

        boolean retorno = false;

        String CL = direccion.substring(0,2);
        if (c>=3 && CL.equals("CL")){
            retorno = true;
        }
        return retorno;
    }

}

