package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="serviciossimples")
public class ServicioSimple {
    private String tipo;
    @Id
    @OneToOne(mappedBy = "serviciossimples")
    @JoinColumn(name="servicios_id", referencedColumnName = "id")
    private Servicio servicios_id;

    public ServicioSimple(String tipo, Servicio servicioid) {
        this.tipo = tipo;
        this.servicios_id = servicioid;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Servicio getServicioid() {
        return servicios_id;
    }
    public void setServicioid(Servicio servicioid) {
        this.servicios_id = servicioid;
    }
    
}
