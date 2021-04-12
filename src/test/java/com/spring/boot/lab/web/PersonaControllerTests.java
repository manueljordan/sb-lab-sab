package com.spring.boot.lab.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

/**
 *
 * @author manueljordan
 *
 */
@ActiveProfiles(profiles = "h2")
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
class PersonaControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void getOneByIdTest() throws Exception {
		mockMvc.perform(get("/personas/{id}", "101"))
		       .andDo(print())
		       .andExpect(status().isOk())
		       .andExpect(model().size(1))
		       .andExpect(view().name("persona/detalle"))
		       .andExpect(content().contentType("text/html;charset=UTF-8"));
	}

	@Test
	void getAllTest() throws Exception {
		mockMvc.perform(get("/personas"))
		       .andDo(print())
		       .andExpect(status().isOk())
		       .andExpect(model().size(1))
		       .andExpect(view().name("persona/reporte"))
		       .andExpect(content().contentType("text/html;charset=UTF-8"));
	}

}
