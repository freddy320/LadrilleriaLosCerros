package com.ladrillera.ladrillera.productos.repository;

import com.ladrillera.ladrillera.productos.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {
}
