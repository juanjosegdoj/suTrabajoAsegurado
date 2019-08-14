package com.sutrabajoasegurado.entity;

import com.sutrabajoasegurado.model.Proveedor;
import org.junit.Test;

import java.net.BindException;
import java.time.DateTimeException;
import java.util.Date;

import static org.junit.Assert.*;


class ProveedorEntityTest {


    @Test(expected = Exception.class)
    public void direccionEsValida(){

        Proveedor proveedor1 = new Proveedor();

        proveedor1.setDireccion("CL 23aaa");
    }

}