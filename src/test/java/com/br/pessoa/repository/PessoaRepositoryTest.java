package com.br.pessoa.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.pessoa.entity.PessoaEntity;
import com.br.pessoa.repository.PessoaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaRepositoryTest {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	private static final int DOCUMENTO = 123;
	
	@Before
	public void setUp() {
		PessoaEntity pessoaEntity = new PessoaEntity();
		
		pessoaEntity.setNome("Maria de Jesus");
		pessoaEntity.setDocumento(DOCUMENTO);
		
		pessoaRepository.save(pessoaEntity);
	}
	
	@After
	public void tearDown() {
		pessoaRepository.deleteAll();
	}
	
	@Test
	public void testeSave() {
		PessoaEntity pessoaEntity = new PessoaEntity();
		
		pessoaEntity.setNome("Maria de Jesus");
		pessoaEntity.setDocumento(123);
		
		PessoaEntity responseSaved = pessoaRepository.save(pessoaEntity);
		
		assertNotNull(responseSaved);
	}

	@Test
	public void testFindByDocumento() {
		Optional<PessoaEntity> responseFind = pessoaRepository.findByDocumentoEquals(DOCUMENTO);
		
		assertTrue(responseFind.isPresent());
		assertEquals(DOCUMENTO, responseFind.get().getDocumento());
	}
}
