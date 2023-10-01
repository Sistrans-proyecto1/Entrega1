package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="consumosreserva")
public class ConsumosReserva {
    @EmbeddedId
    private ConsumosReservaPK pk;

    public ConsumosReserva(ConsumosReservaPK pk) {
        this.pk = pk;
    }

    public ConsumosReservaPK getPk() {
        return pk;
    }

    public void setPk(ConsumosReservaPK pk) {
        this.pk = pk;
    }
    
}
