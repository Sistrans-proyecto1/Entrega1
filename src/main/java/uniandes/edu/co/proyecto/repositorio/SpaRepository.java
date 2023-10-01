package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Spa;

public interface SpaRepository extends JpaRepository<Spa, Integer> {
    @Query(value = "SELECT * FROM SPA", nativeQuery = true)
    Collection<Spa> darSpas();

    @Query(value = "SELECT * FROM SPA WHERE servicios_id = :servicios_id", nativeQuery = true)
    Spa darSpa(@Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO SPA (duracion, servicios_id) VALUES(:duracion, :servicios_id)", nativeQuery = true)
    Void insertarSpa(@Param("duracion") int duracion, @Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE SPA SET duracion = :duracion WHERE servicios_id = :servicios_id", nativeQuery = true)
    Void actualizarSpa(@Param("duracion") int duracion, @Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM SPA WHERE servicios_id = :servicios_id", nativeQuery = true)
    void eliminarServicioProducto(@Param("servicios_id") int servicios_id);
}
