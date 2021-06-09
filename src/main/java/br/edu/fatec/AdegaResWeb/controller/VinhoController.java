package br.edu.fatec.AdegaResWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatec.AdegaResWeb.model.Vinho;
import br.edu.fatec.AdegaResWeb.repository.VinhoRepository;



@RestController
@RequestMapping("/")
public class VinhoController {
	
	@Autowired
	private VinhoRepository vRep;
	
	@CrossOrigin
	@GetMapping("/vinhos")
	public List<Vinho> getAllVinhos(){
		List<Vinho> listaVinho = vRep.findAll();
		
		return listaVinho;
	}
	
	@CrossOrigin
	@GetMapping("/vinho/{id}")
	public Vinho getVinhoById(@PathVariable(value = "id") long id) {

		Vinho vinho = vRep.getById(id);
		return vinho;

	}
	
	@CrossOrigin
	@GetMapping("/vinho/nome/{nome}")
	public Vinho getVinhoByNome(@PathVariable(value = "nome") String nome) {

		Vinho vinho = vRep.vinhoByName(nome);
		return vinho;

	}
	
	@CrossOrigin
	@PostMapping("/vinho")
	public ResponseEntity<String> insertAluno(@Validated @RequestBody Vinho v) {
		vRep.save(v);
		return ResponseEntity.ok("Vinho adicionado");

	}
	
	@CrossOrigin
	@PutMapping("/vinho")
	public ResponseEntity<String> updatetAluno(@Validated @RequestBody Vinho v) {
		vRep.save(v);
		return ResponseEntity.ok().body("Vinho atualizado com sucesso");
	}

	@CrossOrigin
	@DeleteMapping("/vinho/{id}")
	public ResponseEntity<String> deleteAluno(@PathVariable(value = "id") long id) {
		vRep.deleteById(id);
		return ResponseEntity.ok().body("Vinho deletado com sucesso");
	}
	

}
