
package com.tienda.controller;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    
    @GetMapping("/categoria/listado")
    public String listado(Model model){
        var categorias=categoriaService.getCategorias(false);
        model.addAttribute("categorias",categorias);
        return "/categoria/listado";
    }
    
    
    
    
    
    @GetMapping("/categoria/nuevo")
    public String categoriaNuevo(Categoria categoria){
        return "/categoria/modificar";
    }
    
    @PostMapping("/categoria/guardar")
    public String categoriaGuardar(Categoria categoria){
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/categoria/modificar/{idCategoria}")
    public String categoriaModifica(Categoria categoria, Model model){
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria",categoria);
        return "/categoria/modificar";
    }
    
    @GetMapping("/categoria/eliminar/{idCategoria}")
    public String categoriaEliminar(Categoria categoria){
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }
    
}
 