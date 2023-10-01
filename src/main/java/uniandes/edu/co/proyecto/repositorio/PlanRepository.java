package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

    @Query(value = "SELECT * FROM planes", nativeQuery = true)
    Collection<Plan> darPlanes();

    @Query(value = "SELECT * FROM planes WHERE id = :id", nativeQuery = true)
    Plan darPlan(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO planes (id, nombre, costo, hoteles_id) VALUES(ID_SEQUENCE.nextval, :nombre, :costo, :hoteles_id)", nativeQuery = true)
    Void insertarPlan(@Param("nombre") String nombre, @Param("costo") int costo, @Param("hoteles_id") int hoteles_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE planes SET nombre = :nombre, costo = :costo, hoteles_id = :hoteles_id WHERE id = :id", nativeQuery = true)
    Void actualizaPlan(@Param("id") int id, @Param("nombre") String nombre, @Param("costo") int costo, @Param("hoteles_id") int hoteles_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planes WHERE id = :id", nativeQuery = true)
    void eliminarPlan(@Param("id") int id);
}
