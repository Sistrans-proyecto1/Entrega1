package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;

@Controller
public class ClientesController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping ("/clientes")
    public String clientes (Model model){
    model. addAttribute ("bares", clienteRepository.darClientes());
    return "clientes";
    }

    @GetMapping (" /clientes/new")
    public String clienteForm(Model model){
    model.addAttribute("cliente", new Cliente());
    return "clienteNuevo";
    }  

    @PostMapping("/bares/new/save")
    public String barGuardar (@ModelAttribute Bar bar){
    barRepository.insertarBar(bar•getNombre(),
    bar • getCiudad(), bar -getPresupuesto(), bar -getCant_sedes ()); return "redirect: /bares
        
    }
}
}
