package com.ladrillera.ladrillera.controldepagos.entify;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "control_pagos")
public class Control_Pagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_cliente", nullable = false)
    private Integer id_cliente;

    @Column(name = "nombre_cliente", nullable = false)
    private String nombre_cliente;

    @ManyToOne
    @JoinColumn(name = "plan_pago_id", nullable = false)
    private Planes_Pago planPago;

    @Column(name = "numero_cuotas", nullable = false)
    private Integer numero_cuotas;

    @Column(name = "valor_cuota", nullable = false)
    private Double valor_cuota;

    @Column(name = "prefijo", nullable = false)
    private String prefijo;

    @Column(name = "valor_factura", nullable = false)
    private Double valor_factura;

    @Column(name = "total_abonado", nullable = false)
    private Double total_abonado;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "fecha_calculo", nullable = false)
    private LocalDate fecha_calculo;

    // Getter y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public Planes_Pago getPlanPago() {
        return planPago;
    }

    public void setPlanPago(Planes_Pago planPago) {
        this.planPago = planPago;
    }

    public Integer getnumero_cuotas() {
        return numero_cuotas;
    }

    public void setnumero_cuotas(Integer numero_cuotas) {
        this.numero_cuotas = numero_cuotas;
    }

    public Double getvalor_cuota() {
        return valor_cuota;
    }

    public void setvalor_cuota(Double valor_cuota) {
        this.valor_cuota = valor_cuota;
    }

    public String getprefijo() {
        return prefijo;
    }

    public void setprefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public Double getvalor_factura() {
        return valor_factura;
    }

    public void setvalor_factura(Double valor_factura) {
        this.valor_factura = valor_factura;
    }

    public Double gettotal_abonado() {
        return total_abonado;
    }

    public void settotal_abonado(Double total_abonado) {
        this.total_abonado = total_abonado;
    }

    public String getestado() {
        return estado;
    }

    public void setestado(String estado) {
        this.estado = estado;
    }

    public LocalDate getfecha_calculo() {
        return fecha_calculo;
    }

    public void setfecha_calculo(LocalDate fecha_calculo) {
        this.fecha_calculo = fecha_calculo;
    }

}
