package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="internet")
public class Internet {
    private int capacidad;
    @Id
    @OneToOne(mappedBy = "internet")
    @JoinColumn(name="servicios_id", referencedColumnName = "id")
    private Servicio servicios_id;

    public Internet(int capacidad, Servicio servicioid) {
        this.capacidad = capacidad;
        this.servicios_id = servicioid;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Servicio getServicioid() {
        return servicios_id;
    }

    public void setServicioid(Servicio servicioid) {
        this.servicios_id = servicioid;
    }
    
}
