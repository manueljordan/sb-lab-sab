package com.spring.boot.lab.rest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.lab.dominio.Persona;
import com.spring.boot.lab.servicio.PersonaService;

import io.micrometer.core.annotation.Timed;

/**
 *
 * @author manueljordan
 *
 */
@Controller
public class PersonaRestController {

	private final PersonaService personaService;

	public PersonaRestController(PersonaService personaService) {
		super();
		this.personaService = personaService;
	}


	@GetMapping(path="/personas/{id}.json", produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed(description = "Personas Metricas",
    	   extraTags = {"cardinalidad", "simple",
    			   		"formato","json",
    			   		"informacion","persona",
    			   		"presentacion","reporte"},
    	   value = "http.server.requests.personas")
	public @ResponseBody Persona getOneById(@PathVariable String id) {
		return this.personaService.findOneById(id).get();
	}

	@GetMapping(path="/personas.json", produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed(description = "Personas Metricas",
    	   extraTags = {"cardinalidad", "multiple",
    			   		"formato","json",
    			   		"informacion","personas",
    			   		"presentacion","reporte"},
    	   value = "http.server.requests.personas")
	public @ResponseBody Iterable<Persona> getAll() {
		return this.personaService.findAll();
	}

}
