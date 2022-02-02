package com.gft.loja.dto;

public class RegistroFilialDTO {
	
	private String name;
	private EnderecoDTO endereco;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EnderecoDTO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

}
