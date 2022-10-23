
package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import com.tienda.service.ClienteService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/cliente/nuevo")
    public String clienteNuevo(Cliente cliente){
        return "modificarCliente.html";
    }
    
    @PostMapping("/cliente/guardar")
    public String clienteGuardar(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/";
    }
    
    @GetMapping("/cliente/modificar/{idCliente}")
    public String clienteModifica(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente",cliente);
        return "modificarCliente.html";
    }
    
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String clienteEliminar(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/";
    }
    
}
 