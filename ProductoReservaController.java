package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Plan;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;

@RestController

public class ProductoReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping ("/reserva")
    public String reserva (Model model){
    model.addAttribute ("reserva", reservaRepository.darReservas());
    return model.toString();
    }

    @GetMapping ("/reserva/new")
    public String reservaForm(Model model){
    model.addAttribute("reserva", new Reserva(null, null, 0, null, null, null, null));
    return "reservaNueva";
    }  

    @PostMapping("/reserva/new/save")
    public String reservaGuardar (@ModelAttribute Reserva reserva){
    reservaRepository.insertarReserva(reserva.getNombre(), reserva.getFechaInicial(), reserva.getFechaFinal(), reserva.getNumeroPersonas(), reserva.getHabitaciones_ubicacion(),
                        reserva.getClientes_id(), reserva.getPlanid(),reserva.getHabitaciones_hoteles_id());
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
