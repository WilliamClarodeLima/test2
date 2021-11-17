package com.aula2.test2.business;

import org.springframework.stereotype.Service;

import com.aula2.test2.domain.DadosResponse;
import com.aula2.test2.exceptions.AppException;


@Service
public class DadosBO {
	
	public DadosResponse valida (String user) {
		DadosResponse userResponse = new DadosResponse();
		
		if(user == null){
			throw new AppException("O nome não pode ser nulo");
		}else if(user.length()<3) {
			throw new AppException("Nome incorreto!Digite um nome válido ");
		}else if(user.length()>10){
			throw new AppException("Nome inválido!Digite um nome válido ");
		}
		
		return userResponse;
	}

}
