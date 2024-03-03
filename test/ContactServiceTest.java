package com.snhu.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;

import com.snhu.entity.Contact;
import com.snhu.entity.ContactService;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

	private ContactService service;
	private Contact contact;

	@BeforeEach
	public void setUp() {
		service = new ContactService();
		contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
	}

	@Test
	public void testAddContactValid() {
		service.addContact(contact);
		assertNotNull(service);
	}

	@Test
	public void testAddContactDuplicate() {
		service.addContact(contact);
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contact);
		});
	}

	@Test
	public void testAddContactNull() {
		assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
	}

	@Test
	public void testUpdateContactValid() {
		service.addContact(contact);
		service.updateContact("1234567890", "Jane", "Doe", "0987654321", "456 Elm St");
		Contact updatedContact = service.getContact("1234567890");
		assertEquals("Jane", updatedContact.getFirstName());
		assertEquals("Doe", updatedContact.getLastName());
		assertEquals("0987654321", updatedContact.getPhone());
		assertEquals("456 Elm St", updatedContact.getAddress());
	}

	@Test
	public void testUpdateContactIdNotExist() {
		assertThrows(IllegalArgumentException.class,
				() -> service.updateContact("1234566890", "Jane", "Doe", "0987654321", "456 Elm St"));
	}

	@Test
	public void testUpdateContactNullId() {
		assertThrows(IllegalArgumentException.class,
				() -> service.updateContact(null, "Jane", "Doe", "0987654321", "456 Elm St"));
	}

	@Test
	public void testDeleteContactValid() {
		service.addContact(contact);
		service.deleteContact(contact.getContactID());
		assertNull(service.getContact(contact.getContactID()));
	}

	@Test
	public void testDeleteContactInvalidId() {
		assertThrows(IllegalArgumentException.class,() -> service.deleteContact("0999999"));
	}
	
	@Test
	public void testDeleteContactNullId() {
		assertThrows(IllegalArgumentException.class, () -> service.deleteContact(null));
	}

}
