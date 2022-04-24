package com.joserra.p7h2.service.dto;
public record EmpleadoDTO(
        Long id,
        String nombre,
        String apellidos,
        Long idSociedad) {}