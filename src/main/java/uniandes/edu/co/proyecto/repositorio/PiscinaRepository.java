package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Piscina;

public interface PiscinaRepository extends JpaRepository<Piscina, Integer> {
    @Query(value = "SELECT * FROM piscinas", nativeQuery = true)
    Collection<Piscina> darPiscinas();

    @Query(value = "SELECT * FROM piscinas WHERE servicios_id = :servicios_id", nativeQuery = true)
    Piscina darPiscina(@Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO piscinas (capacidad, horario, profundidad, servicios_id) VALUES(:capacidad, :horario, :profundidad, :servicios_id)", nativeQuery = true)
    Void insertarPiscina(@Param("capacidad") int capacidad, @Param("horario") String horario, @Param("profundidad") Long profundidad, @Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE piscinas SET capacidad = :capacidad, horario = :horario, profundidad = :profundidad WHERE servicios_id = :servicios_id", nativeQuery = true)
    Void actualizarPiscina(@Param("capacidad") int capacidad, @Param("horario") String horario, @Param("profundidad") Long profundidad, @Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM piscinas WHERE servicios_id = :servicios_id", nativeQuery = true)
    void eliminarPiscina(@Param("servicios_id") int servicios_id);
}
