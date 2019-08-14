package com.sutrabajoasegurado.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Entity
@Table(name = "proveedores")
public class ProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long codigo;

    @Column(name = "nombre", nullable = false, length = 60)
    @Size(min = 5, max = 60, message = "El nombre debe tener entre 5 y 60 caracteres")
    @NotEmpty(message = "El nombre es requerido")
    private String nombre;

    @Column(name = "fecha_registro", nullable = false, length = 200)
    @NotNull(message = "La fecha de registro es requerida")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-CO", timezone = "America/Bogota")
    public Calendar fechaRegistro;

    @Column(name = "telefono", nullable = false, length = 7)
    @NotNull(message = "El teléfono es requerido")
    @Size(min = 7, max = 7, message = "El telefono debe tener exactamente 7 caracterés")
    @Pattern(regexp="[1234567890]*")
    public String telefono;

    @Column(name = "direccion", nullable = false, length = 14)
    @NotEmpty(message = "la dirección es requerida")
    //@Pattern(regexp="[CL]")
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

    public void setNombre(String nombre) {
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

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

