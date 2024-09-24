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

import com.projeto.bd2.petsadoption.entities.Servico;
import com.projeto.bd2.petsadoption.services.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

	@Autowired
	private ServicoService servicoService;

	public ServicoController(ServicoService servicoService) {
		this.servicoService = servicoService;
	}

	@PostMapping
	public ResponseEntity<Servico> insert(@RequestBody Servico servico) {
		servicoService.insert(servico);
		return ResponseEntity.ok(servico);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Servico> findById(@PathVariable String id) {
		Servico servico = servicoService.findById(id);
		return servico != null ? ResponseEntity.ok(servico) : ResponseEntity.notFound().build();
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Servico>> findAll() {
		List<Servico> servicos = servicoService.findAll();
		return ResponseEntity.ok(servicos);
	}

	@PutMapping("/update{id}")
	public ResponseEntity<Servico> update(@PathVariable String id, @RequestBody Servico servico) {
		servico.setId(id);
		servicoService.update(servico);
		return ResponseEntity.ok(servico);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		servicoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
