package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer> {
    @Query(value = "SELECT * FROM tiposhabitacion", nativeQuery = true)
    Collection<TipoHabitacion> darTipoHabitaciones();

    @Query(value = "SELECT * FROM tiposhabitacion WHERE id = :id", nativeQuery = true)
    TipoHabitacion darTipoHabitacion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tiposhabitacion (id, tipo) VALUES(ID_SEQUENCE.nextval, :tipo)", nativeQuery = true)
    Void insertarTipoHabitacion(@Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tiposhabitacion SET tipo = :tipo WHERE id = :id", nativeQuery = true)
    Void actualizarTipoHabitacion(@Param("id") int id, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiposhabitacion WHERE id = :id", nativeQuery = true)
    void eliminarTipoHabitacion(@Param("id") int id);
}
