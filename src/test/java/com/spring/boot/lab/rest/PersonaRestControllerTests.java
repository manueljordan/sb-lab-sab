package com.spring.boot.lab.rest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.spring.boot.lab.dominio.Persona;

/**
 *
 * @author manueljordan
 *
 */
@ActiveProfiles(profiles = "h2")
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class PersonaRestControllerTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void personaTest() {
		Persona persona = testRestTemplate.getForObject("/personas/{id}.json", Persona.class, "101");

		assertThat(persona).isNotNull()
						   .isInstanceOf(Persona.class)
						   .hasNoNullFieldsOrProperties()
						   .hasFieldOrPropertyWithValue("id", "101")
						   .hasFieldOrPropertyWithValue("nombre", "nombre_01")
						   .hasFieldOrPropertyWithValue("apellido", "apellido_01")
						   .hasFieldOrPropertyWithValue("documento", "0000001")
						   .hasFieldOrPropertyWithValue("edad", 21)
						   .hasFieldOrPropertyWithValue("profesion", "profesion_01");

		ResponseEntity<Persona> personaResponse =
				testRestTemplate.getForEntity("/personas/{id}.json", Persona.class, "101");

		assertThat(personaResponse).isNotNull();

		assertThat(personaResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(personaResponse.getStatusCodeValue()).isEqualTo(200);

		assertThat(personaResponse.getBody()).isNotNull()
											 .isInstanceOf(Persona.class)
											 .hasNoNullFieldsOrProperties()
											 .hasFieldOrPropertyWithValue("id", "101")
											 .hasFieldOrPropertyWithValue("nombre", "nombre_01")
											 .hasFieldOrPropertyWithValue("apellido", "apellido_01")
											 .hasFieldOrPropertyWithValue("documento", "0000001")
											 .hasFieldOrPropertyWithValue("edad", 21)
											 .hasFieldOrPropertyWithValue("profesion", "profesion_01");

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	void personasTest() {
		Iterable<Persona> personas = testRestTemplate.getForObject("/personas.json", Iterable.class);

		assertThat(personas).isNotNull()
        					.isNotEmpty()
        					.isInstanceOf(Iterable.class)
        					.hasOnlyElementsOfType(LinkedHashMap.class)
        					.hasSize(33);

		ResponseEntity<Iterable> personasResponse =
				testRestTemplate.getForEntity("/personas.json", Iterable.class);

		assertThat(personasResponse).isNotNull();

		assertThat(personasResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(personasResponse.getStatusCodeValue()).isEqualTo(200);

		assertThat(personasResponse.getBody()).isNotNull()
											  .isNotEmpty()
											  .isInstanceOf(Iterable.class)
											  .hasOnlyElementsOfType(LinkedHashMap.class)
											  .hasSize(33);

	}

}
