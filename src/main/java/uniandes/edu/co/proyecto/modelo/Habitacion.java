package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="habitaciones")
public class Habitacion {
    @Id
    private boolean ubicacion;
    
    private boolean television;
    private boolean minibar;
    private boolean comedor;
    private boolean jacuzzi;
    private boolean cafetera;
    private boolean cocina;
    private int precio;

    @Id
    @ManyToOne
    @JoinColumn(name="hoteles_id", referencedColumnName="id")
    private Hotel hoteles_id;

    @ManyToOne
    @JoinColumn(name="tiposhabitación_id", referencedColumnName = "id")
    private TipoHabitacion tiposhabitacion_id;
    
    public Habitacion(boolean ubicacion, boolean television, boolean minibar, boolean comedor, boolean jacuzzi,
            boolean cafetera, boolean cocina, int precio, Hotel hotelid, TipoHabitacion tipoHabitacion) {
        this.ubicacion = ubicacion;
        this.television = television;
        this.minibar = minibar;
        this.comedor = comedor;
        this.jacuzzi = jacuzzi;
        this.cafetera = cafetera;
        this.cocina = cocina;
        this.precio = precio;
        this.hoteles_id = hotelid;
        this.tiposhabitacion_id = tipoHabitacion;
    }

    public boolean isUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(boolean ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isTelevision() {
        return television;
    }

    public void setTelevision(boolean television) {
        this.television = television;
    }

    public boolean isMinibar() {
        return minibar;
    }

    public void setMinibar(boolean minibar) {
        this.minibar = minibar;
    }

    public boolean isComedor() {
        return comedor;
    }

    public void setComedor(boolean comedor) {
        this.comedor = comedor;
    }

    public boolean isJacuzzi() {
        return jacuzzi;
    }

    public void setJacuzzi(boolean jacuzzi) {
        this.jacuzzi = jacuzzi;
    }

    public boolean isCafetera() {
        return cafetera;
    }

    public void setCafetera(boolean cafetera) {
        this.cafetera = cafetera;
    }

    public boolean isCocina() {
        return cocina;
    }

    public void setCocina(boolean cocina) {
        this.cocina = cocina;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Hotel getHotelid() {
        return hoteles_id;
    }

    public void setHotelid(Hotel hotelid) {
        this.hoteles_id = hotelid;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tiposhabitacion_id;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tiposhabitacion_id = tipoHabitacion;
    }

    
    

}
