package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date fechaInicial;
    private Date fechaFinal;
    private int numeroPersonas;

    @ManyToOne
    @JoinColumn(name="habitaciones_ubicacion", referencedColumnName = "ubicacion")
    private Habitacion habitaciones_ubicacion;

    @ManyToOne
    @JoinColumn(name="planes_id", referencedColumnName = "id")
    private Plan planid;

    @ManyToOne
    @JoinColumn(name="clientes_id", referencedColumnName = "id")
    private Cliente clientes_id;

    @ManyToOne
    @JoinColumn(name="habitaciones_hoteles_id", referencedColumnName = "hoteles_id")
    private Habitacion habitaciones_hoteles_id;

    public Reserva(Date fechaInicial, Date fechaFinal, int numeroPersonas, Habitacion habitaciones_ubicacion,
            Plan planid, Cliente clientes_id, Habitacion habitaciones_hoteles_id) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.numeroPersonas = numeroPersonas;
        this.habitaciones_ubicacion = habitaciones_ubicacion;
        this.planid = planid;
        this.clientes_id = clientes_id;
        this.habitaciones_hoteles_id = habitaciones_hoteles_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public Habitacion getHabitaciones_ubicacion() {
        return habitaciones_ubicacion;
    }

    public void setHabitaciones_ubicacion(Habitacion habitaciones_ubicacion) {
        this.habitaciones_ubicacion = habitaciones_ubicacion;
    }

    public Plan getPlanid() {
        return planid;
    }

    public void setPlanid(Plan planid) {
        this.planid = planid;
    }

    public Cliente getClientes_id() {
        return clientes_id;
    }

    public void setClientes_id(Cliente clientes_id) {
        this.clientes_id = clientes_id;
    }

    public Habitacion getHabitaciones_hoteles_id() {
        return habitaciones_hoteles_id;
    }

    public void setHabitaciones_hoteles_id(Habitacion habitaciones_hoteles_id) {
        this.habitaciones_hoteles_id = habitaciones_hoteles_id;
    }


    
}
