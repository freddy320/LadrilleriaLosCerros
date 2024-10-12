package com.ladrillera.ladrillera.ventas.services;

import com.ladrillera.ladrillera.ventas.entity.Ventas;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface VentasService {
  List<Ventas> listarVentasPorCliente(Long clienteId); // Método para listar ventas por clienteId

  long contarVentasPorClientePorDia(Long clienteId, LocalDate fecha);

  long contarVentasPorClientePorMes(Long clienteId, int mes, int anio);

  long contarVentasPorClientePorAnio(Long clienteId, int anio);

  String verificarPosibilidadDeCompra(Long clienteId);

  Map<String, Long> contarVentasPorSucursal(String sucursal, int anio);

  long contarVentasPorSucursalPorMes(String sucursal, int mes, int anio);

  double calcularPromedioVentasPorMes(String sucursal, int mes, int anio);

  List<Map<String, Object>> obtenerTopTresClientesPorVentas(String sucursal, int mes, int anio);

  List<Map<String, Object>> obtenerTopTresProductosPorVentas(String sucursal, int mes, int anio);

}
