package com.ladrillera.ladrillera.clientes.services;

import com.ladrillera.ladrillera.clientes.entity.Clientes;
import java.util.List;
import java.util.Optional;

public interface ClientesService {
    List<Clientes> listarClientes(); // Método para listar clientes

    Optional<Clientes> obtenerClientePorId(Long id); // Metodo para filtar el cliente por su id
}
