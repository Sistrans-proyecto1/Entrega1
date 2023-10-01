package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="spa")
public class Spa {
    private int duracion;
    @OneToOne(mappedBy = "spa")
    @JoinColumn(name="servicios", referencedColumnName = "id")
    private Servicio servicioid;
    
    public Spa(int duracion, Servicio servicioid) {
        this.duracion = duracion;
        this.servicioid = servicioid;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public Servicio getServicioid() {
        return servicioid;
    }
    public void setServicioid(Servicio servicioid) {
        this.servicioid = servicioid;
    }
    
}
