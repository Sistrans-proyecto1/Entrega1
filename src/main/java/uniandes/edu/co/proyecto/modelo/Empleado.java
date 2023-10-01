package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private int edad;
    private String correo;
    private int telefono;
    @ManyToOne
    @JoinColumn(name="hoteles_id", referencedColumnName = "id")
    private Hotel hoteles_id;
    @ManyToOne
    @JoinColumn(name="tiposempleado_id", referencedColumnName = "id")
    private TipoEmpleado tiposEmpleado_id;

    public Empleado(int id, String nombre, int edad, String correo, int telefono, Hotel hotelid,
            TipoEmpleado tipoEmpleado) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.hoteles_id = hotelid;
        this.tiposEmpleado_id = tipoEmpleado;
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

    public Hotel getHotelid() {
        return hoteles_id;
    }

    public void setHotelid(Hotel hotelid) {
        this.hoteles_id = hotelid;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tiposEmpleado_id;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tiposEmpleado_id = tipoEmpleado;
    }


    
    
}
