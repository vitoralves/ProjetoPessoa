package com.br.pessoa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.pessoa.entity.PessoaEntity;
import com.br.pessoa.repository.PessoaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaTest {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Test
	public void testeSave() {
		PessoaEntity pessoaEntity = new PessoaEntity();
		
		pessoaEntity.setNome("Maria de Jesus");
		pessoaEntity.setDocumento(123);
		
		pessoaRepository.save(pessoaEntity);
	}

}
