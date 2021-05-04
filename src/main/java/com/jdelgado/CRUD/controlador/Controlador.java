package com.jdelgado.CRUD.controlador;

import com.jdelgado.CRUD.interfaceService.InterfazPersonaService;
import com.jdelgado.CRUD.modelo.Persona;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private InterfazPersonaService servicio;

    @GetMapping("/")
    public String listar(Model modelo) {
        List<Persona> personas = servicio.listar();
        modelo.addAttribute("personas", personas);
        return "index";
    }
    @GetMapping("/new")
    public String agregar(Model modelo){
        modelo.addAttribute("persona",new Persona());
        return "form";
    }

    @PostMapping("/save")
    public String save(@Validated Persona p, Model modelo){
        servicio.save(p);
        return "redirect:/";

    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model modelo){
        Optional<Persona> persona=servicio.listarId(id);
        modelo.addAttribute("persona", persona);

        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable int id, Model modelo){

        servicio.delete(id);
        return "redirect:/";
    }
}
