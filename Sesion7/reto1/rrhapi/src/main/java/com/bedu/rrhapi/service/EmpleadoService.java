package com.bedu.rrhapi.service;

import com.bedu.rrhapi.model.Empleado;
import com.bedu.rrhapi.repositorio.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    public List<Empleado> buscarPorPuesto(String puesto) {
        return empleadoRepository.findByPuesto(puesto);
    }

    public boolean eliminarEmpleado(Long id) {
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
