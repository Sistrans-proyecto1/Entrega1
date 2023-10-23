package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Plan;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;

@RestController
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping ("/producto")
    public String producto (Model model){
    model.addAttribute ("producto", productoRepository.darProductos());
    return model.toString();
    }

    @GetMapping ("/producto/new")
    public String productoForm(Model model){
    model.addAttribute("producto", new Producto(null, 0));
    return "planNuevo";
    }  

    @PostMapping("/producto/new/save")
    public String productoGuardar (@ModelAttribute Producto producto){
    productoRepository.insertarProducto(producto.getNombre(), producto.getPrecio());
    return "redirect:/producto";
    }

    @PostMapping("/producto/{id}/edit")
    public String productoEditarForm(@PathVariable("id") int id, Model model)
    {
        Producto producto = productoRepository.darProducto(id);
        if(producto != null)
        {
            model.addAttribute("producto", producto);
            return "productoEditar";
        } else {
            return "redirect:/producto";
        }
    }


    @PostMapping("/producto/{id}/edit/save")
    public String productoEditarGuardar(@PathVariable("id") int id, @ModelAttribute Producto producto)
    {
        productoRepository.actualizarProducto(producto.getId(), producto.getNombre(), producto.getPrecio());
        return "redirect:/producto";

    }

    @GetMapping("/producto/{id}/delete")
    public String productoEliminar(@PathVariable("id") int id)
    {
        productoRepository.eliminarMaquina(id);
        return "redirect:/producto";
    }
    
    
}
