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

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId; // Cliente ID con anotación de columna

    @Column(name = "ciudad", nullable = false, length = 50)
    private String ciudad;

    @Column(name = "total_venta", precision = 15, scale = 2, nullable = false)
    private BigDecimal totalVenta; // Total de la venta con precisión y escala

    @Column(name = "sede", nullable = false, length = 50)
    private String sede;

    // Nuevos campos
    @Column(name = "tipo_documento", nullable = false, length = 20)
    private String tipoDocumento;

    @Column(name = "forma_de_pago", nullable = false, length = 50)
    private String formaDePago;

    @Column(name = "fecha_vencimiento_pago", nullable = true)
    private LocalDate fechaVencimientoPago;

    @Column(name = "sucursal", nullable = false, length = 50)
    private String sucursal;

    @Column(name = "estado_id", nullable = false)
    private Long estadoId; // Estado ID

    @Column(name = "empleado_id", nullable = false)
    private Long empleadoId; // Empleado ID

    @Column(name = "producto_id", nullable = false)
    private Long productoId; // Producto ID

    @Column(name = "precio_unitario", precision = 10, scale = 2, nullable = false)
    private BigDecimal precioUnitario;

    @Column(name = "precio_facturado", precision = 10, scale = 2, nullable = false)
    private BigDecimal precioFacturado;

    @Column(name = "sub_total", precision = 15, scale = 2, nullable = false)
    private BigDecimal subTotal;

    @Column(name = "iva", precision = 10, scale = 2, nullable = false)
    private BigDecimal iva;

    @Column(name = "anulado", nullable = false)
    private Boolean anulado;

    @Column(name = "fecha_anulacion")
    private LocalDate fechaAnulacion; // Fecha de Anulación

    // Constructor por defecto
    public Ventas() {
    }

    public Ventas(Long id, LocalDate fecha, String prefijo, Long clienteId, String ciudad,
                  BigDecimal totalVenta, String sede, String tipoDocumento, String formaDePago,
                  LocalDate fechaVencimientoPago, String sucursal, Long estadoId, Long empleadoId,
                  Long productoId, BigDecimal precioUnitario, BigDecimal precioFacturado,
                  BigDecimal subTotal, BigDecimal iva, Boolean anulado, LocalDate fechaAnulacion) {

        this.id = id;
        this.fecha = fecha;
        this.prefijo = prefijo;
        this.clienteId = clienteId;
        this.ciudad = ciudad;
        this.totalVenta = totalVenta;
        this.sede = sede;
        this.tipoDocumento = tipoDocumento;
        this.formaDePago = formaDePago;
        this.fechaVencimientoPago = fechaVencimientoPago;
        this.sucursal = sucursal;
        this.estadoId = estadoId;
        this.empleadoId = empleadoId;
        this.productoId = productoId;
        this.precioUnitario = precioUnitario;
        this.precioFacturado = precioFacturado;
        this.subTotal = subTotal;
        this.iva = iva;
        this.anulado = anulado;
        this.fechaAnulacion = fechaAnulacion;
    }

    // Getters y setters
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

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
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

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public LocalDate getFechaVencimientoPago() {
        return fechaVencimientoPago;
    }

    public void setFechaVencimientoPago(LocalDate fechaVencimientoPago) {
        this.fechaVencimientoPago = fechaVencimientoPago;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public Long getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Long empleadoId) {
        this.empleadoId = empleadoId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getPrecioFacturado() {
        return precioFacturado;
    }

    public void setPrecioFacturado(BigDecimal precioFacturado) {
        this.precioFacturado = precioFacturado;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public Boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(Boolean anulado) {
        this.anulado = anulado;
    }

    public LocalDate getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(LocalDate fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }
}
