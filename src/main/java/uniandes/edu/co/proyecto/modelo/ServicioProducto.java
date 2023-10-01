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
    @OneToOne
    @JoinColumn(name="servicios_id", referencedColumnName = "id")
    private Servicio servicios_id;
    public ServicioProducto(String nombre, int capacidad, int tipo, String estilo, Servicio servicios_id) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.estilo = estilo;
        this.servicios_id = servicios_id;
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
    public Servicio getServicios_id() {
        return servicios_id;
    }
    public void setServicios_id(Servicio servicios_id) {
        this.servicios_id = servicios_id;
    }

    
    
}