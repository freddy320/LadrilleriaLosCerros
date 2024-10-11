package com.ladrillera.ladrillera.controldepagos.entify;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name ="pagos")
public class Pagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer factura_id;
    private Integer id_cliente;
    private Integer forma_pago_id;
    private String cliente;
    private Double monto;
    private Integer numero_Cuotas;
    private LocalDate fecha_pago;
    private String referencia;
    private String prefijo;
    private Integer anulado;
    private LocalDate fecha_anulacion;

    // Getter y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFactura_Id() {
        return factura_id;
    }

    public void setFactura_Id(Integer factura_id) {
        this.factura_id = factura_id;

    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getForma_pago_id() {
        return forma_pago_id;
    }

    public void setForma_pago_id(Integer forma_pago_id) {
        this.forma_pago_id = forma_pago_id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Integer getNumero_Cuotas() {
        return numero_Cuotas;
    }

    public void setNumero_Cuotas(Integer numero_Cuotas) {
        this.numero_Cuotas = numero_Cuotas;
    }

    public LocalDate getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(LocalDate fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public Integer getAnulado() {
        return anulado;
    }

    public void setAnulado(Integer anulado) {
        this.anulado = anulado;
    }

    public LocalDate getFecha_anulacion() {
        return fecha_anulacion;
    }

    public void setFecha_anulacion(LocalDate fecha_anulacion) {
        this.fecha_anulacion = fecha_anulacion;
    }

   
}
