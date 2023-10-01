package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="piscinas")
public class Piscina {
    private int capacidad;
    private double profundidad;
    private Date horario;
    @OneToOne(mappedBy = "piscina")
    @JoinColumn(name="servicios", referencedColumnName = "id")
    private Servicio servicioid;
    
    public Piscina(int capacidad, double profundidad, Date horario, Servicio servicioid) {
        this.capacidad = capacidad;
        this.profundidad = profundidad;
        this.horario = horario;
        this.servicioid = servicioid;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public double getProfundidad() {
        return profundidad;
    }
    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }
    public Date getHorario() {
        return horario;
    }
    public void setHorario(Date horario) {
        this.horario = horario;
    }
    public Servicio getServicioid() {
        return servicioid;
    }
    public void setServicioid(Servicio servicioid) {
        this.servicioid = servicioid;
    }
    
}
