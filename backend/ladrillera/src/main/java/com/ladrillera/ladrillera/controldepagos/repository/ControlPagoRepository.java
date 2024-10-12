package com.ladrillera.ladrillera.controldepagos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladrillera.ladrillera.controldepagos.entify.Control_Pagos;

@Repository
public interface ControlPagoRepository extends JpaRepository<Control_Pagos, Long> {

   
    
}