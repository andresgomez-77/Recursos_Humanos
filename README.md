# API Recursos Humanos – Spring Boot

API REST para la gestión de empleados (CRUD), desarrollada con Spring Boot, JPA y MySQL.

Proyecto desarrollado con fines educativos, basado en el curso de **GlobalMentoring**.

---

## 🚀 Tecnologías
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

---

## 📌 Endpoints principales

Base URL:
```

[http://localhost:8080/api/empleados](http://localhost:8080/api/empleados)

````

| Método | Endpoint | Descripción |
|------|---------|-------------|
| GET | /api/empleados | Listar empleados |
| POST | /api/empleados | Crear empleado |
| PUT | /api/empleados/{id} | Actualizar empleado |
| DELETE | /api/empleados/{id} | Eliminar empleado |

---

## ⚙️ Configuración

Crear base de datos:

```sql
CREATE DATABASE recursos_humanos_db;
````

Configurar `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/recursos_humanos_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
```

---

## 🎓 Créditos

Proyecto desarrollado siguiendo el curso de **GlobalMentoring**.

---

## ✨ Autor

Andrés Felipe Gómez

````
🎨 Frontend del proyecto:
https://github.com/andresgomez-77/sistema-recursos-humanos-app.git

