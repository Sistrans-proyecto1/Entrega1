package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="sirven")
public class Sirven {
    @EmbeddedId
    private SirvenPK pk;

    public Sirven(ServicioProducto serviciosProductos_servicios_id, Producto productos_id) {
        this.pk = new SirvenPK(serviciosProductos_servicios_id, productos_id);
    }

    public SirvenPK getPk() {
        return pk;
    }

    public void setPk(SirvenPK pk) {
        this.pk = pk;
    }

    
}
