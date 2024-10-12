package com.ladrillera.ladrillera.controldepagos.controller;

import com.ladrillera.ladrillera.controldepagos.entify.Control_Pagos;
import com.ladrillera.ladrillera.controldepagos.entify.Planes_Pago;
import com.ladrillera.ladrillera.controldepagos.services.ControlPagoService;
import com.ladrillera.ladrillera.controldepagos.services.PlanesDePagoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/Control_Pagos")
public class ControlPagoController {

     @Autowired
    private ControlPagoService controlPagoService;

    @Autowired
    private PlanesDePagoService planesDePagoService;

    @GetMapping("/listar_control")
    public List<Control_Pagos> listarControles(){
        return controlPagoService.listarControles();
    }

   
    @PostMapping("/guardar")
    public ResponseEntity<Control_Pagos> guardarControl(@RequestBody Control_Pagos control) {
        if (control.getPlanPago() == null || control.getPlanPago().getId() == null) {
            return ResponseEntity.badRequest().body(null); // Asegúrate de que planPago no es null
        }

        Optional<Planes_Pago> planPagoOpt = planesDePagoService.obtenerPlanPorId(control.getPlanPago().getId());

        if (planPagoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Asegúrate de que el plan de pago existe
        }

        control.setPlanPago(planPagoOpt.get());

        if (control.getfecha_calculo() == null) {
            control.setfecha_calculo(LocalDate.now()); // Establece una fecha predeterminada si no está presente
        }

        return ResponseEntity.ok(controlPagoService.guardarControl(control));
    }
}