package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Internet;

public interface InternetRepository extends JpaRepository<Internet, Integer> {
    
    @Query(value = "SELECT * FROM internet", nativeQuery = true)
    Collection<Internet> darInternets();

    @Query(value = "SELECT * FROM internet WHERE servicios_id = :servicios_id", nativeQuery = true)
    Internet darInternet(@Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO internet (capacidad, servicios_id) VALUES(:capacidad, :servicios_id)", nativeQuery = true)
    Void insertarInternet(@Param("capacidad") int capacidad, @Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE internet SET capacidad = :capacidad WHERE servicios_id = :servicios_id", nativeQuery = true)
    Void actualizarInternet(@Param("capacidad") int capacidad, @Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM internet WHERE servicios_id = :servicios_id", nativeQuery = true)
    void eliminarInternet(@Param("servicios_id") int servicios_id);
}
