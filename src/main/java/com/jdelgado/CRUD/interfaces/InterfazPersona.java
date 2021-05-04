package com.jdelgado.CRUD.interfaces;

import com.jdelgado.CRUD.modelo.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfazPersona extends CrudRepository<Persona, Integer> {


}
