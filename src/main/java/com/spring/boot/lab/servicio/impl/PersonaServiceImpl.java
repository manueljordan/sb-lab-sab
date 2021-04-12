package com.spring.boot.lab.servicio.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.lab.dominio.Persona;
import com.spring.boot.lab.repositorio.PersonaRepository;
import com.spring.boot.lab.servicio.PersonaService;

/**
 *
 * @author manueljordan
 *
 */
@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

	private final PersonaRepository personaRepository;

	public PersonaServiceImpl(PersonaRepository personaRepository) {
		super();
		this.personaRepository = personaRepository;
	}

	@Override
	public long count() {
		return this.personaRepository.count();
	}

	@Override
	public Optional<Persona> findOneById(String id) {
		return this.personaRepository.findById(id);
	}

	@Override
	public Iterable<Persona> findAll() {
		return this.personaRepository.findAll();
	}

}
