package com.sutrabajoasegurado.service.impl;

import com.sutrabajoasegurado.entity.ProveedorEntity;
import com.sutrabajoasegurado.repository.ProveedorRepository;
import com.sutrabajoasegurado.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<ProveedorEntity> listAll() {
        return proveedorRepository.findAll();
    }

    @Override
    public void save(ProveedorEntity proveedorEntity) {
        proveedorRepository.save(proveedorEntity);
    }

    @Override
    public void update(ProveedorEntity proveedorEntity) throws Exception {

        // Validar que exista el proveedor a actualizar
        Optional<ProveedorEntity> proveedor = proveedorRepository.findById(proveedorEntity.getCodigo());

        if(proveedor.isPresent()){
            proveedorRepository.save(proveedorEntity);
        }else {
            throw new Exception("No se puede actualizar un recurso que no existe.");
        }
    }

    @Override
    public ProveedorEntity findById(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }
}
