package com.jdelgado.CRUD.interfaceService;

import java.util.List;
import java.util.Optional;

import com.jdelgado.CRUD.modelo.Persona;

public interface InterfazPersonaService {
    public List<Persona> listar();

    public Optional<Persona> listarId(int id);

    public int save(Persona p);

    public void delete(int id);

}
