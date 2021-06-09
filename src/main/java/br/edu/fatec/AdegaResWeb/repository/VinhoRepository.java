package br.edu.fatec.AdegaResWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatec.AdegaResWeb.model.Vinho;


public interface VinhoRepository extends JpaRepository<Vinho, Long>{
	
	Vinho vinhoByName(String nome);
}
