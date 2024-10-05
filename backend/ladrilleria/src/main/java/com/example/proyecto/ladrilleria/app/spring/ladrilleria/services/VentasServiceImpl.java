package com.example.proyecto.ladrilleria.app.spring.ladrilleria.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.ladrilleria.app.spring.ladrilleria.entities.Ventas;
import com.example.proyecto.ladrilleria.app.spring.ladrilleria.repositories.VentasRepository;

@Service
public class VentasServiceImpl implements VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    @Override
    public List<Ventas> obtenerVentasAño(int year) {
        return ventasRepository.findByFechaYear(year);
        
    }

    @Override
    public List<Ventas> obtenerVentasMes(int month) {
        return ventasRepository.findByFechaMonth(month);

    }  

    @Override
    public BigDecimal obtenerPromedioVentasSede(String sede) {

        // Obtener todas las ventas
        List<Ventas> ventas = ventasRepository.findAll();
    
        // Filtrar las ventas por nombre de la sede
        List<Ventas> ventasPorSede = ventas.stream()
            .filter(venta -> venta.getSede() != null && venta.getSede().equalsIgnoreCase(sede))
            .collect(Collectors.toList());
    
        // Comprobar si hay ventas para esa sede
        if (ventasPorSede.isEmpty()) {
            return BigDecimal.ZERO;
        }
    
        // Calcular la suma de las ventas
        BigDecimal suma = ventasPorSede.stream()
            .map(venta -> venta.getTotal_venta() != null ? venta.getTotal_venta() : BigDecimal.ZERO)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    
        // Retornar el promedio de las ventas para la sede
         return suma.divide(BigDecimal.valueOf(ventasPorSede.size()), 2, RoundingMode.HALF_UP);
    }
    

}
