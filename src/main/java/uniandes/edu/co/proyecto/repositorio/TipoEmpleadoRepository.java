package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoEmpleado;

public interface TipoEmpleadoRepository  extends JpaRepository<TipoEmpleado, Integer>{
    @Query(value = "SELECT * FROM tiposempleado", nativeQuery = true)
    Collection<TipoEmpleado> darTipoEmpleados();

    @Query(value = "SELECT * FROM tiposempleado WHERE id = :id", nativeQuery = true)
    TipoEmpleado darTipoEmpleado(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tiposempleado (id, tipo) VALUES(ID_SEQUENCE.nextval, :tipo)", nativeQuery = true)
    Void insertarTipoEmpleado(@Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tiposempleado SET tipo = :tipo WHERE id = :id", nativeQuery = true)
    Void actualizarTipoEmpleado(@Param("id") int id, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiposempleado WHERE id = :id", nativeQuery = true)
    void eliminarTipoEmpleado(@Param("id") int id);
}
