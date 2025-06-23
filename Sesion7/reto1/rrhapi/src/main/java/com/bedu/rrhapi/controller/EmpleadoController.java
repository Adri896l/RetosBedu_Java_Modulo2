package com.bedu.rrhapi.controller;

import com.bedu.rrhapi.model.Empleado;
import com.bedu.rrhapi.service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<Empleado> obtenerEmpleados() {
        return empleadoService.obtenerTodos();
    }

    @PostMapping
    public void agregarEmpleado(@RequestBody Empleado empleado) {
        empleadoService.agregarEmpleado(empleado);
    }

    @GetMapping("/puesto/{puesto}")
    public List<Empleado> buscarPorPuesto(@PathVariable String puesto) {
        return empleadoService.buscarPorPuesto(puesto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEmpleado(@PathVariable Long id) {
        boolean eliminado = empleadoService.eliminarEmpleado(id);
        if (eliminado) {
            return ResponseEntity.ok("Empleado con ID " + id + " eliminado correctamente.");
        } else {
            return ResponseEntity.status(404).body("Empleado con ID " + id + " no encontrado.");
        }
    }
}
