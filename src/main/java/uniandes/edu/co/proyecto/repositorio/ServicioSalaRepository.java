package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ServicioSala;

public interface ServicioSalaRepository extends JpaRepository<ServicioSala, Integer>{
    @Query(value = "SELECT * FROM serviciossalas", nativeQuery = true)
    Collection<ServicioSala> darServicioSalas();

    @Query(value = "SELECT * FROM serviciossalas WHERE servicios_id = :servicios_id", nativeQuery = true)
    ServicioSala darServicioSala(@Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO serviciossalas (nombre, capacidad, tiempolimpieza, servicios_id) VALUES(:nombre, :capacidad, :tiempolimpieza, :servicios_id)", nativeQuery = true)
    Void insertarServicioSala(@Param("nombre") String nombre, @Param("capacidad") int capacidad, @Param("tiempolimpieza") int tiempolimpieza, @Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE serviciossalas SET nombre = :nombre, capacidad = :capacidad, tiempolimpieza = :tiempolimpieza WHERE servicios_id = :servicios_id", nativeQuery = true)
    Void actualizarServicioSala(@Param("nombre") String nombre, @Param("capacidad") int capacidad, @Param("tipo") String tipo, @Param("estilo") String estilo, @Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM serviciossalas WHERE servicios_id = :servicios_id", nativeQuery = true)
    void eliminarServicioSala(@Param("servicios_id") int servicios_id);
}
