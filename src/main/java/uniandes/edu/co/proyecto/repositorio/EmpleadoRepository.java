package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    @Query(value = "SELECT * FROM empleados", nativeQuery = true)
    Collection<Empleado> darEmpleados();

    @Query(value = "SELECT * FROM empleados WHERE id = :id", nativeQuery = true)
    Empleado darEmpleado(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO empleados (id, nombre, edad, correo, teléfono, hoteles_id, tiposempleado_id) VALUES(ID_SEQUENCE.nextval, :nombre, :edad, :correo, :telefono, :hoteles_id, :tiposempleado_id)", nativeQuery = true)
    Void insertarEmpleado(@Param("nombre") String nombre, @Param("edad") int edad, @Param("correo") String correo, @Param("telefono") int telefono, @Param("hoteles_id") int hoteles_id, @Param("tiposempleado_id") int tiposempleado_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE empleados SET nombre = :nombre, edad = :edad, correo = :correo, teléfono = :telefono, hoteles_id = :hoteles_id, tiposempleado_id = :tiposempleado_id WHERE id = :id", nativeQuery = true)
    Void actualizarEmpleado(@Param("id") int id, @Param("nombre") String nombre, @Param("edad") int edad, @Param("correo") String correo, @Param("telefono") int telefono, @Param("hoteles_id") int hoteles_id, @Param("tiposempleado_id") int tiposempleado_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM empleados WHERE id = :id", nativeQuery = true)
    void eliminarEmpleado(@Param("id") int id);
    
}
