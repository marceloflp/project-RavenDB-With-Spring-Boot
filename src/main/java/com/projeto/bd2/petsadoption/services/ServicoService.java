package com.projeto.bd2.petsadoption.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.bd2.petsadoption.entities.Servico;
import com.projeto.bd2.petsadoption.repositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;

	public ServicoService(ServicoRepository servicoRepository) {
		this.servicoRepository = servicoRepository;
	}

	public void insert(Servico servico) {
		servicoRepository.insert(servico);
	}

	public Servico findById(String id) {
		return servicoRepository.findById(id);
	}

	public List<Servico> findAll() {
		return servicoRepository.findAll();
	}

	public void update(Servico servico) {
		servicoRepository.update(servico);
	}

	public void delete(String id) {
		servicoRepository.delete(id);
	}

}
