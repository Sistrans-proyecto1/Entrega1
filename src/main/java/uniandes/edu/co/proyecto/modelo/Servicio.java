package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name="hoteles_id", referencedColumnName = "id")
    private Hotel hotel_id;

    @OneToOne(mappedBy = "servicioid")
    private Gimnasio gimnasio;
    
    public Servicio(String nombre, Hotel hotelid) {
        this.nombre = nombre;
        this.hotel_id = hotelid;
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
        return hotel_id;
    }
    public void setHotelid(Hotel hotelid) {
        this.hotel_id = hotelid;
    }
    
}
