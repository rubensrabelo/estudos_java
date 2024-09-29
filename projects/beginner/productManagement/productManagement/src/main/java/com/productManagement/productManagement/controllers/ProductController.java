package com.productManagement.productManagement.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.productManagement.productManagement.models.Product;
import com.productManagement.productManagement.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> products = service.findAll();
		
		return ResponseEntity.ok().body(products);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findByID(@PathVariable Long id) {
		Product product = service.findById(id);
		
		return ResponseEntity.ok().body(product);
	}
	
	@GetMapping(value = "/name")
	public ResponseEntity<List<Product>> findByName(@RequestParam(value = "name") String name) {
		List<Product> products = service.findByName(name);
		
		return ResponseEntity.ok().body(products);
	}
	
	@GetMapping(value = "/category")
	public ResponseEntity<List<Product>> findByCategory(@RequestParam(value = "category") String category) {
		List<Product> products = service.findByCategory(category);
		
		return ResponseEntity.ok().body(products);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<List<Product>> findByNameAndCategory(
				@RequestParam(value = "name") String name,
				@RequestParam(value = "category") String category
			) {
		List<Product> products = service.findByNameAndCategory(name, category);
		
		return ResponseEntity.ok().body(products);
	}
	
	@PostMapping
	public ResponseEntity<Product> insert(@RequestBody Product product) {
		product = service.insert(product);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(product.getId()).toUri();
		
		return ResponseEntity.created(uri).body(product);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product){
		product = service.update(id, product);
		
		return ResponseEntity.ok().body(product);
	}
}
