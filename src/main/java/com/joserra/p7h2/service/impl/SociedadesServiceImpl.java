package com.joserra.p7h2.service.impl;

import com.joserra.p7h2.repository.SociedadesRepository;
import com.joserra.p7h2.service.SociedadesService;
import com.joserra.p7h2.service.dto.EmpleadoDTO;
import com.joserra.p7h2.service.dto.SociedadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class SociedadesServiceImpl implements SociedadesService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SociedadesRepository sociedadesRepository;
    @Override
    public List<SociedadDTO> getSociedades() {
        return StreamSupport.stream(sociedadesRepository.findAll().spliterator(), false)
                .map(obj -> new SociedadDTO(
                        obj.getId(),
                        obj.getNombre(),
                        obj.getCif()))
                .toList();
    }
}