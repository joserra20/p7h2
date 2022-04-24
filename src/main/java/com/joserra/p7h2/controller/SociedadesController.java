package com.joserra.p7h2.controller;

import com.joserra.p7h2.service.EmpleadosService;
import com.joserra.p7h2.service.SociedadesService;
import com.joserra.p7h2.service.dto.EmpleadoDTO;
import com.joserra.p7h2.service.dto.SociedadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SociedadesController {
    @Autowired
    private SociedadesService sociedadesService;

    @GetMapping("/sociedades")
    public ResponseEntity<List<SociedadDTO>> getSociedades(){

        var sociedades = sociedadesService.getSociedades();

        return ResponseEntity.ok().body(sociedades);
    }
}
