package gm.rh.controlador;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gm.rh.modelo.Empleado;
import gm.rh.servicio.EmpleadoServicio;

@RestController
@RequestMapping("/api/empleados")
@CrossOrigin(origins = "*")
public class EmpleadoControlador {

    private final EmpleadoServicio empleadoServicio;

    public EmpleadoControlador(EmpleadoServicio empleadoServicio) {
        this.empleadoServicio = empleadoServicio;
    }

    // 🔹 LISTAR TODOS LOS EMPLEADOS
    @GetMapping
    public ResponseEntity<List<Empleado>> listarEmpleados() {
        List<Empleado> empleados = empleadoServicio.listarEmpleados();

        if (empleados.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204
        }

        return ResponseEntity.ok(empleados); // 200
    }

    // 🔹 BUSCAR EMPLEADO POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id) {
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);

        if (empleado == null) {
            return ResponseEntity.notFound().build(); // 404
        }

        return ResponseEntity.ok(empleado); // 200
    }

    // 🔹 GUARDAR NUEVO EMPLEADO
    @PostMapping
    public ResponseEntity<Empleado> guardarEmpleado(@RequestBody Empleado empleado) {
        // Ignorar el id si se proporciona en el cuerpo de la solicitud
        empleado.setIdEmpleado(null);
        Empleado nuevoEmpleado = empleadoServicio.guardarEmpleado(empleado);
        URI ubicacion = URI.create(String.format("/api/empleados/%s", nuevoEmpleado.getIdEmpleado()));
        return ResponseEntity.created(ubicacion).body(nuevoEmpleado); // 201
    }

    // 🔹 ACTUALIZAR EMPLEADO
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(
            @PathVariable Long id,
            @RequestBody Empleado empleado) {

        Empleado empleadoExistente = empleadoServicio.buscarEmpleadoPorId(id);

        if (empleadoExistente == null) {
            return ResponseEntity.notFound().build(); // 404
        }
        // Forzamos el id del empleado a actualizar
        empleado.setIdEmpleado(id);
        Empleado empleadoActualizado = empleadoServicio.actualizarEmpleado(empleado);

        return ResponseEntity.ok(empleadoActualizado); // 200
    }

    // 🔹 ELIMINAR EMPLEADO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id) {
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);

        if (empleado == null) {
            return ResponseEntity.notFound().build(); // 404
        }

        empleadoServicio.eliminarEmpleado(id);
        return ResponseEntity.noContent().build(); // 204
    }
}
