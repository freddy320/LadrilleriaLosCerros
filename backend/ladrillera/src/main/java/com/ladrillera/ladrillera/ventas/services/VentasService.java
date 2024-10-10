package com.ladrillera.ladrillera.ventas.services;

import com.ladrillera.ladrillera.ventas.entity.Ventas;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface VentasService {
  List<Ventas> listarVentasPorCliente(Integer clienteId); // Método para listar ventas por clienteId

  long contarVentasPorClientePorDia(Integer clienteId, LocalDate fecha);

  long contarVentasPorClientePorMes(Integer clienteId, int mes, int anio); // Metodo mes

  long contarVentasPorClientePorAnio(Integer clienteId, int anio); // Metodo año

  String verificarPosibilidadDeCompra(Integer clienteId);

  Map<String, Long> contarVentasPorSucursal(String sucursal, int anio);

  long contarVentasPorSucursalPorMes(String sucursal, int mes, int anio);

  double calcularPromedioVentasPorMes(int mes, int anio); // Metodo para el promedio de ventas por Mes

}
