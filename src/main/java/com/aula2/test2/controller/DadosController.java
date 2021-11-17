package com.aula2.test2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aula2.test2.business.DadosBO;
import com.aula2.test2.domain.DadosResponse;
import com.aula2.test2.exceptions.AppException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("Hello_World/V1/test")

public class DadosController {

	@Autowired
	private DadosBO dadosbo;
	
	@GetMapping
	public ResponseEntity <DadosResponse> retornarNome(@RequestParam(name = "nome") String nome){
		ResponseEntity <DadosResponse> resposta = null;
		
		try {
			DadosResponse msgResposta = dadosbo.valida(nome);
			msgResposta.setMensagem("Olá Mundo! " + nome);
			msgResposta.setCod(200);
			resposta = new ResponseEntity(msgResposta, HttpStatus.OK);
			return resposta;
		}catch(AppException app){
			String mensagem = app.getMessage();
			HttpStatus status = HttpStatus.BAD_REQUEST;
			resposta = obterRespostaErro(mensagem, status);
			return resposta;
		}catch(Exception e) {
			return obterRespostaErro("Serviço indisponível", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	private ResponseEntity <DadosResponse> obterRespostaErro(String mensagem , HttpStatus status){
		ResponseEntity <DadosResponse> resposta;
		DadosResponse msgResposta = new DadosResponse();
		msgResposta.setMensagem(mensagem);
		msgResposta.setCod(status.value());
		resposta = new ResponseEntity<>(msgResposta,status);
		return resposta;
	}
	
	

}
