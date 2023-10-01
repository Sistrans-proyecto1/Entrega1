package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="gimnasios")
public class Gimnasio {
    private String nombre;
    private String capacidad;
    private String horario;
    @Id
    @OneToOne(mappedBy = "gimnasio")
    @JoinColumn(name="servicios_id", referencedColumnName = "id")
    private Servicio servicioid;
    
    public Gimnasio(String nombre, String capacidad, String horario, Servicio servicio) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.horario = horario;
        this.servicioid = servicio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public Servicio getServicio() {
        return servicioid;
    }
    public void setServicio(Servicio servicio) {
        this.servicioid = servicio;
    }
}

