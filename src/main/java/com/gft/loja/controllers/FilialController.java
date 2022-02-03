package com.gft.loja.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.loja.dto.endereco.EnderecoDTO;
import com.gft.loja.dto.filial.ConsultaFilialDTO;

@RestController
@RequestMapping("v1/filiais")
public class FilialController {
	
	@GetMapping
	public ResponseEntity<List<ConsultaFilialDTO>> buscarTodasAsFiliais(){
		
		EnderecoDTO endereco1 = new EnderecoDTO();
		endereco1.setLogradouro("Rua Hum");
		
		EnderecoDTO endereco2 = new EnderecoDTO();
		endereco2.setLogradouro("Rua Dois");
		
		ConsultaFilialDTO filial1 = new ConsultaFilialDTO();
		filial1.setNome("Loja A");
		filial1.setEndereco(endereco1);
		
		ConsultaFilialDTO filial2 = new ConsultaFilialDTO();
		filial2.setNome("Loja B");
		filial2.setEndereco(endereco2);
		
		List<ConsultaFilialDTO> lista = new LinkedList<ConsultaFilialDTO>();
		lista.add(filial1);
		lista.add(filial2);
		
		return ResponseEntity.ok(lista);		
	}
}
