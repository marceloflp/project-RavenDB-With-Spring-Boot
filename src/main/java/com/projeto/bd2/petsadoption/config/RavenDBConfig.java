package com.projeto.bd2.petsadoption.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.ravendb.client.documents.DocumentStore;

@Configuration
public class RavenDBConfig {

    @Bean
    public DocumentStore documentStore() {
		DocumentStore store = new DocumentStore("http://0.0.0.0:8080", "petsAdoption");
		store.initialize();
		return store;
	}

}
