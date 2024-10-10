```markdown
# Documentación de Endpoints de la API

## Introducción
Este documento proporciona una descripción detallada de los endpoints disponibles en nuestra API. Cada sección incluye la ruta del endpoint, el método HTTP, una breve descripción y ejemplos de solicitudes y respuestas.

## Endpoints

### 1. Obtener todos los productos
- **Ruta:** `/api/productos`
- **Método:** `GET`
- **Descripción:** Obtiene una lista de todos los productos disponibles.
- **Ejemplo de Solicitud:**
    ```http
    GET /api/productos HTTP/1.1
    Host: example.com
    ```
- **Ejemplo de Respuesta:**
    ```json
    [
        {
            "id": 1,
            "nombre": "Ladrillo Rojo",
            "precio": 0.50
        },
        {
            "id": 2,
            "nombre": "Ladrillo Blanco",
            "precio": 0.60
        }
    ]
    ```

### 2. Obtener un producto por ID
- **Ruta:** `/api/productos/{id}`
- **Método:** `GET`
- **Descripción:** Obtiene los detalles de un producto específico por su ID.
- **Ejemplo de Solicitud:**
    ```http
    GET /api/productos/1 HTTP/1.1
    Host: example.com
    ```
- **Ejemplo de Respuesta:**
    ```json
    {
        "id": 1,
        "nombre": "Ladrillo Rojo",
        "precio": 0.50
    }
    ```

### 3. Crear un nuevo producto
- **Ruta:** `/api/productos`
- **Método:** `POST`
- **Descripción:** Crea un nuevo producto en la base de datos.
- **Ejemplo de Solicitud:**
    ```http
    POST /api/productos HTTP/1.1
    Host: example.com
    Content-Type: application/json

    {
        "nombre": "Ladrillo Verde",
        "precio": 0.55
    }
    ```
- **Ejemplo de Respuesta:**
    ```json
    {
        "id": 3,
        "nombre": "Ladrillo Verde",
        "precio": 0.55
    }
    ```

### 4. Actualizar un producto
- **Ruta:** `/api/productos/{id}`
- **Método:** `PUT`
- **Descripción:** Actualiza los detalles de un producto existente.
- **Ejemplo de Solicitud:**
    ```http
    PUT /api/productos/1 HTTP/1.1
    Host: example.com
    Content-Type: application/json

    {
        "nombre": "Ladrillo Rojo Mejorado",
        "precio": 0.55
    }
    ```
- **Ejemplo de Respuesta:**
    ```json
    {
        "id": 1,
        "nombre": "Ladrillo Rojo Mejorado",
        "precio": 0.55
    }
    ```

### 5. Eliminar un producto
- **Ruta:** `/api/productos/{id}`
- **Método:** `DELETE`
- **Descripción:** Elimina un producto de la base de datos.
- **Ejemplo de Solicitud:**
    ```http
    DELETE /api/productos/1 HTTP/1.1
    Host: example.com
    ```
- **Ejemplo de Respuesta:**
    ```json
    {
        "mensaje": "Producto eliminado exitosamente"
    }
    ```

## Conclusión
Esta documentación cubre los principales endpoints de la API. Para más detalles, consulte la documentación completa o contacte al equipo de soporte.

```