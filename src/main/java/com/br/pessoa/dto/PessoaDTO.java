package com.br.pessoa.dto;

import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class PessoaDTO {

	@NotNull
	@Size(min = 3, max = 50, message = "O nome deve conter entre 3 e 50 caracteres")
	private String nome;
	
	@NotNull
	@Size(min = 3, max = 14, message = "O documento de conter entre 3 e 14 caracteres")
	private int documento;
}
