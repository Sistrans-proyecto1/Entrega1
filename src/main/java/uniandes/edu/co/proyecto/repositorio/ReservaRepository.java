package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query(value = "SELECT * FROM reservas", nativeQuery = true)
    Collection<Reserva> darReservas();

    @Query(value = "SELECT * FROM reservas WHERE id = :id", nativeQuery = true)
    Reserva darReserva(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservas (id, nombre, fechainicial, fechafinal, numeropersonas, habitaciones_ubicación, clientes_id, planes_id, habitaciones_hoteles_id) VALUES(ID_SEQUENCE.nextval, :nombre, :fechainicial, :fechafinal, :numeropersonas, :habitaciones_ubicación, :clientes_id, :planes_id, :habitaciones_hoteles_id)", nativeQuery = true)
    Void insertarReserva(@Param("nombre") String nombre, @Param("fechainicial") Date fechainicial, @Param("fechafinal") Date fechafinal, @Param("numeropersonas") int numeropersonas, @Param("habitaciones_ubicación") int habitaciones_ubicación, @Param("clientes_id") int clientes_id, @Param("planes_id") int planes_id, @Param("habitaciones_hoteles_id") int habitaciones_hoteles_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas SET nombre = :nombre, fechainicial = :fechainicial, fechafinal =: fechafinal, numeropersonas = :numeropersonas, habitaciones_ubicación = :habitaciones_ubicación, clientes_id = :clientes_id, planes_id = :planes_id, habitaciones_hoteles_id = :habitaciones_hoteles_id WHERE id = :id", nativeQuery = true)
    Void actualizaReserva(@Param("id") int id, @Param("nombre") String nombre, @Param("fechainicial") Date fechainicial, @Param("fechafinal") Date fechafinal, @Param("numeropersonas") int numeropersonas, @Param("habitaciones_ubicación") int habitaciones_ubicación, @Param("clientes_id") int clientes_id, @Param("planes_id") int planes_id, @Param("habitaciones_hoteles_id") int habitaciones_hoteles_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservas WHERE id = :id", nativeQuery = true)
    void eliminarReserva(@Param("id") int id);
}
