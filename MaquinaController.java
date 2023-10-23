package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.Maquina;
import uniandes.edu.co.proyecto.repositorio.HotelRepository;
import uniandes.edu.co.proyecto.repositorio.MaquinaRepository;

@RestController
public class MaquinaController {
    @Autowired
    private MaquinaRepository maquinaRepository;

    @GetMapping ("/maquinas")
    public String maquinas (Model model){
    model.addAttribute ("maquina", maquinaRepository.darMaquinas());
    return model.toString();
    }

    @GetMapping ("/maquinas/new")
    public String maquinasForm(Model model){
    model.addAttribute("maquina", new Maquina());
    return "maquinaNuevo";
    }  

    @PostMapping("/maquinas/new/save")
    public String maquinaGuardar (@ModelAttribute Maquina maquina){
    maquinaRepository.insertarMaquina(maquina.getNombre(), maquina.getGimnasioid());
    return "redirect:/maquinas";
    }

    @PostMapping("/maquinas/{id}/edit")
    public String maquinasEditarForm(@PathVariable("id") int id, Model model)
    {
        Maquina maquina = maquinaRepository.darMaquina(id);
        if(maquina != null)
        {
            model.addAttribute("maquina", maquina);
            return "maquinaEditar";
        } else {
            return "redirect:/maquinas";
        }
    }


    @PostMapping("/maquinas/{id}/edit/save")
    public String maquinaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Maquina maquina)
    {
        maquinaRepository.actualizarMaquina(id, maquina.getNombre(), maquina.getGimnasioid());
        return "redirect:/maquinas";

    }

    @GetMapping("/maquinas/{id}/delete")
    public String maquinaEliminar(@PathVariable("id") int id)
    {
        maquinaRepository.eliminarMaquina(id);
        return "redirect:/maquinas";
    }
    
}
