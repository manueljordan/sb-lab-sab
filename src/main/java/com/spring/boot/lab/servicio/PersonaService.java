package com.spring.boot.lab.servicio;

import java.util.Optional;

import com.spring.boot.lab.dominio.Persona;

/**
 *
 * @author manueljordan
 *
 */
public interface PersonaService {

	long count();

	Optional<Persona> findOneById(String id);

	Iterable<Persona> findAll();

}
