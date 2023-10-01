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
    private int ubicacion;
    private boolean television;
    private boolean minibar;
    private boolean comedor;
    private boolean jacuzzi;
    private boolean cafetera;
    private boolean cocina;
    private int precio;
    @ManyToOne
    @JoinColumn(name="hoteles", referencedColumnName="id")
    private Hotel hotelid;
    @ManyToOne
    @JoinColumn(name="tiposhabitación", referencedColumnName = "id")
    private TipoHabitacion tipoHabitacion;
    
    public Habitacion(int ubicacion, boolean television, boolean minibar, boolean comedor, boolean jacuzzi,
            boolean cafetera, boolean cocina, int precio, Hotel hotelid, TipoHabitacion tipoHabitacion) {
        this.ubicacion = ubicacion;
        this.television = television;
        this.minibar = minibar;
        this.comedor = comedor;
        this.jacuzzi = jacuzzi;
        this.cafetera = cafetera;
        this.cocina = cocina;
        this.precio = precio;
        this.hotelid = hotelid;
        this.tipoHabitacion = tipoHabitacion;
    }

    public int Ubicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
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
        return hotelid;
    }

    public void setHotelid(Hotel hotelid) {
        this.hotelid = hotelid;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    
    

}
