package com.course.project.firstProject.unittests.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.course.project.firstProject.models.Person;
import com.course.project.firstProject.repositories.PersonRepository;
import com.course.project.firstProject.services.PersonService;
import com.course.project.firstProject.unittests.mapper.mocks.MockPerson;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
	
	MockPerson input;
	
	@InjectMocks
	private PersonService service;
	
	@Mock
	PersonRepository repository;
	
	
	@BeforeEach
	void setUpMocks() throws Exception {
		input = new MockPerson();
		
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByID() {
		Person person = input.mockEntity(1);
		person.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(person));
		
		var result = service.findByID(1L);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		
		assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\\\"self\\\"]"));
		
		assertEquals("Addres Test1", result.getAddress());
		assertEquals("First Name Test1", result.getFirstname());
		assertEquals("Last Name Test1", result.getLastname());
		assertEquals("Female", result.getGender());
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateV2() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
