package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;

@RestController
public class ClientesController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping ("/clientes")
    public String clientes (Model model){
    model. addAttribute ("bares", clienteRepository.darClientes());
    return model.toString();
    }

    @GetMapping ("/clientes/new")
    public String clienteForm(Model model){
    model.addAttribute("cliente", new Cliente(null, 0, null, 0, null));
    return "clienteNuevo";
    }  

    @PostMapping("/clientes/new/save")
    public String clienteGuardar (@ModelAttribute Cliente cliente){
    clienteRepository.insertarCliente(cliente.getNombre(), cliente.getEdad(), cliente.getCorreo(), cliente.getTelefono(), cliente.getIDhotel());
    return "redirect:/clientes";
    }

    @PostMapping("/clientes/{id}/edit")
    public String clienteEditarForm(@PathVariable("id") int id, Model model)
    {
        Cliente cliente = clienteRepository.darCliente(id);
        if(cliente != null)
        {
            model.addAttribute("cliente", cliente);
            return "clienteEditar";
        } else {
            return "redirect:/clientes";
        }
    }


    @PostMapping("/clientes/{id}/edit/save")
    public String clienteEditarGuardar(@PathVariable("id") int id, @ModelAttribute Cliente cliente)
    {
        clienteRepository.actualizarCliente(id, cliente.getNombre(), cliente.getEdad(), cliente.getCorreo(), cliente.getTelefono(), cliente.getIDhotel());
        return "redirect:/clientes";

    }

    @GetMapping("/clientes/{id}/delete")
    public String clienteEliminar(@PathVariable("id") int id)
    {
        clienteRepository.eliminarCliente(id);
        return "redirect:/clientes";
    }

}
