package com.br.pessoa.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.br.pessoa.dto.PessoaDTO;
import com.br.pessoa.entity.PessoaEntity;
import com.br.pessoa.service.PessoaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class PessoaControllerTest {

	@MockBean
	private PessoaService pessoaService;

	@Autowired
	private MockMvc mvc;

	private static final String NOME = "Maria de Jesus";
	private static final int    DOCUMENTO = 123;
	private static final String URL = "/pessoa";

	public String getJsonPayLoad() throws JsonProcessingException {
		PessoaDTO pessoaEntityDTO = new PessoaDTO();

		pessoaEntityDTO.setNome(NOME);
		pessoaEntityDTO.setDocumento(DOCUMENTO);

		ObjectMapper mapper = new ObjectMapper();

		return mapper.writeValueAsString(pessoaEntityDTO);
	}
	
	public PessoaEntity getMockPessoa() {
		PessoaEntity pessoaEntity = new PessoaEntity();
		
		pessoaEntity.setNome(NOME);
		pessoaEntity.setDocumento(DOCUMENTO);
		
		return pessoaEntity;
	}

	@Test
	public void testSave() throws Exception {
		mvc.perform(MockMvcRequestBuilders
					.post(URL)
					.content(getJsonPayLoad())
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isNotFound());
	}
}
