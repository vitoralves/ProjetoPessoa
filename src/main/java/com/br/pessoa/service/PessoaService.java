package com.br.pessoa.service;

import java.util.Optional;

import com.br.pessoa.entity.PessoaEntity;

public interface PessoaService {

	PessoaEntity save(PessoaEntity pessoaEntity);
	
	Optional<PessoaEntity> findByDocumento(int documento);
}
