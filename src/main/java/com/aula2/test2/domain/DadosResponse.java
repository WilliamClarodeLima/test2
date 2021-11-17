package com.aula2.test2.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DadosResponse {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)	
	private String mensagem;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)	
	private String nome;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)	
	private int cod;

}
