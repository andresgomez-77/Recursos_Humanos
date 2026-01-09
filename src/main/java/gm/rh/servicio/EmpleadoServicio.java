package gm.rh.servicio;

import java.util.List;

import gm.rh.modelo.Empleado;

public interface EmpleadoServicio {

    List<Empleado> listarEmpleados();

    Empleado buscarEmpleadoPorId(Long idEmpleado);

    Empleado guardarEmpleado(Empleado empleado);

    Empleado actualizarEmpleado(Empleado empleado);

    void eliminarEmpleado(Long idEmpleado);
}
