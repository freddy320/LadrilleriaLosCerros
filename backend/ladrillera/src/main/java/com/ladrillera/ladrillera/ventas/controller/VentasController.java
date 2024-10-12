package com.ladrillera.ladrillera.ventas.controller;

import com.ladrillera.ladrillera.ventas.entity.Ventas;
import com.ladrillera.ladrillera.ventas.services.VentasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    // Endpoint para listar las ventas por cliente
    @GetMapping("/listar/{clienteId}")
    public List<Ventas> listarVentasPorCliente(@PathVariable Integer clienteId) {
        return ventasService.listarVentasPorCliente(clienteId);
    }

    // Endpoint para contar ventas por cliente en un día
    @GetMapping("/contar/dia/{clienteId}")
    public long contarVentasPorClientePorDia(@PathVariable Integer clienteId, @RequestParam LocalDate fecha) {
        return ventasService.contarVentasPorClientePorDia(clienteId, fecha);
    }

    // Endpoint para contar ventas por cliente en un mes y año
    @GetMapping("/contar/mes/{clienteId}")
    public long contarVentasPorClientePorMes(@PathVariable Integer clienteId, @RequestParam int mes,
            @RequestParam int anio) {
        return ventasService.contarVentasPorClientePorMes(clienteId, mes, anio);
    }

    // Endpoint para contar ventas por cliente en un año
    @GetMapping("/contar/anio/{clienteId}")
    public long contarVentasPorClientePorAnio(@PathVariable Integer clienteId, @RequestParam int anio) {
        return ventasService.contarVentasPorClientePorAnio(clienteId, anio);
    }

    // Endpoint para verificar la posibilidad de compra
    @GetMapping("/verificar/{clienteId}")
    public String verificarPosibilidadDeCompra(@PathVariable Integer clienteId) {
        return ventasService.verificarPosibilidadDeCompra(clienteId);
    }

    // Endpoint para las ventas de las sucursales en un año
    @GetMapping("/contar/sucursal/anio")
    public Map<String, Long> contarVentasPorSucursalPorMeses(@RequestParam String sucursal, @RequestParam int anio) {
        return ventasService.contarVentasPorSucursal(sucursal, anio);
    }

    // Endpoint para las cantidad de ventas de una sucursal en un mes
    @GetMapping("/contar/sucursal/mes")
    public long contarVentasPorSucursalPorMes(@RequestParam String sucursal, @RequestParam int mes,
            @RequestParam int anio) {
        return ventasService.contarVentasPorSucursalPorMes(sucursal, mes, anio);
    }

    // Método para obtener el promedio de ventas por mes
    @GetMapping("/promedio/mes")
    public double promedioVentasPorMes(@RequestParam int mes, @RequestParam int anio) {
        // Lógica para calcular el promedio de ventas por mes
        return ventasService.calcularPromedioVentasPorMes(mes, anio);
    }

    @GetMapping("/top-clientes")
    public ResponseEntity<List<Map<String, Object>>> obtenerTopTresClientesPorVentas() {
        List<Map<String, Object>> topClientes = ventasService.obtenerTopTresClientesPorVentas();
        return ResponseEntity.ok(topClientes);
    }

}
