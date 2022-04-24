package com.joserra.p7h2.repository;

import com.joserra.p7h2.model.EmpleadosTable;
import com.joserra.p7h2.service.dto.EmpleadoDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmpleadosRepository extends CrudRepository<EmpleadosTable,Long> {
    //INNER-JOIN
    @Query("SELECT * FROM EMPLEADOS INNER JOIN SOCIEDADES ON EMPLEADOS.SOCIEDAD=SOCIEDADES.ID")
    List<EmpleadoDTO> getEmpleadosConSociedades();

    @Query("SELECT * FROM EMPLEADOS WHERE SOCIEDAD = ?1")
    List<EmpleadoDTO> getEmpleadosWithSociedad(Long id);
}