package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.CadenaHoteles;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.repositorio.CadenaRepository;
import uniandes.edu.co.proyecto.repositorio.EmpleadoRepository;

@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping ("/empleados")
    public String empleados (Model model){
    model.addAttribute ("empleados", empleadoRepository.darEmpleados());
    return model.toString();
    }

    @GetMapping ("/empleados/new")
    public String empleadoForm(Model model){
    model.addAttribute("empleados", new Empleado());
    return "empleadoNuevo";
    }  

    @PostMapping("/empleados/new/save")
    public String empleadoGuardar (@ModelAttribute Empleado empleado){
    empleadoRepository.insertarEmpleado(empleado.getNombre(), empleado.getEdad(), empleado.getCorreo(), empleado.getTelefono(), empleado.getHotelid(), 
    empleado.getTipoEmpleado());
    return "redirect:/empleados";
    }

    @PostMapping("/empleados/{id}/edit")
    public String empleadoEditarForm(@PathVariable("id") int id, Model model)
    {
        Empleado empleado = empleadoRepository.darEmpleado(id);
        if(empleado != null)
        {
            model.addAttribute("empleado", empleado);
            return "empleadoEditar";
        } else {
            return "redirect:/empleados";
        }
    }


    @PostMapping("/empleados/{id}/edit/save")
    public String empleadoEditarGuardar(@PathVariable("id") int id, @ModelAttribute Empleado empleado)
    {
        empleadoRepository.actualizarEmpleado(id,empleado.getNombre(), empleado.getEdad(), empleado.getCorreo(), empleado.getTelefono(), empleado.getHotelid(), 
        empleado.getTipoEmpleado());
        return "redirect:/empleados";

    }

    @GetMapping("/empleados/{id}/delete")
    public String empleadosEliminar(@PathVariable("id") int id)
    {
        empleadoRepository.eliminarEmpleado(id);
        return "redirect:/empleados";
    }
    
}
