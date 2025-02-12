package com.ladrillera.ladrillera.clientes.services.Impl;

import com.ladrillera.ladrillera.clientes.entity.Clientes;
import com.ladrillera.ladrillera.clientes.repository.ClientesRepository;
import com.ladrillera.ladrillera.clientes.services.ClientesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    @Override
    public List<Clientes> listarClientes() {
        return clientesRepository.findAll(); // Llama al repositorio para listar los clientes
    }

    @Override
    public Optional<Clientes> obtenerClientePorId(Long id) {
        return clientesRepository.findById(id); // Llama al repositorio para buscar por ID
    }

}
