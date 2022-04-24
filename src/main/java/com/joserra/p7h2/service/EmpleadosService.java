package com.joserra.p7h2.service;

import com.joserra.p7h2.service.dto.EmpleadoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpleadosService {

    List<EmpleadoDTO> getEmpleados();

    List<EmpleadoDTO> getEmpleadosWithSociedad(Long idSociedad);

    List<EmpleadoDTO> getEmpleadosConSociedades();

    void addEmpleado(EmpleadoDTO empleado);

    void deleteEmpleado(String id);
    void updateEmpleado(EmpleadoDTO empleado);
}