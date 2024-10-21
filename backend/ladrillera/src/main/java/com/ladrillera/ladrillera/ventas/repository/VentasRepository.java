package com.ladrillera.ladrillera.ventas.repository;

import com.ladrillera.ladrillera.ventas.entity.Ventas;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.math.BigDecimal;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Long> {

        // Método para buscar ventas por clienteId
        List<Ventas> findByClienteId(Long clienteId);

        // Contar ventas por cliente en un día
        @Query("SELECT COUNT(v) FROM Ventas v WHERE v.clienteId = :clienteId AND v.fecha = :fecha")
        long countByClienteIdAndFecha(@Param("clienteId") Long clienteId, @Param("fecha") LocalDate fecha);

        // Contar ventas por cliente entre un rango de fechas (mes)
        @Query("SELECT COUNT(v) FROM Ventas v WHERE v.clienteId = :clienteId AND v.fecha BETWEEN :startDate AND :endDate")
        long countByClienteIdAndFechaBetween(@Param("clienteId") Long clienteId,
                        @Param("startDate") LocalDate startDate,
                        @Param("endDate") LocalDate endDate);

        // Contar ventas por cliente en un rango de fechas (año)
        @Query("SELECT COUNT(v) FROM Ventas v WHERE v.clienteId = :clienteId AND v.fecha BETWEEN :startDate AND :endDate")
        long countByClienteIdAndFechaAnual(@Param("clienteId") Long clienteId,
                        @Param("startDate") LocalDate startDate,
                        @Param("endDate") LocalDate endDate);

        // Método para contar ventas por sucursal anualmente
        @Query("SELECT COUNT(v) FROM Ventas v WHERE v.sede = :sede AND v.fecha BETWEEN :startDate AND :endDate")
        long countBySedeAndFechaBetween(@Param("sede") String sede, @Param("startDate") LocalDate startDate,
                        @Param("endDate") LocalDate endDate);

        // Metodo para contar las ventas por sucursal, mes y anio
        @Query("SELECT v FROM Ventas v WHERE MONTH(v.fecha) = ?1 AND YEAR(v.fecha) = ?2 AND v.sede = ?3")
        List<Ventas> obtenerVentasPorSucursalYMes(int mes, int anio, String sucursal);

        // Método para contar ventas por sucursal y por mes
        @Query("SELECT COUNT(v) FROM Ventas v WHERE v.sede = :sede AND v.fecha BETWEEN :startDate AND :endDate")
        long countBySedeAndMes(@Param("sede") String sede, @Param("startDate") LocalDate startDate,
                        @Param("endDate") LocalDate endDate);

        // Metodo para agrupar las ventas de los clientes filtrado por sucursal, mes y
        // anio
        @Query("SELECT v.clienteId FROM Ventas v " +
                        "WHERE v.sede = :sede AND MONTH(v.fecha) = :mes AND YEAR(v.fecha) = :anio " +
                        "GROUP BY v.clienteId " +
                        "ORDER BY COUNT(v) DESC")
        List<Long> findTopClientesIdsPorVentas(
                        @Param("sede") String sede,
                        @Param("mes") int mes,
                        @Param("anio") int anio,
                        Pageable pageable);

        @Query("SELECT v.clienteId FROM Ventas v " +
                        "WHERE v.sede = :sede AND YEAR(v.fecha) = :anio " +
                        "GROUP BY v.clienteId " +
                        "ORDER BY COUNT(v) DESC")
        List<Long> findTopClientesIdsPorVentasTodosMeses(
                        @Param("sede") String sede,
                        @Param("anio") int anio,
                        Pageable pageable);

        // Metodos para agrupar los productos mas vendidos filtrado
        @Query("SELECT v.productoId FROM Ventas v " +
                        "WHERE v.sede = :sede AND MONTH(v.fecha) = :mes AND YEAR(v.fecha) = :anio " +
                        "GROUP BY v.productoId " +
                        "ORDER BY SUM(v.cantidad) DESC")
        List<Long> findTopProductosIdsPorVentas(
                        @Param("sede") String sede,
                        @Param("mes") int mes,
                        @Param("anio") int anio,
                        Pageable pageable);

        @Query("SELECT v.productoId FROM Ventas v " +
                        "WHERE v.sede = :sede AND YEAR(v.fecha) = :anio " +
                        "GROUP BY v.productoId " +
                        "ORDER BY SUM(v.cantidad) DESC")
        List<Long> findTopProductosIdsPorVentasTodosMeses(
                        @Param("sede") String sede,
                        @Param("anio") int anio,
                        Pageable pageable);

        // Metodo para arrojar los años que hubo venta
        @Query("SELECT DISTINCT YEAR(v.fecha) FROM Ventas v ORDER BY YEAR(v.fecha) DESC")
        List<Integer> findDistinctYears();

        @Query("SELECT SUM(v.totalVenta) FROM Ventas v WHERE v.sede = :sede AND v.fecha BETWEEN :startDate AND :endDate")
        BigDecimal sumTotalVentaBySedeAndFechaBetween(@Param("sede") String sede,
                        @Param("startDate") LocalDate startDate,
                        @Param("endDate") LocalDate endDate);

}
