package com.projeto.bd2.petsadoption.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.bd2.petsadoption.entities.Servico;

import net.ravendb.client.documents.IDocumentStore;

@Repository
public class ServicoRepository {
	
	@Autowired
	private IDocumentStore documentStore;


	public void insert(Servico servico) {
		try (var session = documentStore.openSession()) {
			Servico servc = new Servico();
			
			servc.setId(servico.getId());
			servc.setNome(servico.getNome());
			servc.setDescricao(servico.getDescricao());
			
			session.store(servc);
			session.saveChanges();
		}
	}

	public Servico findById(String id) {
		try (var session = documentStore.openSession()) {
			return session.load(Servico.class, id);
		}
	}

	public List<Servico> findAll() {
		try (var session = documentStore.openSession()) {
			return session.query(Servico.class).toList();
		}
	}

	public void update(Servico servico) {
		try (var session = documentStore.openSession()) {
			session.store(servico);
			session.saveChanges();
		}
	}

	public void delete(String id) {
		try (var session = documentStore.openSession()) {
			Servico servico = session.load(Servico.class, id);
			if (servico != null) {
				session.delete(servico);
				session.saveChanges();
			}
		}
	}

}
