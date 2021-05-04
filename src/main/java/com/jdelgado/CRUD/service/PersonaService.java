package com.jdelgado.CRUD.service;

import com.jdelgado.CRUD.interfaceService.InterfazPersonaService;
import com.jdelgado.CRUD.interfaces.InterfazPersona;
import com.jdelgado.CRUD.modelo.Persona;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements InterfazPersonaService {


    @Autowired
    private InterfazPersona dato;


    @Override
    public List<Persona> listar() {
        return (List<Persona>) dato.findAll();
    }

    @Override
    public Optional<Persona> listarId(int id) {

        return dato.findById(id);
    }

    @Override
    public int save(Persona p) {
        int resp = 0;
        Persona persona = dato.save(p);
        if(!persona.equals(null)){
            resp = 1;
        }
        return resp;
    }

    @Override
    public void delete(int id) {
        dato.deleteById(id);
    }
}
