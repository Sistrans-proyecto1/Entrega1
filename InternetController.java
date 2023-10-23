package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.Internet;
import uniandes.edu.co.proyecto.repositorio.HotelRepository;
import uniandes.edu.co.proyecto.repositorio.InternetRepository;

@RestController
public class InternetController {

    @Autowired
    private InternetRepository internetRepository;


    @GetMapping ("/internet/new")
    public String internetForm(Model model){
    model.addAttribute("internet", new Internet());
    return "internetNuevo";
    }  

    @PostMapping("/internet/new/save")
    public String internetGuardar (@ModelAttribute Internet internet){
    internetRepository.insertarInternet(internet.getCapacidad(), internet.getServicioid());
    return "redirect:/internet";
    }

    @PostMapping("/internet/{id}/edit")
    public String internetEditarForm(@PathVariable("id") int id, Model model)
    {
        Internet internet = internetRepository.darInternet(id);
        if(internet != null)
        {
            model.addAttribute("internet", internet);
            return "internetEditar";
        } else {
            return "redirect:/internet";
        }
    }


    @PostMapping("/internet/{id}/edit/save")
    public String internetEditarGuardar(@PathVariable("id") int id, @ModelAttribute Internet internet)
    {
        internetRepository.actualizarInternet(internet.getCapacidad(), internet.getServicioid());
        return "redirect:/internet";

    }

    @GetMapping("/internet/{id}/delete")
    public String internetEliminar(@PathVariable("id") int id)
    {
        internetRepository.eliminarInternet(id);
        return "redirect:/internet";
    }
    
}
