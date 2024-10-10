package com.ladrillera.ladrillera.productos.controller;

import com.ladrillera.ladrillera.productos.entity.Productos;
import com.ladrillera.ladrillera.productos.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    // Endpoint para listar todos los productos
    @GetMapping("/listar")
    public List<Productos> listarProductos() {
        return productosService.listarProductos();
    }

    //Hola que hace
}
