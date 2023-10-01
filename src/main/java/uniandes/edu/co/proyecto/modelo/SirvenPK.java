package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class SirvenPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="servicios_id", referencedColumnName = "id")
    private ServicioProducto serviciosProductos_servicios_id;

    @ManyToOne
    @JoinColumn(name="productos_id", referencedColumnName = "id")
    private Producto productos_id;

    public SirvenPK(ServicioProducto serviciosProductos_servicios_id, Producto productos_id) {
        this.serviciosProductos_servicios_id = serviciosProductos_servicios_id;
        this.productos_id = productos_id;
    }

    public ServicioProducto getServiciosProductos_servicios_id() {
        return serviciosProductos_servicios_id;
    }

    public void setServiciosProductos_servicios_id(ServicioProducto serviciosProductos_servicios_id) {
        this.serviciosProductos_servicios_id = serviciosProductos_servicios_id;
    }

    public Producto getProductos_id() {
        return productos_id;
    }

    public void setProductos_id(Producto productos_id) {
        this.productos_id = productos_id;
    }
    
}
