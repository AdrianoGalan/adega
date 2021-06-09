package br.edu.fatec.AdegaResWeb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name= "vinho")
@NamedNativeQuery(name = "Vinho.vinhoByName", query = "select id, nome, safra, preco from VINHO "
		+ "WHERE nome = (?1)", resultClass = Vinho.class)
public class Vinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column
	private String nome;
	
	@Column
	private String safra;
	
	@Column
	private double preco;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSafra() {
		return safra;
	}

	public void setData(String safra) {
		this.safra = safra;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Vinho [id=" + id + ", nome=" + nome + ", safra=" + safra + ", preco=" + preco + "]";
	}
	

}
