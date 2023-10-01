package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    
    @Query(value = "SELECT * FROM hoteles", nativeQuery = true)
    Collection<Hotel> darHoteles();

    @Query(value = "SELECT * FROM hoteles WHERE id = :id", nativeQuery = true)
    Hotel darHotel(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO hoteles (id, nombre, ciudad, pais, cadenahoteles_id) VALUES(ID_SEQUENCE.nextval, :nombre, :ciudad, :pais, :cadenahoteles_id)", nativeQuery = true)
    Void insertarHotel(@Param("nombre") String nombre, @Param("ciudad") int ciudad, @Param("pais") String pais, @Param("cadenahoteles_id") int cadenahoteles_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE hoteles SET nombre = :nombre, capacidad = :capacidad, horario = :horario WHERE id = :id", nativeQuery = true)
    Void actualizarHotel(@Param("id") int id, @Param("nombre") String nombre, @Param("ciudad") int ciudad, @Param("pais") String pais, @Param("servicios_id") int servicios_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hoteles WHERE id = :id", nativeQuery = true)
    void eliminarHotel(@Param("id") int id);
}
