package com.p2lp2.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.p2lp2.dominio.Funcionario;
import com.p2lp2.repositorio.FuncionarioRepositorio;

import java.net.URI;
import java.util.List;
import java.util.Optional;



@RestController
public class FuncionarioResource {
	
	@Autowired
	private FuncionarioRepositorio repositorio;
	
	@GetMapping("/Funcionarios")
	public List<Funcionario> getAllFuncionario(){
		List <Funcionario> funcionarios = repositorio.findAll();
		return funcionarios;	
	}
	
	@PostMapping("/funcionarios")
	public ResponseEntity<?>saveFuncionario(@RequestBody Funcionario funcionario){
		Funcionario savedFuncionario = repositorio.save(funcionario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(savedFuncionario.getId()).toUri();
		
		return  ResponseEntity.created(uri).body("name: " + savedFuncionario.getNome() + "id: " + savedFuncionario.getId());		
	}
	
	@PutMapping("/funcionarios/{id}")
	public ResponseEntity<?> updateFuncionario(@RequestBody Funcionario funcionario, @PathVariable int id){ 
		Optional<Funcionario> funcionarioFound = repositorio.findById(id);
		
		if (!funcionarioFound.isPresent())
			return ResponseEntity.notFound().build();
		
		funcionario.setId(id);
		repositorio.save(funcionario);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/funcionarios/{id}")
	public void deleteFuncionario(@PathVariable int id) {
		Optional<Funcionario> funcionarioFound = repositorio.findById(id);
		
		if(funcionarioFound.isPresent()) {
			repositorio.deleteById(id);
		}
		
	}
	
	
	

}
