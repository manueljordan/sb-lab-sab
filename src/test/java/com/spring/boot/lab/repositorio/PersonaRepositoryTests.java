package com.spring.boot.lab.repositorio;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

import com.spring.boot.lab.dominio.Persona;

/**
 *
 * @author manueljordan
 *
 */
@ActiveProfiles(profiles = "h2")
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class PersonaRepositoryTests {

	@Autowired
	private PersonaRepository personaRepository;

	@Test
	void countTest() {
		long count = personaRepository.count();
		assertThat(count).isEqualTo(33);
	}

	@Test
	void personaTest() {
		Persona persona = personaRepository.findById("101").get();

		assertThat(persona).isNotNull()
		                   .isInstanceOf(Persona.class)
		                   .hasNoNullFieldsOrProperties()
		                   .hasFieldOrPropertyWithValue("id", "101")
						   .hasFieldOrPropertyWithValue("nombre", "nombre_01")
						   .hasFieldOrPropertyWithValue("apellido", "apellido_01")
						   .hasFieldOrPropertyWithValue("documento", "0000001")
						   .hasFieldOrPropertyWithValue("edad", 21)
						   .hasFieldOrPropertyWithValue("profesion", "profesion_01");
	}

	@Test
	void personasTest() {
		Iterable<Persona> personas = personaRepository.findAll();

		assertThat(personas).isNotNull()
		                    .isNotEmpty()
		                    .isInstanceOf(Iterable.class)
		                    .hasOnlyElementsOfType(Persona.class)
		                    .hasSize(33);
	}

}
