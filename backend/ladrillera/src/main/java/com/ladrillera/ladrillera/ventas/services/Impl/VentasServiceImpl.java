package com.ladrillera.ladrillera.ventas.services.Impl;

import com.ladrillera.ladrillera.ventas.entity.Ventas;
import com.ladrillera.ladrillera.ventas.repository.VentasRepository;
import com.ladrillera.ladrillera.ventas.services.VentasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Service
public class VentasServiceImpl implements VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    @Override
    public List<Ventas> listarVentasPorCliente(Integer clienteId) {
        return ventasRepository.findByClienteId(clienteId); // Llama al repositorio para buscar ventas por clienteId
    }

    @Override
    public long contarVentasPorClientePorDia(Integer clienteId, LocalDate fecha) {
        return ventasRepository.countByClienteIdAndFecha(clienteId, fecha);
    }

    @Override
    public long contarVentasPorClientePorMes(Integer clienteId, int mes, int anio) {
        // Calcular la primera y última fecha del mes
        LocalDate fechaInicio = LocalDate.of(anio, mes, 1);
        LocalDate fechaFin = fechaInicio.withDayOfMonth(fechaInicio.lengthOfMonth());
        return ventasRepository.countByClienteIdAndFechaBetween(clienteId, fechaInicio, fechaFin);
    }

    @Override
    public long contarVentasPorClientePorAnio(Integer clienteId, int anio) {
        // Calcular la primera y última fecha del año
        LocalDate fechaInicio = LocalDate.of(anio, 1, 1);
        LocalDate fechaFin = fechaInicio.withDayOfYear(fechaInicio.lengthOfYear());
        return ventasRepository.countByClienteIdAndFechaAnual(clienteId, fechaInicio, fechaFin);
    }

    @Override
    public String verificarPosibilidadDeCompra(Integer clienteId) {
        LocalDate fechaActual = LocalDate.now();
        int mesActual = fechaActual.getMonthValue();
        int anioActual = fechaActual.getYear();

        // Obtener ventas del día actual
        long ventasDia = contarVentasPorClientePorDia(clienteId, fechaActual);

        // Obtener ventas del mes actual
        long ventasMes = contarVentasPorClientePorMes(clienteId, mesActual, anioActual);

        // Obtener ventas del año actual
        long ventasAnio = contarVentasPorClientePorAnio(clienteId, anioActual);

        StringBuilder mensaje = new StringBuilder("Frecuencia de compra para el cliente ID " + clienteId + ":\n");

        // Análisis de la frecuencia de compra
        if (ventasDia > 0) {
            mensaje.append("El cliente ha realizado compras hoy.\n");
        } else {
            mensaje.append("El cliente no ha realizado compras hoy. ");
        }

        if (ventasMes > 0) {
            mensaje.append("El cliente ha realizado compras este mes.\n");
        } else {
            mensaje.append(
                    "El cliente no ha realizado compras este mes.  ¡Te invitamos a visitar nuestra tienda y disfrutar.\n");
        }

        if (ventasAnio > 0) {
            mensaje.append("El cliente ha realizado compras este año.\n");
        } else {
            mensaje.append(
                    "El cliente no ha realizado compras este año. ¡Te invitamos a visitar nuestra tienda y disfrutar.\n");
        }

        return mensaje.toString();
    }

    // Nuevos metodos para las ventas

    @Override
    public double calcularPromedioVentasPorMes(int mes, int anio) {
        List<Ventas> ventasDelMes = ventasRepository.obtenerVentasPorMes(mes, anio);

        // Sumar el total de las ventas del mes
        BigDecimal totalVentas = ventasDelMes.stream()
                .map(Ventas::getTotalVenta)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        int cantidadVentas = ventasDelMes.size();

        if (cantidadVentas == 0) {
            return 0;
        }

        // Calcular el promedio (total ventas / cantidad de ventas)
        BigDecimal promedio = totalVentas.divide(BigDecimal.valueOf(cantidadVentas), RoundingMode.HALF_UP);

        // Convertir a double si es necesario
        return promedio.doubleValue();
    }

    @Override
    public Map<String, Long> contarVentasPorSucursal(String sucursal, int anio) {
        Map<String, Long> ventasPorMes = new HashMap<>();

        for (int mes = 1; mes <= 12; mes++) {
            LocalDate fechaInicio = LocalDate.of(anio, mes, 1);
            LocalDate fechaFin = fechaInicio.withDayOfMonth(fechaInicio.lengthOfMonth());

            long ventas = ventasRepository.countBySedeAndFechaBetween(sucursal, fechaInicio, fechaFin);
            ventasPorMes.put(fechaInicio.getMonth().name(), ventas); // Nombre del mes en texto
        }

        return ventasPorMes;
    }

    // Metodo para contar ventas por sucursal
    @Override
    public long contarVentasPorSucursalPorMes(String sucursal, int mes, int anio) {
        LocalDate fechaInicio = LocalDate.of(anio, mes, 1);
        LocalDate fechaFin = fechaInicio.withDayOfMonth(fechaInicio.lengthOfMonth());
        return ventasRepository.countBySedeAndFechaBetween(sucursal, fechaInicio, fechaFin);
    }

}