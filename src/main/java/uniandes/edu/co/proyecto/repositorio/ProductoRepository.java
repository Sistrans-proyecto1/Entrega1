package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

    @Query(value = "SELECT * FROM productos", nativeQuery = true)
    Collection<Producto> darProductos();

    @Query(value = "SELECT * FROM productos WHERE id = :id", nativeQuery = true)
    Producto darProducto(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos (nombre, precio) VALUES(ID_SEQUENCE.nextval, :nombre, :precio)", nativeQuery = true)
    Void insertarProducto(@Param("nombre") String nombre, @Param("precio") int precio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET nombre = :nombre, precio = :precio WHERE id = :id", nativeQuery = true)
    Void actualizarProducto(@Param("id") int id, @Param("nombre") String nombre, @Param("precio") int precio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productos WHERE id = :id", nativeQuery = true)
    void eliminarMaquina(@Param("id") int id);
    
}
