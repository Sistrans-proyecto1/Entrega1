package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Hotel;

import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;

@RestController
public class HabitacionController {
    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping ("/habitaciones")
    public String habitaciones (Model model){
    model.addAttribute ("habitacion", habitacionRepository.darHabitaciones());
    return model.toString();
    }

    @GetMapping ("/habitaciones/new")
    public String habitacionForm(Model model){
    model.addAttribute("habitacion", new Habitacion(0, false, false, false, false, false, false, 0, null, null));
    return "habitacionNueva";
    }  

    @PostMapping("/habitaciones/new/save")
    public String habitacionGuardar (@ModelAttribute Habitacion habitacion){
    habitacionRepository.insertarHabitacion(habitacion.Ubicacion(), habitacion.isTelevision(), habitacion.isMinibar(), habitacion.isComedor(), habitacion.isJacuzzi(), habitacion.isCafetera(), habitacion.isCocina(), habitacion.getPrecio(), habitacion.getHotelid(), habitacion.getTipoHabitacion());
    return "redirect:/habitaciones";
    }

    @PostMapping("/habitaciones/{id}/edit")
    public String habitacionesEditarForm(@PathVariable("ubicacion") int ubicacion, @PathVariable("hotel_id") Hotel hoteles_id, Model model)
    {
        Habitacion habitacion = habitacionRepository.darHabitacion(ubicacion, hoteles_id);
        if(habitacion != null)
        {
            model.addAttribute("habitacion", habitacion);
            return "habitacionEditar";
        } else {
            return "redirect:/habitaciones";
        }
    }


    @PostMapping("/habitaciones/{id}/edit/save")
    public String habitacionEditarGuardar(@PathVariable("ubicacion") int ubicacion, @PathVariable("hotel_id") Hotel hotel_id, @ModelAttribute Habitacion habitacion)
    {
        habitacionRepository.actualizarHabitacion(habitacion.Ubicacion(), habitacion.isTelevision(), habitacion.isMinibar(), habitacion.isComedor(), habitacion.isJacuzzi(), habitacion.isCafetera(), habitacion.isCocina(), habitacion.getPrecio(), habitacion.getHotelid(), habitacion.getTipoHabitacion());
        return "redirect:/habitaciones";

    }

    @GetMapping("/habitaciones/{id}/delete")
    public String habitacionEliminar(@PathVariable("ubicacion") int ubicacion, @PathVariable("hotel_id") Hotel hotel_id)
    {
        habitacionRepository.eliminarHabitacion(ubicacion, hotel_id);
        return "redirect:/habitaciones";
    }
    
}
