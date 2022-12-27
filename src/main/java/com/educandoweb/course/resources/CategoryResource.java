package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	/* basic resource based on the Category class,
	a web resource implemented by a rest controller */
	
	@Autowired
	private CategoryService service;
	
	// end point to access the users
	// response entities a specific type to return web requests answers
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	// end point to access user by id
	// to Spring accept the parameter we need to use PathVariable annotation
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id); 
		return ResponseEntity.ok().body(obj);  
	}
	
}
