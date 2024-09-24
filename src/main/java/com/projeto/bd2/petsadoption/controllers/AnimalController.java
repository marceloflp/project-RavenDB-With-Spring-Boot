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

import com.projeto.bd2.petsadoption.entities.Animal;
import com.projeto.bd2.petsadoption.services.AnimalService;

@RestController
@RequestMapping("/animais")
public class AnimalController {

	@Autowired
	private AnimalService animalService;

	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@PostMapping
	public ResponseEntity<Animal> insert(@RequestBody Animal animal) {
		animalService.insert(animal);
		return ResponseEntity.ok(animal);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Animal> findById(@PathVariable String id) {
		Animal animal = animalService.findById(id);
		return animal != null ? ResponseEntity.ok(animal) : ResponseEntity.notFound().build();
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Animal>> findAll() {
		List<Animal> animais = animalService.findAll();
		return ResponseEntity.ok(animais);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Animal> update(@PathVariable String id, @RequestBody Animal animal) {
		animal.setId(id);
		animalService.update(animal);
		return ResponseEntity.ok(animal);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		animalService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
