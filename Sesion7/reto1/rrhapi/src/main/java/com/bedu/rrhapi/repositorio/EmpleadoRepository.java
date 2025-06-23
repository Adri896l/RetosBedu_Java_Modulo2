package com.bedu.rrhapi.repositorio;

import com.bedu.rrhapi.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByPuesto(String puesto);
}
