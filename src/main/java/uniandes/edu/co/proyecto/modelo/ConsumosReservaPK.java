package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ConsumosReservaPK implements Serializable{

    @ManyToOne
    @JoinColumn(name="reservas_id", referencedColumnName = "id")
    private Reserva reservas_id;

    @ManyToOne
    @JoinColumn(name="servicios_id", referencedColumnName = "id")
    private Servicio servicios_id;

    public ConsumosReservaPK(Reserva reservas_id, Servicio servicios_id) {
        this.reservas_id = reservas_id;
        this.servicios_id = servicios_id;
    }

    public Reserva getReservas_id() {
        return reservas_id;
    }

    public void setReservas_id(Reserva reservas_id) {
        this.reservas_id = reservas_id;
    }

    public Servicio getServicios_id() {
        return servicios_id;
    }

    public void setServicios_id(Servicio servicios_id) {
        this.servicios_id = servicios_id;
    }

    
}
