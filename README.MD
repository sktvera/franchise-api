Franchise API – Prueba Técnica Backend
API reactiva para la gestión de Franquicias, Sucursales y Productos, desarrollada con Spring Boot + WebFlux + MongoDB, documentada con Swagger/OpenAPI y desplegada con Docker.


Tecnologías
Java 17

Spring Boot 3.4.x

Spring WebFlux (reactivo)

MongoDB (reactivo)

Spring Data MongoDB Reactive

Bean Validation

SpringDoc OpenAPI (Swagger)

Docker & Docker Compose

--------------------
Cómo levantar el proyecto con Docker

mvn clean package

Verifica que exista:
target/franchise-api-0.0.1-SNAPSHOT.jar


Levantar contenedores:
docker-compose up --build


Verificar contenedores
docker ps

-------
Swagger / OpenAPI


Crear sucursal
POST /api/branches
{
"name": "Sucursal Centro",
"franchiseId": "FRANQ_001"
}
--------

Listar sucursales por franquicia
GET /api/branches/franchise/FRANQ_001

 Copia el id de la sucursal
 
--------

Crear producto
POST /api/products

{
"name": "Hamburguesa",
"stock": 10,
"branchId": "ID_DE_LA_SUCURSAL"
}
-------

Listar productos por sucursal
GET /api/products/branch/{branchId}

----

Actualizar stock
PATCH /api/products/{id}/stock
{
"stock": 1073741824
}


----

Eliminar producto
DELETE /api/products/{id}

-----

Producto con mayor stock por sucursal
GET /api/franchises/FRANQ_001/top-products