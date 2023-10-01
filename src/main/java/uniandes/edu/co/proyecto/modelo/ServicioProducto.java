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
    private String tipo;
    private String estilo;
    @Id
    @OneToOne(mappedBy = "serviciosproductos")
    @JoinColumn(name="servicios_id", referencedColumnName = "id")
    private Servicio servicios_id;

    public ServicioProducto(String nombre, int capacidad, String tipo, String estilo, Servicio servicioid) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.estilo = estilo;
        this.servicios_id = servicioid;
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
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getEstilo() {
        return estilo;
    }
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
    public Servicio getServicioid() {
        return servicios_id;
    }
    public void setServicioid(Servicio servicioid) {
        this.servicios_id = servicioid;
    }
    
}