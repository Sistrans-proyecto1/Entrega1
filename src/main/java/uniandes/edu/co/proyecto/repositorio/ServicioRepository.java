package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    @Query(value = "SELECT * FROM servicios", nativeQuery = true)
    Collection<Servicio> darServicios();

    @Query(value = "SELECT * FROM servicios WHERE id = :id", nativeQuery = true)
    Servicio darServicio(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicios (id, costo, hoteles_id) VALUES(ID_SEQUENCE.nextval, :costo, :hoteles_id)", nativeQuery = true)
    Void insertarServicio(@Param("costo") int costo, @Param("hoteles_id") int hoteles_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicios SET costo = :costo, hoteles_id = :hoteles_id WHERE id = :id", nativeQuery = true)
    Void actualizaServicio(@Param("id") int id, @Param("costo") int costo, @Param("hoteles_id") int hoteles_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicios WHERE id = :id", nativeQuery = true)
    void eliminarServicio(@Param("id") int id);
}
