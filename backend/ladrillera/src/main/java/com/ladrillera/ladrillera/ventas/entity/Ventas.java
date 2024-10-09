package com.ladrillera.ladrillera.ventas.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "prefijo", nullable = false, length = 10)
    private String prefijo;

    @Column(name = "documento", nullable = false, length = 20)
    private String documento;

    @Column(name = "cliente_id", nullable = false)
    private Integer clienteId; // Cliente ID con anotación de columna

    @Column(name = "ciudad", nullable = false, length = 50)
    private String ciudad;

    @Column(name = "total_venta", precision = 15, scale = 2, nullable = false)
    private BigDecimal totalVenta; // Total de la venta con precisión y escala

    @Column(name = "sede", nullable = false, length = 50)
    private String sede;

    // Constructor por defecto
    public Ventas() {
    }


    

    public Ventas(Long id, LocalDate fecha, String prefijo, String documento, Integer clienteId, String ciudad,
            BigDecimal totalVenta, String sede) {
        this.id = id;
        this.fecha = fecha;
        this.prefijo = prefijo;
        this.documento = documento;
        this.clienteId = clienteId;
        this.ciudad = ciudad;
        this.totalVenta = totalVenta;
        this.sede = sede;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }
}
