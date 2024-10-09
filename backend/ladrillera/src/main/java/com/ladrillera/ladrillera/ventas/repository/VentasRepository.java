package com.ladrillera.ladrillera.ventas.repository;

import com.ladrillera.ladrillera.ventas.entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Long> {

    // Método para buscar ventas por clienteId
    List<Ventas> findByClienteId(Integer clienteId);

    // Contar ventas por cliente en un día
    @Query("SELECT COUNT(v) FROM Ventas v WHERE v.clienteId = :clienteId AND v.fecha = :fecha")
    long countByClienteIdAndFecha(@Param("clienteId") Integer clienteId, @Param("fecha") LocalDate fecha);

    // Contar ventas por cliente entre un rango de fechas (mes)
    @Query("SELECT COUNT(v) FROM Ventas v WHERE v.clienteId = :clienteId AND v.fecha BETWEEN :startDate AND :endDate")
    long countByClienteIdAndFechaBetween(@Param("clienteId") Integer clienteId, @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

    // Contar ventas por cliente en un rango de fechas (año)
    @Query("SELECT COUNT(v) FROM Ventas v WHERE v.clienteId = :clienteId AND v.fecha BETWEEN :startDate AND :endDate")
    long countByClienteIdAndFechaAnual(@Param("clienteId") Integer clienteId, @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

}
