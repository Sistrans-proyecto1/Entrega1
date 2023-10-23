package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.Gimnasio;
import uniandes.edu.co.proyecto.repositorio.EmpleadoRepository;
import uniandes.edu.co.proyecto.repositorio.GimnasioRepository;

@RestController
public class GimnasioController {
    @Autowired
    private GimnasioRepository gimnasioRepository;

    @GetMapping ("/gimnasio")
    public String gimnasio (Model model){
    model.addAttribute ("gimnasio", gimnasioRepository.darGimnasios());
    return model.toString();
    }

    @GetMapping ("/gimnasio/new")
    public String gimnasioForm(Model model){
    model.addAttribute("gimnasio", new Gimnasio());
    return "gimnasioNuevo";
    }  

    @PostMapping("/gimnasio/new/save")
    public String gimnasioGuardar (@ModelAttribute Gimnasio gimnasio){
    gimnasioRepository.insertarGimnasio(gimnasio.getNombre(), gimnasio.getCapacidad(), gimnasio.getHorario(), gimnasio.getServicio());
    return "redirect:/gimnasio";
    }

    @PostMapping("/gimnasio/{id}/edit")
    public String gimnasioEditarForm(@PathVariable("id") int id, Model model)
    {
        Gimnasio gimnasio = gimnasioRepository.darGimnasio(id);
        if(gimnasio != null)
        {
            model.addAttribute("gimnasio", gimnasio);
            return "gimnasioEditar";
        } else {
            return "redirect:/gimnasio";
        }
    }


    @PostMapping("/gimnasio/{id}/edit/save")
    public String gimnasioEditarGuardar(@PathVariable("id") int id, @ModelAttribute Gimnasio gimnasio)
    {
        gimnasioRepository.actualizarGimnasio(gimnasio.getNombre(), gimnasio.getCapacidad(), gimnasio.getHorario(), gimnasio.getServicio());
        return "redirect:/gimnasio";

    }

    @GetMapping("/gimnasio/{id}/delete")
    public String gimnasioEliminar(@PathVariable("id") int id)
    {
        gimnasioRepository.eliminarGimnasio(id);
        return "redirect:/gimnasio";
    }
    
}
