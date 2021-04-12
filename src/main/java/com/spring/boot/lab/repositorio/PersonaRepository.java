package com.spring.boot.lab.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.lab.dominio.Persona;

/**
 *
 * @author manueljordan
 *
 */
public interface PersonaRepository extends CrudRepository<Persona, String> {

}
