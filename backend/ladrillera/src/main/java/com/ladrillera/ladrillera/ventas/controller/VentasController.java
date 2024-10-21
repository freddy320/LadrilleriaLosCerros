package com.ladrillera.ladrillera.ventas.controller;

import com.ladrillera.ladrillera.ventas.entity.Ventas;
import com.ladrillera.ladrillera.ventas.services.VentasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    public List<Ventas> listarVentasPorCliente(@PathVariable Long clienteId) {
        return ventasService.listarVentasPorCliente(clienteId);
    }

    // Método para contar ventas por cliente en un día específico
    @GetMapping("/contar/dia/{clienteId}")
    public long contarVentasPorClientePorDia(
            @PathVariable Long clienteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return ventasService.contarVentasPorClientePorDia(clienteId, fecha);
    }

    // Método para contar ventas por cliente en un mes y año específicos
    @GetMapping("/contar/mes/{clienteId}")
    public long contarVentasPorClientePorMes(
            @PathVariable Long clienteId,
            @RequestParam int mes,
            @RequestParam int anio) {
        return ventasService.contarVentasPorClientePorMes(clienteId, mes, anio);
    }

    // Método para contar ventas por cliente en un año específico
    @GetMapping("/contar/anio/{clienteId}")
    public long contarVentasPorClientePorAnio(
            @PathVariable Long clienteId,
            @RequestParam int anio) {
        return ventasService.contarVentasPorClientePorAnio(clienteId, anio);
    }

    // Endpoint para verificar la posibilidad de compra
    @GetMapping("/verificar/{clienteId}")
    public String verificarPosibilidadDeCompra(@PathVariable Long clienteId) {
        return ventasService.verificarPosibilidadDeCompra(clienteId);
    }

    // Metodo para obtener los clientes con mas ventas filtrado
    @GetMapping("/top-clientes")
    public ResponseEntity<List<String>> obtenerNombresTopClientes(
            @RequestParam String sucursal,
            @RequestParam String mes,
            @RequestParam int anio) {
        List<String> topClientesNombres = ventasService.obtenerTopTresClientesPorVentas(sucursal, mes, anio);
        return ResponseEntity.ok(topClientesNombres);
    }

    @GetMapping("/top-productos")
    public ResponseEntity<List<String>> obtenerNombresTopProductos(
            @RequestParam String sucursal,
            @RequestParam String mes,
            @RequestParam int anio) {
        List<String> topProductosNombres = ventasService.obtenerNombresTopTresProductosPorVentas(sucursal, mes, anio);
        return ResponseEntity.ok(topProductosNombres);
    }

    @GetMapping("/anios")
    public ResponseEntity<List<Integer>> getAniosConVentas() {
        List<Integer> anios = ventasService.obtenerAniosConVentas();
        return ResponseEntity.ok(anios);
    }

    @GetMapping("/contar/sucursal/mes/anio")
    public Map<String, Long> contarVentasPorSucursalPorMeses(
            @RequestParam String sucursal,
            @RequestParam String mes,
            @RequestParam int anio) {
        return ventasService.contarVentasPorSucursal(sucursal, mes, anio);
    }

    @GetMapping("/estadisticas")
    public Map<String, Object> calcularEstadisticasDeVentas(
            @RequestParam String sucursal,
            @RequestParam String mes,
            @RequestParam int anio) {
        return ventasService.calcularGananciasPromedioNumeroVentas(sucursal, mes, anio);
    }

}
