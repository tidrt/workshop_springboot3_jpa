package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	/* basic resource based on the Product class,
	a web resource implemented by a rest controller */
	
	@Autowired
	private ProductService service;
	
	// end point to access the users
	// response entities a specific type to return web requests answers
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	// end point to access user by id
	// to Spring accept the parameter we need to use PathVariable annotation
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id); 
		return ResponseEntity.ok().body(obj);  
	}
	
}
