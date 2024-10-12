package com.ladrillera.ladrillera.controldepagos.controller;

import com.ladrillera.ladrillera.controldepagos.entify.Planes_Pago;
import com.ladrillera.ladrillera.controldepagos.services.PlanesDePagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planes")
public class PlanesDePagoController {

    @Autowired
    private PlanesDePagoService planesDePagoService;

    @GetMapping("/listar")
    public List<Planes_Pago> ListarPlanes() {
        return planesDePagoService.ListarPlanes();
    }

    @PostMapping("/guardar")
    public ResponseEntity<Planes_Pago> guardarPlan(@RequestBody Planes_Pago plan) {
        return ResponseEntity.ok(planesDePagoService.guardarPlan(plan));
    }

}
