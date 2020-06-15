package com.br.pessoa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PessoaEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5269545429225755218L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPessoa;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private int documento;
}
