package com.snhu.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.snhu.entity.Contact;

class ContactTest {

	@Test
	@DisplayName("Test Valid Constructor")
	public void testContactCreationValid() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
		assertNotNull(contact);
	}

	@Test
	@DisplayName("Group Test Invalid ID")
	public void testContactCreationInvalidID() {

		assertAll("Testing invalid Contact IDs", () -> assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Doe", "1234567890", "123 Main St");
		}),

				() -> assertThrows(IllegalArgumentException.class, () -> {
					new Contact("F1234567890A", "John", "Doe", "1234567890", "123 Main St");
				}));
	}

	@DisplayName("Group Test Invalid First Name")
	@Test
	public void testContactCreationInvalidFirstName() {
		assertAll("Testing invalid First Names", () -> assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", null, "Doe", "1234567890", "123 Main St");
		}), () -> assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Jean de Dieu", "Doe", "1234567890", "123 Main St");
		}));

	}

	@DisplayName("Group Test Invalid Last Name")
	@Test
	public void testContactCreationInvalidLastName() {
		assertAll(() -> assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "John", null, "1234567890", "123 Main St");
		}),

				() -> assertThrows(IllegalArgumentException.class, () -> {
					new Contact("1234567890", "John", "Tshisuku Mashinda", "1234567890", "123 Main St");
				}));
	}

	@DisplayName("Group Test invalid Phone Number")
	@Test
	public void testContactCreationInvalidPhoneNumber() {
		assertAll(() -> assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "John", "Doe", "12345678905", "123 Main St");
		}),

				() -> assertThrows(IllegalArgumentException.class, () -> {
					new Contact("1234567890", "John", "Doe", null, "123 Main St");
				})

		);
	}

	@DisplayName("Group Test invalid address")
	@Test
	public void testContactCreationInvalidAddress() {
		assertAll(() -> assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "John", "Doe", "1234567890",
					"1235  South Main St, Arkansas - Louisianna, MA 02750");
		}), () -> assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "John", "Doe", "1234567890", null);
		}));

	}

	@Test
	public void testSetFirstNameValid() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
		contact.setFirstName("Jane");
		assertEquals("Jane", contact.getFirstName());
	}

	@Test
	public void testSetFirstNameInvalid() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("Jean de Dieu"));
	}

	@Test
	public void testSetFirstNameNull() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
	}

	@Test
	public void testSetLastNameValid() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
		contact.setLastName("Peter");
		assertEquals("Peter", contact.getLastName());
	}

	@Test
	public void testSetlastNameInvalid() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, () -> contact.setLastName("Tshisuku Mashinda"));
	}

	@Test
	public void testSetLastNameNull() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
	}

	@Test
	public void testSetPhoneValid() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
		contact.setPhone("1236547890");
		assertEquals("1236547890", contact.getPhone());
	}

	@Test
	public void testSetPhoneInvalid() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345678905"));
	}

	@Test
	public void testSetPhoneNull() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
	}

	@Test
	public void testSetAddressValid() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
		contact.setAddress("123 Main St");
		assertEquals("123 Main St", contact.getAddress());
	}

	@Test
	public void testSetAddressInvalid() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class,
				() -> contact.setAddress("1235  South Main St, Arkansas - Louisianna, MA 02750"));
	}

	@Test
	public void testSetAddressNull() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
	}

}
