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