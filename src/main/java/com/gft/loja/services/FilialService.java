package com.gft.loja.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gft.loja.entities.Filial;
import com.gft.loja.repositiries.FilialRepository;

@Service
public class FilialService {
	private final FilialRepository filialRepository;
	
	public FilialService(FilialRepository filialRepository) {
		this.filialRepository = filialRepository;
	}
	
	public Filial salvarFilial(Filial filial) {
		return filialRepository.save(filial);
	}
	
	public List<Filial> listarTodasAsFiliais() {
		return filialRepository.findAll();
	}
}
