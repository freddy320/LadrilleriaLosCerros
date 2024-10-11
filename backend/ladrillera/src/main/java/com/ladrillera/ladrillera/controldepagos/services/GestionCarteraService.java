package com.ladrillera.ladrillera.controldepagos.services;

import com.ladrillera.ladrillera.controldepagos.entify.Control_Pagos;

import com.ladrillera.ladrillera.controldepagos.entify.Planes_Pago;
import com.ladrillera.ladrillera.controldepagos.repository.PlanesDePagoRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GestionCarteraService {

    @Autowired
    private ControlPagoService controlPagoService;

    @Autowired
    private PlanesDePagoRepository planesDePagoRepository;

    @Scheduled(fixedRate = 900000)
    public void gestionarCartera() {
        List<Control_Pagos> controles = controlPagoService.listarControles();
        LocalDate fechaActual = LocalDate.now();

        for (Control_Pagos control : controles) {
            LocalDate fecha_Calculo = control.getfecha_calculo();
            Long planPagoId = control.getPlanPago().getId(); // Para obtener el Id del Plan de Pago
            Optional<Planes_Pago> planPagoOpt = planesDePagoRepository.findById(planPagoId);

            if (planPagoOpt.isPresent()) {
                Planes_Pago planPago = planPagoOpt.get();
                LocalDate fecha_anulacion = calcularFechaLimite(fecha_Calculo, planPago.getperiodo_tiempo());

                if (fechaActual.isAfter(fecha_anulacion)) {
                    control.setestado("vencida");
                } else {
                    control.setestado("pendiente");
                }

                // Actualizamos el estado en la base de datos
                controlPagoService.guardarControl(control);
            } else {
                // Manejar el caso en que el plan no se encuentre
                control.setestado("plan de pago no encontrado");
                controlPagoService.guardarControl(control);
            }
        }
    }
    private LocalDate calcularFechaLimite(LocalDate fecha_Calculo, String periodo_tiempo) {
        switch (periodo_tiempo.toLowerCase()) {
            case "Semanal":
                return fecha_Calculo.plusWeeks(1);
            case "Quincenal":
                return fecha_Calculo.plusWeeks(2);
            case "Mensual":
                return fecha_Calculo.plusMonths(1);
            default:
                throw new IllegalArgumentException("Periodo desconocido: " + periodo_tiempo);
        }
    }
}