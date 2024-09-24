package com.projeto.bd2.petsadoption.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.bd2.petsadoption.entities.Funcionario;
import com.projeto.bd2.petsadoption.services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@PostMapping
	public ResponseEntity<Funcionario> insert(@RequestBody Funcionario funcionario) {
		funcionarioService.insert(funcionario);
		return ResponseEntity.ok(funcionario);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Funcionario> findById(@PathVariable String id) {
		Funcionario funcionario = funcionarioService.findById(id);
		return funcionario != null ? ResponseEntity.ok(funcionario) : ResponseEntity.notFound().build();
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Funcionario>> findAll() {
		List<Funcionario> funcionarios = funcionarioService.findAll();
		return ResponseEntity.ok(funcionarios);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Funcionario> update(@PathVariable String id, @RequestBody Funcionario funcionario) {
		funcionario.setId(id);
		funcionarioService.update(funcionario);
		return ResponseEntity.ok(funcionario);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		funcionarioService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
