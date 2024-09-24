package com.projeto.bd2.petsadoption.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.bd2.petsadoption.entities.Animal;
import com.projeto.bd2.petsadoption.repositories.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepository;

	public AnimalService(AnimalRepository animalRepository) {
		this.animalRepository = animalRepository;
	}

	public void insert(Animal animal) {
		animalRepository.insert(animal);
	}

	public Animal findById(String id) {
		return animalRepository.findById(id);
	}

	public List<Animal> findAll() {
		return animalRepository.findAll();
	}

	public void update(Animal animal) {
		animalRepository.update(animal);
	}

	public void delete(String id) {
		animalRepository.delete(id);
	}

}
