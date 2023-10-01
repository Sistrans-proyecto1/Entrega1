package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="piscinas")
public class Piscina {
    private int capacidad;
    private double profundidad;
    private Date horario;
    
    @Id
    @OneToOne(mappedBy = "piscina")
    @JoinColumn(name="servicios_id", referencedColumnName = "id")
    private Servicio servicios_id;

    public Piscina(int capacidad, double profundidad, Date horario, Servicio servicioid) {
        this.capacidad = capacidad;
        this.profundidad = profundidad;
        this.horario = horario;
        this.servicios_id = servicioid;
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
        return servicios_id;
    }
    public void setServicioid(Servicio servicioid) {
        this.servicios_id = servicioid;
    }
    
}
