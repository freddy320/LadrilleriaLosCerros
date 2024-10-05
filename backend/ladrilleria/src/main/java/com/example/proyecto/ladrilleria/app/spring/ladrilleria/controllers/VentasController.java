package com.example.proyecto.ladrilleria.app.spring.ladrilleria.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto.ladrilleria.app.spring.ladrilleria.entities.Ventas;
import com.example.proyecto.ladrilleria.app.spring.ladrilleria.services.VentasService;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    // Endpoint para obtener ventas por año
    @GetMapping("/ventas/{year}")
    public List<Ventas> obtenerVentasPorAño(@PathVariable int year) {
        return ventasService.obtenerVentasAño(year);
    }

    // Endpoint para obtener ventas por mes
    @GetMapping("/mes/{month}")
    public List<Ventas> obtenerVentasPorMes(@PathVariable int month) {
        return ventasService.obtenerVentasMes(month);
    }

    // Endpoint para obtener el promedio de ventas
   @GetMapping("/promedio/sede/{sede}")
    public ResponseEntity<BigDecimal> obtenerPromedioVentasSede(@PathVariable String sede) {
    BigDecimal promedio = ventasService.obtenerPromedioVentasSede(sede);
    return ResponseEntity.ok(promedio);
}
}
