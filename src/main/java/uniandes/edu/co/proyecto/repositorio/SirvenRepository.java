package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Sirven;

public interface SirvenRepository extends JpaRepository<Sirven, Integer> {
    
    @Query(value = "SELECT * FROM sirven", nativeQuery = true)
    Collection<Sirven> darSirvens();

    @Query(value = "SELECT * FROM sirven WHERE serviciosproductos_id = :serviciosproductos_id AND productos_id = :productos_id", nativeQuery = true)
    Sirven darSirven(@Param("serviciosproductos_id") int serviciosproductos_id, @Param("productos_id") int productos_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sirven (serviciosproductos_id, productos_id) VALUES(:serviciosproductos_id, :productos_id)", nativeQuery = true)
    Void insertarSirven(@Param("serviciosproductos_id") int serviciosproductos_id, @Param("productos_id") int productos_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM sirven WHERE serviciosproductos_id = :serviciosproductos_id AND productos_id = :productos_id", nativeQuery = true)
    void eliminarSirven(@Param("serviciosproductos_id") int serviciosproductos_id, @Param("productos_id") int productos_id);
    
}
