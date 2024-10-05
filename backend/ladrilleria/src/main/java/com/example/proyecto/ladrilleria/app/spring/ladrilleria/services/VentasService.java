package com.example.proyecto.ladrilleria.app.spring.ladrilleria.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.proyecto.ladrilleria.app.spring.ladrilleria.entities.Ventas;

@Service
public interface VentasService {

    List<Ventas> obtenerVentasAño(int year);

    List<Ventas> obtenerVentasMes(int month);

    BigDecimal obtenerPromedioVentasSede(String sede);


}
