package com.sutrabajoasegurado.utilitarios;

import java.util.Calendar;

public abstract class validator {

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
