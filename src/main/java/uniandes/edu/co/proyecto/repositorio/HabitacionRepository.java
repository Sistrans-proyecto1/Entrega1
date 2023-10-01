package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer>{
    
    @Query(value = "SELECT * FROM habitaciones", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();

    @Query(value = "SELECT * FROM habitaciones WHERE ubicación = :ubicacion AND hoteles_id = :hoteles_id", nativeQuery = true)
    Habitacion darHabitacion(@Param("ubicacion") int ubicacion, @Param("hoteles_id") int hoteles_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (ubicación, television, minibar, comedor, jacuzzi, cafetera, cocina, precio, hoteles_id, tiposhabitación_id) VALUES(:ubicacion, :television, :minibar, :comedor, :jacuzzi, :cafetera, :cocina, :precio, :hoteles_id, :tiposhabitación_id)", nativeQuery = true)
    Void insertarHabitacion(@Param("ubicacion") int ubicacion, @Param("television") boolean television, @Param("minibar") boolean minibar, @Param("comedor") boolean comedor, @Param("jacuzzi") boolean jacuzzi, @Param("cafetera") boolean cafetera, @Param("cocina") boolean cocina, @Param("precio") int precio, @Param("hoteles_id") int hoteles_id, @Param("tiposhabitación_id") int tiposhabitación_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET television = :television, minibar = :minibar, comedor = :comedor, jacuzzi = :jacuzzi, cafetera = :cafetera, cocina = :cocina, precio = :precio, tiposhabitación_id = :tiposhabitación_id WHERE ubicación = :ubicacion AND hoteles_id = :hoteles_id", nativeQuery = true)
    Void actualizarHabitacion(@Param("ubicacion") int ubicacion, @Param("television") boolean television, @Param("minibar") boolean minibar, @Param("comedor") boolean comedor, @Param("jacuzzi") boolean jacuzzi, @Param("cafetera") boolean cafetera, @Param("cocina") boolean cocina, @Param("precio") int precio, @Param("hoteles_id") int hoteles_id, @Param("tiposhabitación_id") int tiposhabitación_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE ubicación = :ubicacion AND hoteles_id = :hoteles_id", nativeQuery = true)
    void eliminarHabitacion(@Param("ubicacion") int ubicacion, @Param("hoteles_id") int hoteles_id);
}
