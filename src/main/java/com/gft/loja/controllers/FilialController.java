package com.gft.loja.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.loja.dto.filial.ConsultaFilialDTO;
import com.gft.loja.dto.filial.FilialMapper;
import com.gft.loja.dto.filial.RegistroFilialDTO;
import com.gft.loja.entities.Filial;
import com.gft.loja.services.FilialService;

@RestController
@RequestMapping("v1/filiais")
public class FilialController {

	private final FilialService filialService;
	
	public FilialController(FilialService filialService) {
		this.filialService = filialService;
	}

	@GetMapping
	public ResponseEntity<List<ConsultaFilialDTO>> buscarTodasAsFiliais(){
		
		// EnderecoDTO endereco1 = new EnderecoDTO();
		// endereco1.setLogradouro("Rua Hum");
		
		// EnderecoDTO endereco2 = new EnderecoDTO();
		// endereco2.setLogradouro("Rua Dois");
		
		// ConsultaFilialDTO filial1 = new ConsultaFilialDTO();
		// filial1.setNome("Loja A");
		// filial1.setEndereco(endereco1);
		
		// ConsultaFilialDTO filial2 = new ConsultaFilialDTO();
		// filial2.setNome("Loja B");
		// filial2.setEndereco(endereco2);
		
		// List<ConsultaFilialDTO> lista = new LinkedList<ConsultaFilialDTO>();
		// lista.add(filial1);
		// lista.add(filial2);

		
		return ResponseEntity.ok(filialService.listarTodasAsFiliais().stream().map(FilialMapper::fromEntity).collect(Collectors.toList()));		
	}

	@PostMapping
	public ResponseEntity<ConsultaFilialDTO> salvarFilial(@RequestBody RegistroFilialDTO dto){
		Filial filial = filialService.salvarFilial(FilialMapper.fromDTO(dto));
		return ResponseEntity.ok(FilialMapper.fromEntity(filial));
	}

	@GetMapping("{id}")
	public ResponseEntity<ConsultaFilialDTO> buscarFilial(@PathVariable Long id){
		try{
			Filial filial = filialService.buscarFilial(id);
			return ResponseEntity.ok(FilialMapper.fromEntity(filial));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("{id}")
	public ResponseEntity<ConsultaFilialDTO> alterarFilial(@RequestBody RegistroFilialDTO dto, @PathVariable Long id){
		try{
			Filial filial = filialService.atualizarFilial(FilialMapper.fromDTO(dto), id);
			return ResponseEntity.ok(FilialMapper.fromEntity(filial));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}	
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaFilialDTO> excluirFilial(@PathVariable Long id){
		try{
			filialService.excluirFilial(id);
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}	


	}
}
