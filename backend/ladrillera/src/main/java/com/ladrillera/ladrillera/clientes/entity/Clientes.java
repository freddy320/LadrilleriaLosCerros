package com.ladrillera.ladrillera.clientes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "nit", nullable = false, length = 20, unique = true)
    private String nit;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @Column(name = "telefono", nullable = false, length = 15)
    private Long telefono;

    @Column(name = "email", nullable = false, length = 60, unique = true)
    private String email;

    @Column(name = "ciudad_id", nullable = false, length = 15, unique = true)
    private Long ciudadId;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @Column(name = "fidelizado", nullable = false)
    private Boolean fidelizado;

    @Column(name = "vigencia")
    private LocalDate vigencia; // Ahora usando LocalDate

    @Column(name = "contrato", length = 100)
    private String contrato;

    @Column(name = "cupo_credito", precision = 15, scale = 2)
    private BigDecimal cupoCredito;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion; // Ahora usando LocalDate

    // Constructor por defecto
    public Clientes() {
    }

    public Clientes(Long id, String nombre, String nit, String direccion, Long telefono, String email, Long ciudadId,
            Boolean activo, Boolean fidelizado, LocalDate vigencia, String contrato, BigDecimal cupoCredito,
            LocalDate fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.ciudadId = ciudadId;
        this.activo = activo;
        this.fidelizado = fidelizado;
        this.vigencia = vigencia;
        this.contrato = contrato;
        this.cupoCredito = cupoCredito;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Long ciudadId) {
        this.ciudadId = ciudadId;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getFidelizado() {
        return fidelizado;
    }

    public void setFidelizado(Boolean fidelizado) {
        this.fidelizado = fidelizado;
    }

    public LocalDate getVigencia() {
        return vigencia;
    }

    public void setVigencia(LocalDate vigencia) {
        this.vigencia = vigencia;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public BigDecimal getCupoCredito() {
        return cupoCredito;
    }

    public void setCupoCredito(BigDecimal cupoCredito) {
        this.cupoCredito = cupoCredito;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}