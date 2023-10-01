package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private int edad;
    private String correo;
    private int telefono;
    @ManyToOne
    @JoinColumn(name = "hoteles_id", referencedColumnName = "id")
    private Hotel hoteles_id;

    public Cliente(String nombre, int edad, String correo, int telefono, Hotel iDhotel) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.hoteles_id = iDhotel;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Hotel getIDhotel() {
        return hoteles_id;
    }

    public void setIDhotel(Hotel iDhotel) {
        this.hoteles_id = iDhotel;
    }
    

    
}
