package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.CadenaHoteles;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.repositorio.CadenaRepository;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;

@RestController
public class CadenaHotelesController {
    @Autowired
    private CadenaRepository cadenaRepository;

    @GetMapping ("/cadenas")
    public String cadenas (Model model){
    model. addAttribute ("bares", cadenaRepository.darCadenas());
    return model.toString();
    }

    @GetMapping ("/cadenas/new")
    public String cadenaForm(Model model){
    model.addAttribute("cadena", new CadenaHoteles());
    return "cadenaNueva";
    }  

    @PostMapping("/cadenas/new/save")
    public String cadenaGuardar (@ModelAttribute CadenaHoteles cadena){
    cadenaRepository.insertarCadena(cadena.getNombre());
    return "redirect:/cadenas";
    }

    @PostMapping("/cadenas/{id}/edit")
    public String cadenaEditarForm(@PathVariable("id") int id, Model model)
    {
        CadenaHoteles cadena = cadenaRepository.darCadena(id);
        if(cadena != null)
        {
            model.addAttribute("cadena", cadena);
            return "cadenaEditar";
        } else {
            return "redirect:/cadenas";
        }
    }


    @PostMapping("/cadenas/{id}/edit/save")
    public String cadenaEditarGuardar(@PathVariable("id") int id, @ModelAttribute CadenaHoteles cadena)
    {
        cadenaRepository.actualizarCadena(id, cadena.getNombre());
        return "redirect:/cadenas";

    }

    @GetMapping("/cadenas/{id}/delete")
    public String cadenaEliminar(@PathVariable("id") int id)
    {
        cadenaRepository.eliminarCadena(id);
        return "redirect:/cadenas";
    }
    
}
