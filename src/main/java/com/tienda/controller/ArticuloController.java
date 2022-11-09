
package com.tienda.controller;

import com.tienda.dao.ArticuloDao;
import com.tienda.domain.Articulo;
import com.tienda.service.ArticuloService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ArticuloController {
    
    @Autowired
    private ArticuloService articuloService;
    
    
    @GetMapping("/articulo/listado")
    public String listado(Model model){
        var articulos=articuloService.getArticulos(false);
        model.addAttribute("articulos",articulos);
        return "/articulo/listado";
    }
    
    
    
    
    
    @GetMapping("/articulo/nuevo")
    public String articuloNuevo(Articulo articulo){
        return "/articulo/modificar";
    }
    
    @PostMapping("/articulo/guardar")
    public String articuloGuardar(Articulo articulo){
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }
    
    @GetMapping("/articulo/modificar/{idArticulo}")
    public String articuloModifica(Articulo articulo, Model model){
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo",articulo);
        return "/articulo/modificar";
    }
    
    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String articuloEliminar(Articulo articulo){
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }
    
}
 