package com.ladrillera.ladrillera.productos.entity;

import java.math.BigDecimal;


public class VentaProductoDTO {
    
    private String nombre;
    private int cantidadVendida;
    private BigDecimal precio_unitario;
    private BigDecimal precio_total;

    //Constructor
    
    public VentaProductoDTO(String nombre, int cantidadVendida, BigDecimal precio_unitario){
        this.nombre = nombre;
        this.cantidadVendida = cantidadVendida;
        this.precio_unitario = precio_unitario;
        this.precio_total = precio_unitario.multiply(BigDecimal.valueOf(cantidadVendida));
    }

    //Getter y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public BigDecimal getPrecio_Unitario() {
        return precio_unitario;
    }

  
    public BigDecimal getPrecio_Total() {
        return precio_total;
    }

    public void setPrecio_Total(BigDecimal precio_total) {
        this.precio_total = precio_total;
    }

}
