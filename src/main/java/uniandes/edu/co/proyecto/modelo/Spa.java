package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="spa")
public class Spa {
    private int duracion;
    @Id
    @OneToOne(mappedBy = "spa")
    @JoinColumn(name="servicios_id", referencedColumnName = "id")
    private Servicio servicios_id;

    public Spa(int duracion, Servicio servicioid) {
        this.duracion = duracion;
        this.servicios_id = servicioid;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public Servicio getServicioid() {
        return servicios_id;
    }
    public void setServicioid(Servicio servicioid) {
        this.servicios_id = servicioid;
    }
    
}
