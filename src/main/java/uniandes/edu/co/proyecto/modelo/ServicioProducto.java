package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="serviciosproductos")
public class ServicioProducto {
    private String nombre;
    private int capacidad;
    private int tipo;
    private String estilo;
    @Id
    @OneToOne(mappedBy = "serviciosproductos")
    @JoinColumn(name="id", referencedColumnName = "id")
    private Servicio servicioid;

    public ServicioProducto(String nombre, int capacidad, int tipo, String estilo, Servicio servicioid) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.estilo = estilo;
        this.servicioid = servicioid;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public String getEstilo() {
        return estilo;
    }
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
    public Servicio getServicioid() {
        return servicioid;
    }
    public void setServicioid(Servicio servicioid) {
        this.servicioid = servicioid;
    }
    
}