package com.example.proyecto.ladrilleria.app.spring.ladrilleria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.proyecto.ladrilleria.app.spring.ladrilleria.entities.Ventas;

import java.util.List;

@Repository
public interface VentasRepository extends JpaRepository<Ventas,Long>{

    //Consulta para ventas totales por un año
    @Query("SELECT v FROM Ventas v WHERE YEAR(v.fecha) = ?1")
    List<Ventas> findByFechaYear(int year);

    //Consulta para ventas totales por mes
    @Query("SELECT v FROM Ventas v WHERE MONTH(v.fecha) = ?1")
    List<Ventas> findByFechaMonth(int month);

}
