package com.projeto.bd2.petsadoption.entities;

import java.util.Objects;

public class Animal {
	
	private String id;
	private String nome;
	private String especie;
	private int idade;
	
	public Animal() {
		
	}
	
	public Animal(String id, String nome, String especie, int idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.especie = especie;
		this.idade = idade;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
