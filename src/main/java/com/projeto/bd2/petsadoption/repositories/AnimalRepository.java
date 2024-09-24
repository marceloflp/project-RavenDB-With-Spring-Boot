package com.projeto.bd2.petsadoption.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.bd2.petsadoption.entities.Animal;

import net.ravendb.client.documents.IDocumentStore;

@Repository
public class AnimalRepository {
	
	@Autowired
	private IDocumentStore documentStore;


	public void insert(Animal animal) {
		try (var session = documentStore.openSession()) {
			Animal pet = new Animal();
			
			pet.setId(animal.getId());
			pet.setNome(animal.getNome());
			pet.setIdade(animal.getIdade());
			pet.setEspecie(animal.getEspecie());
			
			session.store(pet);
			session.saveChanges();
		}
	}

	public Animal findById(String id) {
		try (var session = documentStore.openSession()) {
			return session.load(Animal.class, id);
		}
	}

	public List<Animal> findAll() {
		try (var session = documentStore.openSession()) {
			return session.query(Animal.class).toList();
		}
	}

	public void update(Animal animal) {
		try (var session = documentStore.openSession()) {
			session.store(animal);
			session.saveChanges();
		}
	}

	public void delete(String id) {
		try (var session = documentStore.openSession()) {
			Animal animal = session.load(Animal.class, id);
			if (animal != null) {
				session.delete(animal);
				session.saveChanges();
			}
		}
	}

}
