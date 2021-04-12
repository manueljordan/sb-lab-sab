package com.spring.boot.lab.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.boot.lab.dominio.Persona;
import com.spring.boot.lab.servicio.PersonaService;

/**
 *
 * @author manueljordan
 *
 */
@ActiveProfiles(profiles = "slice")
@WebMvcTest(controllers = PersonaController.class)
class PersonaControllerSliceTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonaService personaService;

	@Test
	void getOneByIdTest() throws Exception {

		when(personaService.findOneById("101"))
		.thenReturn(Optional.of(new Persona()));

		mockMvc.perform(get("/personas/{id}", "101"))
	       	   .andDo(print())
	       	   .andExpect(status().isOk())
	       	   .andExpect(model().size(1))
	       	   .andExpect(view().name("persona/detalle"))
	       	   .andExpect(content().contentType("text/html;charset=UTF-8"));
	}

}
