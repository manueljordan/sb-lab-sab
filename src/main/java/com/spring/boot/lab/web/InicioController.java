package com.spring.boot.lab.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author manueljordan
 *
 */
@Controller
public class InicioController {

	@GetMapping(path="/", produces=MediaType.TEXT_HTML_VALUE)
	public String inicio() {
		return "inicio/inicio";
	}

}
