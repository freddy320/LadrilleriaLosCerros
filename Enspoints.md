# END POINTS DE LA API PARA LADRILLERIA LOS CERROS || SAN MIGUEL

NUMERO DE VENTAS A UN CLIENTE POR DIA
http://localhost:8080/api/ventas/contar/dia/1?&fecha=2024-10-07

Parametros en orden:
@PathVariable id del cliente: ID del cliente en la ruta.
@RequestParam("fecha"): Fecha pasada despues del ? en formato YYYY-MM-DD.
Uso del ?: Separa la ruta de los parámetros de consulta.
Uso del &: Separa múltiples parámetros de consulta (si hubiera más).

NUMERO DE VENTAS A UN CLIENTE POR MES
http://localhost:8080/api/ventas/contar/mes/1?mes=10&anio=2024

Parametros en orden:
@PathVariable id del cliente: ID del cliente en la ruta
@RequestParam("mes"): Numero del mes despues del ?
@RequestParam("anio"): Numero del anio
Uso del ?: Separa la ruta de los parámetros de consulta.
Uso del &: Separa múltiples parámetros de consulta (si hubiera más).

NUMERO DE VENTAS A UN CLIENTE POR AÑO
http://localhost:8080/api/ventas/contar/anio/1?anio=2024

Parametros en orden:
@PathVariable id del cliente: ID del cliente en la ruta
@RequestParam("anio"): Numero del anio despues del ?
Uso del ?: Separa la ruta de los parámetros de consulta.
Uso del &: Separa múltiples parámetros de consulta (si hubiera más).

CICLO DE VENTAS DE UN CLIENTE Y MENSAJE DE RECORDATORIO SI NO HA COMPRADO
http://localhost:8080/api/ventas/verificar/2

Unico parametro para Endpoint para el ciclo de ventas de un cliente
@PathVariable id del cliente

TOP 3 DE CLIENTES CON MAS VENTAS
http://localhost:8080/api/ventas/top-clientes?sucursal=sede norte&mes=todos&anio=2024
sucursal
mes
anio

TOP 3 PRODUCTOS MAS VENDIDOS POR SUCURSAL, MES Y ANIO
http://localhost:8080/api/ventas/top-productos?sucursal=sede norte&mes=todos&anio=2024
Parametros
sucursal
mes
anio

Metodo para arrojar los años que hubo ventas
http://localhost:8080/api/ventas/anios

Metodo para arrojar las ventas por anio, mes y sucurasl
http://localhost:8080/api/ventas/contar/sucursal/mes/anio?sucursal=Sede norte&mes=todos&anio=2024

Promedio ventas
http://localhost:8080/api/ventas/estadisticas?sucursal=Sede norte&mes=todos&anio=2024

## LISTADO DE PRODUCTOS VENDIDOS

http://localhost:8080/api/productos/listar_ventas

## LISTAR PLANES DE PAGO (GET)

http://localhost:8080/api/planes/listar

## Guardar Plan De Pago (POST)

http://localhost:8080/api/planes/guardar

## LOS 2 POST FINALES TIENEN ERROR AL MOMENTO DE GUARDAR LA VARIABLE REFERENTE AL PLAN DE PAGO

## LISTAR CONTROLES DE PAGO (GET)

http://localhost:8080/api/control/listar

## GUARDAR CONTROLES DE PAGO (POST):

http://localhost:8080/api/control/guardar

## LISTAR PAGOS

http://localhost:8080/api/pagos/listar

## GUARDAR PAGOS

http://localhost:8080/api/pagos/guardar

##

```

```
