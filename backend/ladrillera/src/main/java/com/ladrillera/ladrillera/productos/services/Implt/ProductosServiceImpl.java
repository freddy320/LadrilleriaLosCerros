package com.ladrillera.ladrillera.productos.services.Implt;

import com.ladrillera.ladrillera.productos.entity.Productos;
import com.ladrillera.ladrillera.productos.entity.VentaProductoDTO;
import com.ladrillera.ladrillera.productos.repository.ProductosRepository;
import com.ladrillera.ladrillera.productos.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.math.BigDecimal;


import java.util.List;

@Service
public class ProductosServiceImpl implements ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public List<Productos> listarProductos() {
        return productosRepository.findAll(); // Llama al repositorio para listar los productos
    }


@Override
    public List<VentaProductoDTO> listarProductosVendidos() {
        List<VentaProductoDTO> ventas = new ArrayList<>(); 
            
            //DATOS SIMULADOS

            ventas.add(new VentaProductoDTO("Producto A", 10, new BigDecimal("5.00")));
            ventas.add(new VentaProductoDTO("Producto B", 6, new BigDecimal("113.00")));
            ventas.add(new VentaProductoDTO("Producto C", 16, new BigDecimal("115.00")));

            return ventas;
        
    }
}