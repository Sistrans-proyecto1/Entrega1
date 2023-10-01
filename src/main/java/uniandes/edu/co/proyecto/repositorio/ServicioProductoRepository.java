package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ServicioProducto;

public interface ServicioProductoRepository extends JpaRepository<ServicioProducto, Integer> {
    @Query(value = "SELECT * FROM serviciosproductos", nativeQuery = true)
    Collection<ServicioProducto> darServicioProductos();

    @Query(value = "SELECT * FROM serviciosproductos WHERE servicios_id = :servicios_id", nativeQuery = true)
    ServicioProducto darServicioProducto(@Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO serviciosproductos (nombre, capacidad, tipo, estilo, servicios_id) VALUES(:nombre, :capacidad, :tipo, :estilo, :servicios_id)", nativeQuery = true)
    Void insertarServicioProducto(@Param("nombre") String nombre, @Param("capacidad") int capacidad, @Param("tipo") String tipo, @Param("estilo") String estilo, @Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE serviciosproductos SET nombre = :nombre, capacidad = :capacidad, tipo = :tipo, estilo = :estilo WHERE servicios_id = :servicios_id", nativeQuery = true)
    Void actualizarServicioProducto(@Param("nombre") String nombre, @Param("capacidad") int capacidad, @Param("tipo") String tipo, @Param("estilo") String estilo, @Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM serviciosproductos WHERE servicios_id = :servicios_id", nativeQuery = true)
    void eliminarServicioProducto(@Param("servicios_id") int servicios_id);
}
