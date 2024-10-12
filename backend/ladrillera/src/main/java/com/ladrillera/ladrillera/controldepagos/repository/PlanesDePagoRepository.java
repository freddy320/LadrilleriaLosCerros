package com.ladrillera.ladrillera.controldepagos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladrillera.ladrillera.controldepagos.entify.Planes_Pago;


@Repository
public interface PlanesDePagoRepository extends JpaRepository<Planes_Pago, Long> {
    
}