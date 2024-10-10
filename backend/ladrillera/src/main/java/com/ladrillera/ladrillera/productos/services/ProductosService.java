package com.ladrillera.ladrillera.productos.services;

import com.ladrillera.ladrillera.productos.entity.Productos;
import com.ladrillera.ladrillera.productos.entity.VentaProductoDTO;

import java.util.List;

public interface ProductosService {
    List<Productos> listarProductos(); // Método para listar productos
    List<VentaProductoDTO> listarProductosVendidos(); // Método para listar los productos VENDIDOS
}
