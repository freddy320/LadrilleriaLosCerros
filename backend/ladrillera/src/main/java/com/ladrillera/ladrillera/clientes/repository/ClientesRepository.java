package com.ladrillera.ladrillera.clientes.repository;

import com.ladrillera.ladrillera.clientes.entity.Clientes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
