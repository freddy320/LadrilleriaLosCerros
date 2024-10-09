package com.ladrillera.ladrillera.clientes.controller;

import com.ladrillera.ladrillera.clientes.entity.Clientes;
import com.ladrillera.ladrillera.clientes.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    // Endpoint para listar todos los clientes
    @GetMapping("/listar")
    public List<Clientes> listarClientes() {
        return clientesService.listarClientes();
    }
}
