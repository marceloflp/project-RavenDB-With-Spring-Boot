package com.projeto.bd2.petsadoption.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.bd2.petsadoption.entities.Funcionario;
import com.projeto.bd2.petsadoption.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void insert(Funcionario funcionario) {
		funcionarioRepository.insert(funcionario);
	}

	public Funcionario findById(String id) {
		return funcionarioRepository.findById(id);
	}

	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll();
	}

	public void update(Funcionario funcionario) {
		funcionarioRepository.update(funcionario);
	}

	public void delete(String id) {
		funcionarioRepository.delete(id);
	}

}
