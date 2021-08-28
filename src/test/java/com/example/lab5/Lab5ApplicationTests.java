package com.example.lab5;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.lab5.entity.Personagem;
import com.example.lab5.repository.PersonagemRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback
class Lab5ApplicationTests {

	@Autowired
	private PersonagemRepository personagemRepo;

	@Test
	void contextLoads() {
	}
	@Test
	void findByNomeTest() {
		Personagem per = new Personagem();
		per.setNome("Sandro");
		per.setAlinhamento("Mago");
		//per.setDt_nascimento("14-01-1998");
		personagemRepo.save(per);

		assertNotNull(personagemRepo.findByNome("Sandro"));
	}
	@Test
	void findByNomeContainsOrAlinhamentoContainsTest() {
		Personagem per = new Personagem();
		per.setNome("Sandro");
		per.setAlinhamento("Mago");
		//per.setDt_nascimento("14-01-1998");
		personagemRepo.save(per);

		assertFalse(personagemRepo.findByNomeContainsOrAlinhamentoContains("dro","teste").isEmpty());
	}

}
