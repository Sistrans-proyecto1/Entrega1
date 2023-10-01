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
    @JoinColumn(name="habitaciones", referencedColumnName = "ubicacion")
    private Habitacion ubicacion;
    @ManyToOne
    @JoinColumn(name="planes", referencedColumnName = "id")
    private Plan planid;
    public Reserva(Date fechaInicial, Date fechaFinal, int numeroPersonas, Habitacion ubicacion, Plan planid) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.numeroPersonas = numeroPersonas;
        this.ubicacion = ubicacion;
        this.planid = planid;
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
    public Habitacion getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(Habitacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    public Plan getPlanid() {
        return planid;
    }
    public void setPlanid(Plan planid) {
        this.planid = planid;
    }
    
}
