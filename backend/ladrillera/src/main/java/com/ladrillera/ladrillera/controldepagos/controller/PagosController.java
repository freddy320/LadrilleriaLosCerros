package com.ladrillera.ladrillera.controldepagos.controller;

import com.ladrillera.ladrillera.controldepagos.entify.Pagos;
import com.ladrillera.ladrillera.controldepagos.services.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagosController {

    @Autowired
    private PagosService pagosService;

    @GetMapping("/listar")
    public List<Pagos> ListarPagos() {
        return pagosService.ListarPagos();
    }

    @PostMapping("/guardar")
    public ResponseEntity<Pagos> guardarPago(@RequestBody Pagos pago) {
        return ResponseEntity.ok(pagosService.guardarPago(pago));
    }
}
