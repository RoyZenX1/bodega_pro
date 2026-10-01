# BodegaPro - Spring Boot MVC

Proyecto de administración de una bodega desarrollado con Java 25 y Spring Boot 4.1.1.

## Arquitectura MVC

- `model/`: clases Java que representan los objetos.
- `repository/`: almacenamiento en memoria con `ArrayList`; no usa base de datos.
- `service/`: lógica de negocio.
- `controller/`: rutas y comunicación entre View y Service.
- `templates/`: vistas HTML con Thymeleaf y Bootstrap (`fragments/` reutilizables: `head`, `sidebar`, `alertas`).
- `static/css/`: estilos del Front End original.

## Flujo

`View (Thymeleaf) -> Controller -> Service -> Repository (memoria Java) -> Controller -> View`

## Rutas

- `/` Login
- `/dashboard`
- `/inventario`
- `/productos`
- `/ventas`
- `/clientes`
- `/proveedores`
- `/categorias`
- `/reportes`
- `/configuracion`

Los productos tienen un campo opcional **URL de imagen** (`imagenUrl`); se muestra como miniatura en Productos e Inventario.

Búsqueda (CRUD completo): `/productos/buscar`, `/clientes/buscar`, `/proveedores/buscar`, `/categorias/buscar` (parámetro `termino`).

Credenciales: `admin / admin123`

## Persistencia

No hay MySQL, JPA ni Hibernate. Los repositorios usan `ArrayList`. Los cambios se mantienen mientras la aplicación está ejecutándose; al reiniciar, vuelven los datos iniciales.

## Ejecución

Con JDK 25 y Maven (el proyecto incluye Maven Wrapper, así que no necesitas instalar Maven):

```bash
mvn spring-boot:run
```

o en Windows:

```bash
mvnw.cmd spring-boot:run
```
