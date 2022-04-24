package com.joserra.p7h2.controller;

import com.joserra.p7h2.repository.EmpleadosRepository;
import com.joserra.p7h2.service.EmpleadosService;
import com.joserra.p7h2.service.dto.EmpleadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpleadosController {
    @Autowired
    private EmpleadosService empleadosService;

    @GetMapping("/empleados")
    public ResponseEntity<List<EmpleadoDTO>> getEmpleados(){

        var empleados = empleadosService.getEmpleados();

        return ResponseEntity.ok().body(empleados);
    }

    @GetMapping("/empleados/sociedad={id}")
    public ResponseEntity<List<EmpleadoDTO>> getEmpleadosWithSociedad(@PathVariable("id") Long id){

        var empleados = empleadosService.getEmpleadosWithSociedad(id);

        return ResponseEntity.ok().body(empleados);
    }

    @GetMapping("/empleados/vistaSociedades")
    public ResponseEntity<List<EmpleadoDTO>> getEmpleadosConSociedades(){

        var empleados = empleadosService.getEmpleadosConSociedades();

        return ResponseEntity.ok().body(empleados);
    }

    @PostMapping("/empleados")
    public @ResponseBody ResponseEntity<String> addEmpleado(@RequestBody EmpleadoDTO empleado){
        empleadosService.addEmpleado(empleado);

        return ResponseEntity.ok().body("Empleado incluido");

    }

    @DeleteMapping("/empleados")
    public @ResponseBody ResponseEntity<String> deleteEmpleado(@RequestBody String id){
        empleadosService.deleteEmpleado(id);

        return ResponseEntity.ok().body("Empleado eliminado correctamente");

    }

    @PutMapping("/empleados")
    public @ResponseBody ResponseEntity<String> updateEmpleado(@RequestBody EmpleadoDTO empleado){
        empleadosService.updateEmpleado(empleado);

        return ResponseEntity.ok().body("Empleado actualizado");

    }

}
