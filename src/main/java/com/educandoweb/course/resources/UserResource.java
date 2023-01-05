package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	/* basic resource based on the User class,
	a web resource implemented by a rest controller */
	
	@Autowired
	private UserService service;
	
	// end point to access the users
	// response entities a specific type to return web requests answers
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	// end point to access user by id
	// to Spring accept the parameter we need to use PathVariable annotation
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id); 
		return ResponseEntity.ok().body(obj);  
	}
	
	// URI to return 201 created with the link to the created user
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
