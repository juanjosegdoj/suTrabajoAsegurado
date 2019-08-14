package com.sutrabajoasegurado.service;

import com.sutrabajoasegurado.entity.ProveedorEntity;
import com.sutrabajoasegurado.model.Proveedor;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ProveedorService {

    List<Proveedor> listAll();

    void save(Proveedor proveedor) throws Exception;

    Proveedor findById(Long id) throws Exception;

    void update(Proveedor proveedor) throws Exception;
}
