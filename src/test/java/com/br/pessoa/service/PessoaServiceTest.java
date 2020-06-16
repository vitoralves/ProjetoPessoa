package com.br.pessoa.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.pessoa.entity.PessoaEntity;
import com.br.pessoa.repository.PessoaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PessoaServiceTest {

	@Autowired
	private PessoaService pessoaService;
	
	@MockBean
	private PessoaRepository pessoaRepository;
	
	@Before
	public void setUp() {
		BDDMockito.given(pessoaRepository.findByDocumentoEquals(Mockito.anyInt())).willReturn(Optional.of(new PessoaEntity()));
	}
	
	@Test
	public void findByDocumento() {
		Optional<PessoaEntity> responseService = pessoaService.findByDocumento(123);
		
		assertTrue(responseService.isPresent());
	}
}
