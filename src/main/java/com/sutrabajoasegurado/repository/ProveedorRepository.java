package com.sutrabajoasegurado.repository;

import com.sutrabajoasegurado.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Serializable> {

}
