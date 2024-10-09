package com.ladrillera.ladrillera.pagosFactura.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pagos_factura")
public class PagosFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "prefijo", nullable = false, length = 10)
    private String prefijo;

    @Column(name = "numero", nullable = false, length = 20)
    private String numero;

    @Column(name = "valor_abonado", nullable = false, precision = 15, scale = 2)
    private BigDecimal valorAbonado;

    @Column(name = "anulado", nullable = false)
    private Boolean anulado;

    // Constructor por defecto
    public PagosFactura() {
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getValorAbonado() {
        return valorAbonado;
    }

    public void setValorAbonado(BigDecimal valorAbonado) {
        this.valorAbonado = valorAbonado;
    }

    public Boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(Boolean anulado) {
        this.anulado = anulado;
    }
}
