package com.sutrabajoasegurado.restcontroller;

import com.sutrabajoasegurado.entity.ProveedorEntity;
import com.sutrabajoasegurado.model.Proveedor;
import com.sutrabajoasegurado.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.BindException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorRestController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("")
    public List<Proveedor> listAll (){
        return proveedorService.listAll();
    }

    @GetMapping("/{codigo}")
    public Proveedor findById(@PathVariable Long codigo) throws Exception {
        return proveedorService.findById(codigo);
    }

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> insert(@RequestBody Proveedor proveedor) {

        Map<String, Object> response = new HashMap<>();
        HttpStatus status;
        try {
            proveedorService.save(proveedor);
            response.put("Mensaje","El proveedor "+proveedor.getNombre()+
                    " ha sido registrado exitosamente.");

            status = HttpStatus.CREATED;

        }catch (BindException excepcion){
            response.put("Mensaje", excepcion.getMessage());
            status = HttpStatus.CONFLICT;
        }
        catch (Exception excepcion){
            response.put("Mensaje", excepcion.getMessage());
            status = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<>(response, status);
    }


    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Proveedor proveedor) {

        Map<String, Object> response = new HashMap<>();
        HttpStatus status;
        try {
            proveedorService.update(proveedor);
            response.put("Mensaje","El proveedor "+proveedor.getNombre()+
                    " ha sido registrado exitosamente.");

            status = HttpStatus.CREATED;

        }catch (BindException excepcion){
            response.put("Mensaje", excepcion.getMessage());
            status = HttpStatus.CONFLICT;
        }
        catch (Exception excepcion){
            response.put("Mensaje", excepcion.getMessage());
            status = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<>(response, status);
    }
}
