package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Maquina;

public interface MaquinaRepository extends JpaRepository<Maquina, Integer> {

    @Query(value = "SELECT * FROM maquinas", nativeQuery = true)
    Collection<Maquina> darMaquinas();

    @Query(value = "SELECT * FROM maquinas WHERE id = :id", nativeQuery = true)
    Maquina darMaquina(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO maquinas (nombre, gimnasio_servicios_id) VALUES(ID_SEQUENCE.nextval, :nombre, :gimnasio_servicios_id)", nativeQuery = true)
    Void insertarMaquina(@Param("nombre") String nombre, @Param("gimnasio_servicios_id") int gimnasio_servicios_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE maquinas SET nombre = :nombre, gimnasio_servicios_id = :gimnasio_servicios_id WHERE id = :id", nativeQuery = true)
    Void actualizarMaquina(@Param("id") int id, @Param("nombre") String nombre, @Param("gimnasio_servicios_id") int gimnasio_servicios_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM maquinas WHERE id = :id", nativeQuery = true)
    void eliminarMaquina(@Param("id") int id);
}
