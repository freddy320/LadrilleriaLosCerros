package com.ladrillera.ladrillera.ventas.services;

import com.ladrillera.ladrillera.ventas.entity.Ventas;

import java.time.LocalDate;
import java.util.List;

public interface VentasService {
  List<Ventas> listarVentasPorCliente(Integer clienteId); // Método para listar ventas por clienteId

  long contarVentasPorClientePorDia(Integer clienteId, LocalDate fecha);

  long contarVentasPorClientePorMes(Integer clienteId, int mes, int anio); // Metodo mes

  long contarVentasPorClientePorAnio(Integer clienteId, int anio); // Metodo año

  String verificarPosibilidadDeCompra(Integer clienteId);

}
