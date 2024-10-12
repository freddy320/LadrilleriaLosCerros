package com.ladrillera.ladrillera.controldepagos.repository;

import com.ladrillera.ladrillera.controldepagos.entify.Pagos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PagosRepository extends JpaRepository<Pagos, Long> {
    
}