package com.br.pessoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pessoa.dto.PessoaDTO;
import com.br.pessoa.entity.PessoaEntity;
import com.br.pessoa.response.Response;
import com.br.pessoa.service.PessoaService;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping("create")
	public ResponseEntity<Response<PessoaDTO>> create(@RequestBody 
													  @Validated
													  PessoaDTO pessoaDTO,
													  BindingResult result) {
		Response<PessoaDTO> responseDTO = new Response<PessoaDTO>();
		
		PessoaEntity responseService = pessoaService.save(this.parseDtoToEntity(pessoaDTO));
		
		responseDTO.setData(this.parseEntityToDto(responseService));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
	}
	
	private PessoaEntity parseDtoToEntity(PessoaDTO pessoaDTO) {
		PessoaEntity pessoaEntity = new PessoaEntity();
		
		pessoaEntity.setNome(pessoaDTO.getNome());
		pessoaEntity.setDocumento(pessoaDTO.getDocumento());
		
		return pessoaEntity;
	}
	
	private PessoaDTO parseEntityToDto(PessoaEntity pessoaEntity) {
		PessoaDTO pessoaDTO = new PessoaDTO();
		
		pessoaDTO.setNome(pessoaEntity.getNome());
		pessoaDTO.setDocumento(pessoaEntity.getDocumento());
		
		return pessoaDTO;
	}
}
