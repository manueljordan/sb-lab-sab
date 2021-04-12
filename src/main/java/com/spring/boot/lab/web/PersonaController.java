package com.spring.boot.lab.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.boot.lab.servicio.PersonaService;

import io.micrometer.core.annotation.Timed;

/**
 *
 * @author manueljordan
 *
 */
@Controller
public class PersonaController {

	private final PersonaService personaService;

	public PersonaController(PersonaService personaService) {
		super();
		this.personaService = personaService;
	}

	@GetMapping(path="/personas/{id}", produces = MediaType.TEXT_HTML_VALUE)
	@Timed(description = "Personas Metricas",
	       extraTags = {"cardinalidad", "simple",
	    		        "formato","html",
	    		        "informacion","persona",
	    		        "presentacion","reporte"},
		   value = "http.server.requests.personas")
	public String getOneById(Model model, @PathVariable("id") String id) {
		model.addAttribute("persona", personaService.findOneById(id).get());
		return "persona/detalle";
	}

	@GetMapping(path="/personas", produces = MediaType.TEXT_HTML_VALUE)
	@Timed(description = "Personas Metricas",
    	   extraTags = {"cardinalidad", "multiple",
    			   	    "formato","html",
    			   	    "informacion","personas",
    			   	    "presentacion","reporte"},
    	   value = "http.server.requests.personas")
	public String getAll(Model model) {
		model.addAttribute("personas", personaService.findAll());
		return "persona/reporte";
	}

}
