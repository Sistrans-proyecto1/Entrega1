package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="hoteles")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String ciudad;
    private String pais;
    @ManyToOne
    @JoinColumn(name = "cadenashoteles_id", referencedColumnName = "id")
    private CadenaHoteles cadenaHoteles_id;

    public Hotel(String nombre, String ciudad, String pais, CadenaHoteles cadenaHotelesid) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.cadenaHoteles_id = cadenaHotelesid;
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
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public CadenaHoteles getCadenaHotelesid() {
        return cadenaHoteles_id;
    }
    public void setCadenaHotelesid(CadenaHoteles cadenaHotelesid) {
        this.cadenaHoteles_id = cadenaHotelesid;
    }

    

}
