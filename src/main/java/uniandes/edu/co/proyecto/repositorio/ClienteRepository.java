package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Hotel;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    @Query(value = "SELECT * FROM clientes", nativeQuery = true)
    Collection<Cliente> darClientes();

    @Query(value = "SELECT * FROM clientes WHERE id = :id", nativeQuery = true)
    Cliente darCliente(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO clientes (id, nombre, edad, correo, teléfono, hoteles_id) VALUES(ID_SEQUENCE.nextval, :nombre, :edad, :correo, :telefono, :hoteles_id)", nativeQuery = true)
    Void insertarCliente(@Param("nombre") String nombre, @Param("edad") int edad, @Param("correo") String correo, @Param("telefono") int telefono, @Param("hoteles_id") Hotel hoteles_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE clientes SET nombre = :nombre, edad = :edad, correo = :correo, teléfono = :telefono, hoteles_id = :hoteles_id WHERE id = :id", nativeQuery = true)
    Void actualizarCliente(@Param("id") int id, @Param("nombre") String nombre, @Param("edad") int edad, @Param("correo") String correo, @Param("telefono") int telefono, @Param("hoteles_id") Hotel hoteles_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM clientes WHERE id = :id", nativeQuery = true)
    void eliminarCliente(@Param("id") int id);
}
