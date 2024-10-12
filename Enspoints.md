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

NUMERO DE VENTAS POR MES Y SUCURSAL
http://localhost:8080/api/ventas/contar/sucursal/mes?sucursal=Sede Central&mes=06&anio=2023

Parametros en orden:
@RequestParam("sucursal"): Nombre de la sucursal despues del ?
@RequestParam("mes"): Numero del mes
@RequestParam("anio"): Numero del anio
Uso del ?: Separa la ruta de los parámetros de consulta.
Uso del &: Separa múltiples parámetros de consulta (si hubiera más).

NUMERO VENTAS POR AÑO Y SURCUSAL
http://localhost:8080/api/ventas/contar/sucursal/anio?sucursal=sede cali&anio=2023

Parametros en orden:
@RequestParam("sucursal"): Nombre de la sucursal despues del ?
@RequestParam("anio"): Numero del anio
Uso del ?: Separa la ruta de los parámetros de consulta.
Uso del &: Separa múltiples parámetros de consulta (si hubiera más).

PROMEDIO DE VENTAS POR MES
http://localhost:8080/api/ventas/promedio/mes?mes=06&anio=2023

Parametros en orden:
@RequestParam(mes): Numero del mes despues del ?
@RequestParam(anio): Numero del anio
Uso del ?: Separa la ruta de los parámetros de consulta.
Uso del &: Separa múltiples parámetros de consulta (si hubiera más).

TOP 3 DE CLIENTES CON MAS VENTAS
http://localhost:8080/api/ventas/top-clientes
(No tiene parametros)

## LISTADO DE PRODUCTOS VENDIDOS
http://localhost:8080/api/productos/listar_ventas

## LISTAR PLANES DE PAGO (GET)
http://localhost:8080/api/PlanesDePago/listar_planes

## Guardar Plan De Pago (POST)
http://localhost:8080/api/PlanesDePago

## LOS 2 POST FINALES TIENEN ERROR AL MOMENTO DE GUARDAR LA VARIABLE REFERENTE AL PLAN DE PAGO

## LISTAR CONTROLES DE PAGO (GET)
http://localhost:8080/api/Control_Pagos/listar_control

## GUARDAR CONTROLES DE PAGO (POST):
http://localhost:8080/api/Control_Pagos/guardar

## LISTAR PAGOS
http://localhost:8080/api/Pagos/listar_pagos

## GUARDAR PAGOS
http://localhost:8080/api/Pagos