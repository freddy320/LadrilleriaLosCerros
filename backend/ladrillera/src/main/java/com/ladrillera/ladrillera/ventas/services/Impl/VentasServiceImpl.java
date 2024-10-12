package com.ladrillera.ladrillera.ventas.services.Impl;

import com.ladrillera.ladrillera.automatizacionTareas.Services.AutomatizacionTareasService;
import com.ladrillera.ladrillera.clientes.entity.Clientes;
import com.ladrillera.ladrillera.clientes.repository.ClientesRepository;
import com.ladrillera.ladrillera.productos.entity.Productos;
import com.ladrillera.ladrillera.productos.repository.ProductosRepository;
import com.ladrillera.ladrillera.ventas.entity.Ventas;
import com.ladrillera.ladrillera.ventas.repository.VentasRepository;
import com.ladrillera.ladrillera.ventas.services.VentasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.LinkedHashMap;

@Service
public class VentasServiceImpl implements VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private AutomatizacionTareasService automatizacionTareasService;

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public List<Ventas> listarVentasPorCliente(Long clienteId) {
        return ventasRepository.findByClienteId(clienteId); // Llama al repositorio para buscar ventas por clienteId
    }

    // Método para contar ventas por cliente en un día específico
    @Override
    public long contarVentasPorClientePorDia(Long clienteId, LocalDate fecha) {
        return ventasRepository.countByClienteIdAndFecha(clienteId, fecha);
    }

    // Método para contar ventas por cliente en un mes y año específicos
    @Override
    public long contarVentasPorClientePorMes(Long clienteId, int mes, int anio) {
        LocalDate fechaInicio = LocalDate.of(anio, mes, 1);
        LocalDate fechaFin = fechaInicio.withDayOfMonth(fechaInicio.lengthOfMonth());
        return ventasRepository.countByClienteIdAndFechaBetween(clienteId, fechaInicio, fechaFin);
    }

    // Método para contar ventas por cliente en un año específico
    @Override
    public long contarVentasPorClientePorAnio(Long clienteId, int anio) {
        LocalDate fechaInicio = LocalDate.of(anio, 1, 1);
        LocalDate fechaFin = LocalDate.of(anio, 12, 31);
        return ventasRepository.countByClienteIdAndFechaBetween(clienteId, fechaInicio, fechaFin);
    }

    // Método para calcular la posibilidad de compra de un cliente
    @Override
    public String verificarPosibilidadDeCompra(Long clienteId) {
        LocalDate fechaActual = LocalDate.now();
        int mesActual = fechaActual.getMonthValue();
        int anioActual = fechaActual.getYear();
        int anioAnterior = anioActual - 1;

        long ventasDiaActual = contarVentasPorClientePorDia(clienteId, fechaActual);
        long ventasDiaAnterior = contarVentasPorClientePorDia(clienteId, fechaActual.minusYears(1));
        long ventasMesActual = contarVentasPorClientePorMes(clienteId, mesActual, anioActual);
        long ventasMesAnterior = contarVentasPorClientePorMes(clienteId, mesActual, anioAnterior);
        long ventasAnioActual = contarVentasPorClientePorAnio(clienteId, anioActual);

        Clientes cliente = clientesRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        String destinatario = cliente.getEmail();
        String nombreCliente = cliente.getNombre();
        String nitCliente = cliente.getNit();

        List<Ventas> ventas = ventasRepository.findByClienteId(clienteId);
        String idProducto = "";
        String nombreProducto = "";

        if (!ventas.isEmpty()) {
            Long productoId = ventas.get(0).getProductoId();
            Productos producto = productosRepository.findById(productoId)
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            idProducto = producto.getId().toString();
            nombreProducto = producto.getNombre();
        }

        StringBuilder mensaje = new StringBuilder("Frecuencia de compra para el cliente con ID " + clienteId + " :\n");

        if (ventasDiaActual > 0) {
            mensaje.append("El cliente ").append(nombreCliente).append(" (con NIT: ").append(nitCliente)
                    .append(") ha realizado compras en esta fecha del Producto: ").append(nombreProducto)
                    .append(" (con ID: ").append(idProducto).append(").\n");
            return mensaje.toString();
        } else if (ventasDiaAnterior > 0) {
            mensaje.append("El cliente ").append(nombreCliente).append(" (con NIT: ").append(nitCliente)
                    .append(") compró en esta fecha el año pasado, pero no ha comprado este año. Producto: ")
                    .append(nombreProducto).append(" (ID: ").append(idProducto).append(").\n");
            automatizacionTareasService.enviarMensajeRecordatorio(destinatario, nombreCliente, "día");
            return mensaje.toString();
        } else {
            mensaje.append("El cliente ").append(nombreCliente).append(" (con NIT: ").append(nitCliente)
                    .append(") no ha realizado compras en esta fecha ni el año pasado.\n");
        }

        if (ventasMesActual > 0) {
            mensaje.append("El cliente ").append(nombreCliente).append(" (con NIT: ").append(nitCliente)
                    .append(") ha realizado compras este mes. Producto: ").append(nombreProducto)
                    .append(" (ID: ").append(idProducto).append(").\n");
            return mensaje.toString();
        } else if (ventasMesAnterior > 0) {
            mensaje.append("El cliente ").append(nombreCliente).append(" (con NIT: ").append(nitCliente)
                    .append(") compró este mes el año pasado, pero no ha comprado este mes en el año actual. Producto: ")
                    .append(nombreProducto).append(" (ID: ").append(idProducto).append(").\n");
            automatizacionTareasService.enviarMensajeRecordatorio(destinatario, nombreCliente, "mes");
            return mensaje.toString();
        } else {
            mensaje.append("El cliente ").append(nombreCliente).append(" (con NIT: ").append(nitCliente)
                    .append(") no ha realizado compras este mes ni el año pasado en este mes.\n");
        }

        if (ventasAnioActual > 0) {
            mensaje.append("El cliente ").append(nombreCliente).append(" (con NIT: ").append(nitCliente)
                    .append(") ha realizado compras este año. del Producto: ").append(nombreProducto)
                    .append(" (ID: ").append(idProducto).append(").\n");
        } else {
            mensaje.append("El cliente ").append(nombreCliente).append(" (con NIT: ").append(nitCliente)
                    .append(") no ha realizado compras este año. Producto: ").append(nombreProducto)
                    .append(" (ID: ").append(idProducto).append(").\n");
            automatizacionTareasService.enviarMensajeRecordatorio(destinatario, nombreCliente, "año");
        }

        return mensaje.toString();
    }

    // Nuevos metodos para las ventas

    @Override
    public double calcularPromedioVentasPorMes(int mes, int anio) {
        List<Ventas> ventasDelMes = ventasRepository.obtenerVentasPorMes(mes, anio);

        // Sumar el total de las ventas del mes
        BigDecimal totalVentas = ventasDelMes.stream()
                .map(Ventas::getTotalVenta)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        int cantidadVentas = ventasDelMes.size();

        if (cantidadVentas == 0) {
            return 0;
        }

        // Calcular el promedio (total ventas / cantidad de ventas)
        BigDecimal promedio = totalVentas.divide(BigDecimal.valueOf(cantidadVentas), RoundingMode.HALF_UP);

        // Convertir a double si es necesario
        return promedio.doubleValue();
    }

    @Override
    public Map<String, Long> contarVentasPorSucursal(String sucursal, int anio) {
        Map<String, Long> ventasPorMes = new LinkedHashMap<>(); // Usar LinkedHashMap para mantener el orden
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", new Locale("es")); // Formato en español

        for (int mes = 1; mes <= 12; mes++) {
            LocalDate fechaInicio = LocalDate.of(anio, mes, 1);
            LocalDate fechaFin = fechaInicio.withDayOfMonth(fechaInicio.lengthOfMonth());

            long ventas = ventasRepository.countBySedeAndFechaBetween(sucursal, fechaInicio, fechaFin);
            String mesEnEspanol = fechaInicio.format(formatter); // Obtener el mes en español

            // Agregar al mapa usando el nombre del mes en español
            ventasPorMes.put(mesEnEspanol, ventas);
        }

        return ventasPorMes;
    }

    // Metodo para contar ventas por sucursal
    @Override
    public long contarVentasPorSucursalPorMes(String sucursal, int mes, int anio) {
        LocalDate fechaInicio = LocalDate.of(anio, mes, 1);
        LocalDate fechaFin = fechaInicio.withDayOfMonth(fechaInicio.lengthOfMonth());
        return ventasRepository.countBySedeAndFechaBetween(sucursal, fechaInicio, fechaFin);
    }

    @Override
    public List<Map<String, Object>> obtenerTopTresClientesPorVentas(String sucursal, int mes, int anio) {
        Pageable topTres = PageRequest.of(0, 3);
        List<Map<String, Object>> topClientes = ventasRepository.findTopClientesPorVentas(sucursal, mes, anio, topTres);

        for (Map<String, Object> cliente : topClientes) {
            Long clienteId = ((Number) cliente.get("clienteId")).longValue();
            Optional<Clientes> clienteInfo = clientesRepository.findById(clienteId);

            clienteInfo.ifPresent(info -> cliente.put("nombre", info.getNombre()));
        }

        return topClientes;
    }

    @Override
    public List<Map<String, Object>> obtenerTopTresProductosPorVentas(String sucursal, int mes, int anio) {
        Pageable topTres = PageRequest.of(0, 3);
        List<Map<String, Object>> topProductos = ventasRepository.findTopProductosPorVentas(sucursal, mes, anio,
                topTres);

        for (Map<String, Object> producto : topProductos) {
            Long productoId = ((Number) producto.get("productoId")).longValue();
            Optional<Productos> productoInfo = productosRepository.findById(productoId);

            productoInfo.ifPresent(info -> {
                producto.put("nombre", info.getNombre());
                producto.put("descripcion", info.getDescripcion());
            });
        }

        return topProductos;
    }

}