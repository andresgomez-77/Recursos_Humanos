package gm.rh.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gm.rh.modelo.Empleado;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {

    // 🔹 Buscar empleados por departamento
    List<Empleado> findByDepartamento(String departamento);

    // 🔹 Buscar empleados cuyo nombre contenga un texto
    List<Empleado> findByNombreContaining(String nombre);

    // 🔹 Buscar empleados con sueldo mayor a un valor
    List<Empleado> findBySueldoGreaterThan(Double sueldo);
}
