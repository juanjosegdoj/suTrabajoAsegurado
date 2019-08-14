package com.sutrabajoasegurado.service;

import com.sutrabajoasegurado.entity.ProveedorEntity;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ProveedorService {

    List<ProveedorEntity> listAll();

    void save(ProveedorEntity proveedorEntity);

    ProveedorEntity findById(Long id);

    void update(ProveedorEntity proveedorEntity) throws Exception;
}
