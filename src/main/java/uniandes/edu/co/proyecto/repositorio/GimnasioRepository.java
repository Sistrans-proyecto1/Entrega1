package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Gimnasio;

public interface GimnasioRepository extends JpaRepository<Gimnasio, Integer> {

    @Query(value = "SELECT * FROM gimnasios", nativeQuery = true)
    Collection<Gimnasio> darGimnasios();

    @Query(value = "SELECT * FROM gimnasios WHERE servicios_id = :servicios_id", nativeQuery = true)
    Gimnasio darGimnasio(@Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gimnasios (nombre, capacidad, horario, servicios_id) VALUES(:nombre, :capacidad, :horario, :servicios_id)", nativeQuery = true)
    Void insertarGimnasio(@Param("nombre") String nombre, @Param("capacidad") int capacidad, @Param("horario") String horario, @Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE gimnasios SET nombre = :nombre, capacidad = :capacidad, horario = :horario WHERE servicios_id = :servicios_id", nativeQuery = true)
    Void actualizarGimnasio(@Param("nombre") String nombre, @Param("capacidad") int capacidad, @Param("horario") String horario, @Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gimnasios WHERE servicios_id = :servicios_id", nativeQuery = true)
    void eliminarGimnasio(@Param("servicios_id") int servicios_id);
}
