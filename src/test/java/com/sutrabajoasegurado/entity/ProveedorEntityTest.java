package com.sutrabajoasegurado.entity;

import org.junit.Test;

import java.net.BindException;
import java.time.DateTimeException;
import java.util.Date;

import static org.junit.Assert.*;


class ProveedorEntityTest {

    @Test
    public void caracteresMenosDe3NoPermitidosEnElNombre(){

        ProveedorEntity proveedor = new ProveedorEntity('AUL',1234566,'CLSasd');
        proveedor.setNombre("Au");
    }

}