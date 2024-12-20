package com.management.book.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_author")
public class Author implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String nationality;
	private String biography;
	
	@JsonIgnore
	@OneToMany(mappedBy = "author")
	private Set<Book> books = new HashSet<>();
	
	public Author() {
	}

	public Author(Long id, String name, String nationality, String biography) {
		this.id = id;
		this.name = name;
		this.nationality = nationality;
		this.biography = biography;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}
	
	public Set<Book> getBooks() {
		return books;
	}

	public void addBook(Book book) {
		this.books.add(book);
		book.setAuthor(this);
	}
	
	public void removeBook(Book book) {
		this.books.remove(book);
		book.setAuthor(null);
	}

	@Override
	public int hashCode() {
		return Objects.hash(biography, id, name, nationality);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(biography, other.biography) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(nationality, other.nationality);
	}
}
