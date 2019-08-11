package com.sutrabajoasegurado.utilitarios;

import java.util.Calendar;

public abstract class validator {

    public static boolean isPalindromo(String nombre){

        boolean retorno = false;
        String nombreInverse= new StringBuilder(nombre).reverse().toString();

        if (nombre.equals(nombreInverse)){
            retorno = true;
        }
        return retorno;
    }

    public static boolean direccionIsCorrect(String direccion){

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

    public static boolean isSunday(){

        Calendar fechaActual = Calendar.getInstance();

        boolean retorno = false;

        if(Calendar.SUNDAY == fechaActual.get(Calendar.DAY_OF_WEEK)){
            retorno = true;
        }
        System.out.println(fechaActual.get(Calendar.DAY_OF_WEEK));
        return retorno;
    }

}
