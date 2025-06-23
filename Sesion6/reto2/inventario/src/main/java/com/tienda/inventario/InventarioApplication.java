package com.tienda.inventario;

import com.tienda.inventario.model.Marca;
import com.tienda.inventario.model.Producto;
import com.tienda.inventario.repositorio.MarcaRepository;
import com.tienda.inventario.repositorio.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

	@Bean
    public CommandLineRunner demo(MarcaRepository marcaRepo, ProductoRepository productoRepo) {
        return args -> {
            Marca apple = new Marca("Apple");
            Marca samsung = new Marca("Samsung");

            marcaRepo.save(apple);
            marcaRepo.save(samsung);

            productoRepo.save(new Producto("iPhone 15", "Smartphone de Apple", 23000.0, apple));
            productoRepo.save(new Producto("iPad Pro", "Tablet profesional de Apple", 27000.0, apple));
            productoRepo.save(new Producto("Galaxy S23", "Smartphone de Samsung", 21000.0, samsung));
            productoRepo.save(new Producto("Smart TV", "Televisión Samsung 4K", 15000.0, samsung));

            System.out.println("Productos por marca:");
            marcaRepo.findAll().forEach(marca -> {
                System.out.println(marca.getNombre() + ":");
                productoRepo.findAll().stream()
                        .filter(p -> p.getMarca().getId().equals(marca.getId()))
                        .forEach(p -> System.out.println("   - " + p.getNombre()));
            });
        };
    }

}
