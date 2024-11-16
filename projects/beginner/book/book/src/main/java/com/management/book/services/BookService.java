package com.management.book.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.book.models.Author;
import com.management.book.models.Book;
import com.management.book.models.Category;
import com.management.book.repositories.AuthorRepository;
import com.management.book.repositories.BookRepository;
import com.management.book.repositories.CategoryRepository;
import com.management.book.services.exceptions.ResourceNotFoundException;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	public Book findById(Long id) {
		Optional<Book> entity = bookRepository.findById(id);
		
		return entity.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Book create(Book book) {
		Author author = authorRepository.findById(book.getAuthor().getId())
				.orElseThrow(() -> new ResourceNotFoundException(book.getAuthor().getId()));
		
		 Set<Category> validCategory = book.getCategories().stream()
				 .map(cat -> categoryRepository.findById(cat.getId())
						 .orElseThrow(() -> new ResourceNotFoundException(cat.getId())))
				 .collect(Collectors.toSet());
		 
		book.setAuthor(author);
		book.addCategory(validCategory);
		
		return bookRepository.save(book);
	}
}
