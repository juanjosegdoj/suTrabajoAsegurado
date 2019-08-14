package com.sutrabajoasegurado.service.impl;

import com.sutrabajoasegurado.converter.ProveedorConverter;
import com.sutrabajoasegurado.entity.ProveedorEntity;
import com.sutrabajoasegurado.model.Proveedor;
import com.sutrabajoasegurado.repository.ProveedorRepository;
import com.sutrabajoasegurado.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static com.sutrabajoasegurado.utilitarios.validator.*;


@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorConverter proveedorConverter;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> listAll() {
        return proveedorConverter.entityToModel(proveedorRepository.findAll());
    }

    @Override
    public void save(Proveedor proveedor) throws Exception {

        proveedor.setFechaRegistro(Calendar.getInstance());
        if(isSunday()){
            throw new Exception("Los domingos no se realiza transacciones");
        }

        proveedorRepository.save(proveedorConverter.modelToEntity(proveedor));

    }

    @Override
    public void update(Proveedor proveedor) throws Exception {

        if(isSunday()){
            throw new Exception("Los domingos no se realiza transacciones");
        }

        // Validar que exista el proveedor a actualizar
        Optional<ProveedorEntity> proveedorEntity = proveedorRepository.findById(proveedor.getCodigo());

        if(proveedorEntity.isPresent()){
            proveedorRepository.save(proveedorConverter.modelToEntity(proveedor));
        }else {
            throw new Exception("No se puede actualizar un recurso que no existe.");
        }
    }

    @Override
    public Proveedor findById(Long id) throws Exception {
        return proveedorConverter.entityToModel(proveedorRepository.findById(id).orElse(null));
    }


}

