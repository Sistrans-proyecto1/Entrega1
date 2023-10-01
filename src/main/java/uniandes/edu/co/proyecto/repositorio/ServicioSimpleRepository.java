package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ServicioSimple;

public interface ServicioSimpleRepository extends JpaRepository<ServicioSimple, Integer> {
    @Query(value = "SELECT * FROM serviciossimples", nativeQuery = true)
    Collection<ServicioSimple> darServicioSimples();

    @Query(value = "SELECT * FROM serviciossimples WHERE servicios_id = :servicios_id", nativeQuery = true)
    ServicioSimple darServicioSimple(@Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO serviciossimples (tipo, servicios_id) VALUES(:tipo, :servicios_id)", nativeQuery = true)
    Void insertarServicioSimple(@Param("tipo") String tipo, @Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE serviciossimples SET tipo = :tipo WHERE servicios_id = :servicios_id", nativeQuery = true)
    Void actualizarServicioSimple(@Param("tipo") String tipo, @Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM serviciossimples WHERE servicios_id = :servicios_id", nativeQuery = true)
    void eliminarServicioSimple(@Param("servicios_id") int servicios_id);
    
}
