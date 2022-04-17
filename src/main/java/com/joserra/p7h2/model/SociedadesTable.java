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
@Table("SOCIEDADES")
public class SociedadesTable {
    private @Column("ID")
    @Id Long id;
    private @Column("NOMBRE") String nombre;
    private @Column("CIF") String cif;
}