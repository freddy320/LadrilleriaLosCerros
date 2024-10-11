package com.ladrillera.ladrillera.controldepagos.services;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ladrillera.ladrillera.controldepagos.entify.Planes_Pago;
import com.ladrillera.ladrillera.controldepagos.repository.PlanesDePagoRepository;

import java.util.List;
import java.util.Optional;


@Service
public class PlanesDePagoService {

    @Autowired
    private PlanesDePagoRepository planesDePagoRepository;

   
    public Optional<Planes_Pago> obtenerPlanPorId(Long id) {
        return planesDePagoRepository.findById(id);
    }

    public List<Planes_Pago> ListarPlanes() {
        return planesDePagoRepository.findAll();
    }

    public Planes_Pago guardarPlan(Planes_Pago plan) {
        return planesDePagoRepository.save(plan);
    }

}
