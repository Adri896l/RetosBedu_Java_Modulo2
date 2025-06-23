package com.tienda.inventario.repositorio;

import com.tienda.inventario.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
