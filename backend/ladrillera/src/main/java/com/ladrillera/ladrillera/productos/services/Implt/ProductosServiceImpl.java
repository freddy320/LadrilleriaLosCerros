package com.ladrillera.ladrillera.productos.services.Implt;

import com.ladrillera.ladrillera.productos.entity.Productos;
import com.ladrillera.ladrillera.productos.repository.ProductosRepository;
import com.ladrillera.ladrillera.productos.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServiceImpl implements ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public List<Productos> listarProductos() {
        return productosRepository.findAll(); // Llama al repositorio para listar los productos
    }
}