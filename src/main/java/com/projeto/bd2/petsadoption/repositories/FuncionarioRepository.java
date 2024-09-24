package com.projeto.bd2.petsadoption.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.bd2.petsadoption.entities.Funcionario;

import net.ravendb.client.documents.IDocumentStore;

@Repository
public class FuncionarioRepository {
	
	@Autowired
	private IDocumentStore documentStore;


	public void insert(Funcionario funcionario) {
		try (var session = documentStore.openSession()) {
			Funcionario func = new Funcionario();
			
			func.setId(funcionario.getId());
			func.setNome(funcionario.getNome());
			func.setEmail(funcionario.getEmail());
			func.setSenha(funcionario.getSenha());
			
			session.store(func);
			session.saveChanges();
		}
	}

	public Funcionario findById(String id) {
		try (var session = documentStore.openSession()) {
			return session.load(Funcionario.class, id);
		}
	}

	public List<Funcionario> findAll() {
		try (var session = documentStore.openSession()) {
			return session.query(Funcionario.class).toList();
		}
	}

	public void update(Funcionario funcionario) {
		try (var session = documentStore.openSession()) {
			Funcionario func = new Funcionario();
			
			func.setId(funcionario.getId());
			func.setNome(funcionario.getNome());
			func.setEmail(funcionario.getEmail());
			func.setSenha(funcionario.getSenha());
			session.store(func);
			session.saveChanges();
		}
	}

	public void delete(String id) {
		try (var session = documentStore.openSession()) {
			Funcionario funcionario = session.load(Funcionario.class, id);
			if (funcionario != null) {
				session.delete(funcionario);
				session.saveChanges();
			}
		}
	}

}
