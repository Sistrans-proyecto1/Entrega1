package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Piscina;
import uniandes.edu.co.proyecto.modelo.Plan;
import uniandes.edu.co.proyecto.repositorio.PiscinaRepository;
import uniandes.edu.co.proyecto.repositorio.PlanRepository;

@RestController
public class PlanController {
    @Autowired
    private PlanRepository planRepository;

    @GetMapping ("/plan")
    public String plan (Model model){
    model.addAttribute ("plan", planRepository.darPlanes());
    return model.toString();
    }

    @GetMapping ("/plan/new")
    public String planForm(Model model){
    model.addAttribute("plan", new Plan(null, 0, null));
    return "planNuevo";
    }  

    @PostMapping("/plan/new/save")
    public String planGuardar (@ModelAttribute Plan plan){
    planRepository.insertarPlan(plan.getNombre(), plan.getCosto(), plan.getHotelid());
    return "redirect:/plan";
    }

    @PostMapping("/plan/{id}/edit")
    public String planEditarForm(@PathVariable("id") int id, Model model)
    {
        Plan plan = planRepository.darPlan(id);
        if(plan != null)
        {
            model.addAttribute("plan", plan);
            return "planEditar";
        } else {
            return "redirect:/plan";
        }
    }


    @PostMapping("/plan/{id}/edit/save")
    public String planEditarGuardar(@PathVariable("id") int id, @ModelAttribute Plan plan)
    {
        planRepository.actualizaPlan(plan.getId(), plan.getNombre(), plan.getCosto(), plan.getHotelid());
        return "redirect:/plan";

    }

    @GetMapping("/plan/{id}/delete")
    public String planEliminar(@PathVariable("id") int id)
    {
        planRepository.eliminarPlan(id);
        return "redirect:/plan";
    }
    
    
}
