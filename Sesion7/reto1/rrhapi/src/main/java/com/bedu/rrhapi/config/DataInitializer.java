package com.bedu.rrhapi.config;

import com.bedu.rrhapi.model.Empleado;
import com.bedu.rrhapi.repositorio.EmpleadoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(EmpleadoRepository repository) {
        return args -> {
            repository.save(new Empleado(null, "Ana Gómez", "Gerente de Marketing", 55000));
            repository.save(new Empleado(null, "Carlos Pérez", "Desarrollador Backend", 45000));
            repository.save(new Empleado(null, "Laura Torres", "Diseñadora UX", 42000));
            System.out.println("Datos de empleados iniciales insertados");
        };
    }
}
