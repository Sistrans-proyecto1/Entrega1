package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="maquinas")
public class Maquina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name="gimnasios", referencedColumnName = "id")
    private Gimnasio gimnasioid;
    public Maquina(String nombre, Gimnasio gimnasioid) {
        this.nombre = nombre;
        this.gimnasioid = gimnasioid;
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
    public Gimnasio getGimnasioid() {
        return gimnasioid;
    }
    public void setGimnasioid(Gimnasio gimnasioid) {
        this.gimnasioid = gimnasioid;
    }
    

}
