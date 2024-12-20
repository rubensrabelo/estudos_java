package com.project.todolist.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.todolist.models.Task;
import com.project.todolist.models.User;
import com.project.todolist.services.TaskService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

	@Autowired
	private TaskService service;

	@GetMapping
	public ResponseEntity<List<Task>> findAllUserTasks() {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		List<Task> list = service.findAllUserTasks(user.getId());
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Task> findTaskById(@PathVariable Long id) {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		Task entity = service.findTaskById(id, user.getId());
		return ResponseEntity.ok().body(entity);
	}
	
	@PostMapping
	public ResponseEntity<Task> create(@RequestBody Task obj) {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		obj.setUser(user);
		
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		service.deleteTaskByIdAndUser(id, user.getId());
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value  = "/{id}")
	public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task objTask) {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		objTask = service.update(id, objTask, user.getId());
		return ResponseEntity.ok().body(objTask);
	}
}
