package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="serviciossimples")
public class ServicioSimple {
    private String tipo;
    @OneToOne(mappedBy = "serviciossimples")
    @JoinColumn(name="servicios", referencedColumnName = "id")
    private Servicio servicioid;
    
    public ServicioSimple(String tipo, Servicio servicioid) {
        this.tipo = tipo;
        this.servicioid = servicioid;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Servicio getServicioid() {
        return servicioid;
    }
    public void setServicioid(Servicio servicioid) {
        this.servicioid = servicioid;
    }
    
}
