package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="serviciossalas")
public class ServicioSala {
    private String nombre;
    private int capacidad;
    private int tiempoLimpieza;
    @Id
    @OneToOne
    @JoinColumn(name="servicios_id", referencedColumnName = "id")
    private Servicio servicios_id;

    public ServicioSala(String nombre, int capacidad, int tiempoLimpieza, Servicio servicioid) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tiempoLimpieza = tiempoLimpieza;
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
    public int getTiempoLimpieza() {
        return tiempoLimpieza;
    }
    public void setTiempoLimpieza(int tiempoLimpieza) {
        this.tiempoLimpieza = tiempoLimpieza;
    }
    public Servicio getServicioid() {
        return servicios_id;
    }
    public void setServicioid(Servicio servicioid) {
        this.servicios_id = servicioid;
    }
    
}
