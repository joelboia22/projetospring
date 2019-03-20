package com.p2lp2.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.p2lp2.dominio.Freelancer;
import com.p2lp2.repositorio.FreelancerRepositorio;


@RestController
public class FreelancerResource {
	
	@Autowired
	private FreelancerRepositorio repositorio;
	
	@GetMapping
	public List<Freelancer> getAllFuncionario(){
		List<Freelancer> freelancer = repositorio.findAll();
		return freelancer;
	}
	
	@PostMapping("/freelancers")
	public ResponseEntity<?>saveFreelancer(@RequestBody Freelancer freelancer){
		Freelancer saveFreelancer = repositorio.save(freelancer);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(saveFreelancer.getId()).toUri();
		
		return ResponseEntity.created(uri).body("name: " + saveFreelancer.getNome() + "id: " + saveFreelancer.getId());
		
	}

	@PutMapping("/freelancers/{id}")
	public ResponseEntity<?> updateFuncionario(@RequestBody Freelancer freelancer, @PathVariable int id){
		Optional<Freelancer> freelancerFound = repositorio.findById(id);
		
		if (!freelancerFound.isPresent()) 
			return ResponseEntity.notFound().build();
		
		freelancer.setId(id);
		repositorio.save(freelancer);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/freelancers/{id}")
	public void deleteFreelancer(@PathVariable int id) {
		Optional<Freelancer> freelancerFound = repositorio.findById(id);
		
		if (freelancerFound.isPresent()){
			repositorio.deleteById(id);	
		}
		
	}

}
