package com.br.pessoa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.pessoa.entity.PessoaEntity;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long>{

	Optional<PessoaEntity> findByDocumentoEquals(int documento);
}
