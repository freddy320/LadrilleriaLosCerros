```markdown
#END POINTS DE LA API PARA LADRILLERIA LOS CERROS || SAN MIGUEL

## NUMERO DE VENTAS A UN CLIENTE POR DIA
http://localhost:8080/api/ventas/contar/dia/1?&fecha=2024-10-07

## NUMERO DE VENTAS A UN CLIENTE POR MES
http://localhost:8080/api/ventas/contar/mes/1?mes=10&anio=2024

## NUMERO DE VENTAS A UN CLIENTE POR AÑO
http://localhost:8080/api/ventas/contar/anio/1?anio=2024

## CICLO DE VENTAS DE UN CLIENTE Y MENSAJE DE RECORDATORIO SI NO HA COMPRADO
http://localhost:8080/api/ventas/verificar/2

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