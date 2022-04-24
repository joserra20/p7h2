package com.joserra.p7h2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("EMPLEADOS")
public class EmpleadosTable {
    private @Column("ID") @Id Long id;

    private @Column("NOMBRE") String nombre;

    private @Column("APELLIDOS") String apellidos;

    private @Column("SOCIEDAD") Long idSociedad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Long getIdSociedad() {
        return idSociedad;
    }

    public void setIdSociedad(Long idSociedad) {
        this.idSociedad = idSociedad;
    }
}