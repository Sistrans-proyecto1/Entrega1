package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.Piscina;
import uniandes.edu.co.proyecto.repositorio.HotelRepository;
import uniandes.edu.co.proyecto.repositorio.PiscinaRepository;

@RestController
public class PiscinaController {
    @Autowired
    private PiscinaRepository piscinaRepository;

    @GetMapping ("/piscina")
    public String piscina (Model model){
    model.addAttribute ("piscina", piscinaRepository.darPiscinas());
    return model.toString();
    }

    @GetMapping ("/piscina/new")
    public String piscinaForm(Model model){
    model.addAttribute("piscina", new Piscina(0, 0, null, null));
    return "picinaNueva";
    }  

    @PostMapping("/pisicna/new/save")
    public String piscinaGuardar (@ModelAttribute Piscina piscina){
    piscinaRepository.insertarPiscina(piscina.getCapacidad(), piscina.getHorario(), piscina.getProfundidad(), piscina.getServicioid());
    return "redirect:/piscina";
    }

    @PostMapping("/piscina/{id}/edit")
    public String piscinaEditarForm(@PathVariable("id") int id, Model model)
    {
        Piscina piscina = piscinaRepository.darPiscina(id);
        if(piscina != null)
        {
            model.addAttribute("piscina", piscina);
            return "piscinaEditar";
        } else {
            return "redirect:/piscina";
        }
    }


    @PostMapping("/piscina/{id}/edit/save")
    public String piscinaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Piscina piscina)
    {
        piscinaRepository.actualizarPiscina(piscina.getCapacidad(), piscina.getHorario(), piscina.getProfundidad(), piscina.getServicioid());
        return "redirect:/piscina";

    }

    @GetMapping("/piscina/{id}/delete")
    public String piscinaEliminar(@PathVariable("id") int id)
    {
        piscinaRepository.eliminarPiscina(id);
        return "redirect:/piscina";
    }
    
}
