package com.spring.boot.lab.repositorio;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author manueljordan
 *
 */
@ActiveProfiles(profiles = {"h2", "slice"})
@DataJpaTest
class PersonaRepositorySliceTests {

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	void countTest() {
		long count = personaRepository.count();
		assertThat(count).isEqualTo(33);

		count = testEntityManager.getEntityManager()
				 				 .createQuery("SELECT COUNT(*) FROM Persona p", Long.class)
				 				 .getSingleResult();
		assertThat(count).isEqualTo(33);

		BigInteger _count =
				(BigInteger) testEntityManager.getEntityManager()
			  				  				  .createNativeQuery("SELECT COUNT(*) FROM persona")
			  				  				  .getSingleResult();
		assertThat(_count).isEqualTo(33);
	}

}
