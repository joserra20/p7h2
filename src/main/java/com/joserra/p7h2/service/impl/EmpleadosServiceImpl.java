package com.joserra.p7h2.service.impl;

import com.joserra.p7h2.repository.EmpleadosRepository;
import com.joserra.p7h2.service.EmpleadosService;
import com.joserra.p7h2.service.dto.EmpleadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;
@Service
public class EmpleadosServiceImpl implements EmpleadosService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EmpleadosRepository empleadosRepository;
    @Override
    public List<EmpleadoDTO> getEmpleados() {
        return StreamSupport.stream(empleadosRepository.findAll().spliterator(), false)
                .map(obj -> new EmpleadoDTO(
                        obj.getId(),
                        obj.getNombre(),
                        obj.getApellidos(),
                        obj.getIdSociedad()))
                .toList();
    }

    @Override
    public List<EmpleadoDTO> getEmpleadosWithSociedad(Long idSociedad) {
        return empleadosRepository.getEmpleadosWithSociedad(idSociedad);
    }

    @Override
    public List<EmpleadoDTO> getEmpleadosConSociedades() {
        return empleadosRepository.getEmpleadosConSociedades();
    }

    @Override
    public void addEmpleado(EmpleadoDTO empleado) {
        String nombre = empleado.nombre();
        String apellidos = empleado.apellidos();
        String idSociedad = String.valueOf(empleado.idSociedad());
        jdbcTemplate.execute("INSERT INTO EMPLEADOS (NOMBRE,APELLIDOS,SOCIEDAD) VALUES ('"+nombre+"','"+apellidos+"',"+idSociedad+");");
    }

    @Override
    public void deleteEmpleado(String id) {
        jdbcTemplate.execute("DELETE FROM EMPLEADOS WHERE ID='"+id+"'");
    }

    @Override
    public void updateEmpleado(EmpleadoDTO empleado) {
        Long id = empleado.id();
        String nombre = empleado.nombre();
        String apellidos = empleado.apellidos();
        Long idSociedad = empleado.idSociedad();
        jdbcTemplate.execute("UPDATE EMPLEADOS SET NOMBRE ='"+nombre+"',APELLIDOS='"+apellidos+"',SOCIEDAD="+idSociedad+" WHERE ID="+id);

    }


}
