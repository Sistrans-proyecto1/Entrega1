package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="planes")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private int costo;
    @ManyToOne
    @JoinColumn(name="hoteles_id", referencedColumnName = "id")
    private Hotel hoteles_id;
    public Plan(String nombre, int costo, Hotel hotelid) {
        this.nombre = nombre;
        this.costo = costo;
        this.hoteles_id = hotelid;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCosto() {
        return costo;
    }
    public void setCosto(int costo) {
        this.costo = costo;
    }
    public Hotel getHotelid() {
        return hoteles_id;
    }
    public void setHotelid(Hotel hotelid) {
        this.hoteles_id = hotelid;
    }
}
