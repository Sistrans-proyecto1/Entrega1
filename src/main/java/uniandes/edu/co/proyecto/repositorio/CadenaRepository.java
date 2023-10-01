package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.CadenaHoteles;

public interface CadenaRepository extends JpaRepository<CadenaHoteles, Integer>{
    
    @Query(value = "SELECT * FROM cadenashoteles", nativeQuery = true)
    Collection<CadenaHoteles> darCadenas();

    @Query(value = "SELECT * FROM cadenashoteles WHERE id = :id", nativeQuery = true)
    CadenaHoteles darCadena(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cadenashoteles (id, nombre) VALUES(ID_SEQUENCE.nextval, :nombre)", nativeQuery = true)
    Void insertarCadena(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cadenashoteles SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    Void actualizarCadena(@Param("id") int id, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cadenashoteles WHERE id = :id", nativeQuery = true)
    void eliminarCadena(@Param("id") int id);
}
