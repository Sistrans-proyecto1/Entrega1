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
import uniandes.edu.co.proyecto.repositorio.HotelRepository;

@RestController
public class HotelController {
    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping ("/hoteles")
    public String hoteles (Model model){
    model.addAttribute ("hotel", hotelRepository.darHoteles());
    return model.toString();
    }

    @GetMapping ("/hoteles/new")
    public String hotelesForm(Model model){
    model.addAttribute("hotel", new Hotel());
    return "hotelNuevo";
    }  

    @PostMapping("/hoteles/new/save")
    public String hotelGuardar (@ModelAttribute Hotel hotel){
    hotelRepository.insertarHotel(hotel.getNombre(), hotel.getCiudad(), hotel.getPais(), hotel.getCadenaHotelesid());
    return "redirect:/hoteles";
    }

    @PostMapping("/hoteles/{id}/edit")
    public String hotelesEditarForm(@PathVariable("id") int id, Model model)
    {
        Hotel hotel = hotelRepository.darHotel(id);
        if(hotel != null)
        {
            model.addAttribute("hotel", hotel);
            return "hotelEditar";
        } else {
            return "redirect:/hoteles";
        }
    }


    @PostMapping("/hoteles/{id}/edit/save")
    public String hotelEditarGuardar(@PathVariable("id") int id, @ModelAttribute Hotel hotel)
    {
        hotelRepository.actualizarHotel(id, hotel.getNombre(), hotel.getCiudad(), hotel.getPais(), hotel.getCadenaHotelesid());
        return "redirect:/hoteles";

    }

    @GetMapping("/hoteles/{id}/delete")
    public String hotelEliminar(@PathVariable("id") int id)
    {
        hotelRepository.eliminarHotel(id);
        return "redirect:/hoteles";
    }
    
}
