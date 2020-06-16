package com.br.pessoa.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pessoa.entity.PessoaEntity;
import com.br.pessoa.repository.PessoaRepository;
import com.br.pessoa.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService{

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public PessoaEntity save(PessoaEntity pessoaEntity) {
		return pessoaRepository.save(pessoaEntity);
	}

	@Override
	public Optional<PessoaEntity> findByDocumento(int documento) {
		return pessoaRepository.findByDocumentoEquals(documento);
	}

}
