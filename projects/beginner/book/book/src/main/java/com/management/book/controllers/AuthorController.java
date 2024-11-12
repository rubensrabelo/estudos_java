package com.management.book.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.management.book.models.Author;
import com.management.book.services.AuthorService;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService service;
	
	@GetMapping
	public ResponseEntity<List<Author>> findAll() {
		List<Author> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Author> findById(@PathVariable Long id) {
		Author entity = service.findByID(id);
		
		return ResponseEntity.ok().body(entity);
	}
	
	public ResponseEntity<Author> create(Author obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
}
