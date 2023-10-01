package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name="hoteles", referencedColumnName = "id")
    private Hotel hotelid;
    public Servicio(String nombre, Hotel hotelid) {
        this.nombre = nombre;
        this.hotelid = hotelid;
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
    public Hotel getHotelid() {
        return hotelid;
    }
    public void setHotelid(Hotel hotelid) {
        this.hotelid = hotelid;
    }
    
}
