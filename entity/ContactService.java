package com.snhu.entity;

import java.util.Map;
import java.util.HashMap;

public class ContactService {

	private final Map<String, Contact> contacts = new HashMap<>();

	/**
	 * Adds a new contact to the service.
	 *
	 * @param contact The contact to add. Must not be null and must have a unique
	 *                ID.
	 * @throws IllegalArgumentException If the contact is null or already exists.
	 */
	public void addContact(Contact contact) {
		if (contact != null && !contacts.containsKey(contact.getContactID())) {
			contacts.put(contact.getContactID(), contact);
		} else {
			throw new IllegalArgumentException("Contact already exists or is invalid");
		}
	}

	/**
	 * Deletes a contact from the service.
	 *
	 * @param contactID The ID of the contact to delete.
	 * @throws IllegalArgumentException If the contact ID is null or does not exist.
	 */
	public void deleteContact(String contactID) {
		if (contactID != null && contacts.containsKey(contactID)) {
			contacts.remove(contactID);
		} else {
			throw new IllegalArgumentException("Contact does not exist");
		}
	}

	/**
	 * Updates the specified fields of an existing contact.
	 *
	 * @param contactID The ID of the contact to update.
	 * @param firstName The new first name (nullable).
	 * @param lastName  The new last name (nullable).
	 * @param phone     The new phone number (nullable).
	 * @param address   The new address (nullable).
	 * @throws IllegalArgumentException If the contact does not exist or parameters
	 *                                  are invalid.
	 */
	public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
		Contact contact = contacts.get(contactID);
		if (contact != null) {
			if (firstName != null)
				contact.setFirstName(firstName);
			if (lastName != null)
				contact.setLastName(lastName);
			if (phone != null)
				contact.setPhone(phone);
			if (address != null)
				contact.setAddress(address);
		} else {
			throw new IllegalArgumentException("Contact does not exist");
		}
	}

	/**
	 * Retrieves a contact by ID.
	 *
	 * @param contactID The ID of the contact to retrieve.
	 * @return The contact with the specified ID.
	 * @throws IllegalArgumentException If the contact ID is null or does not exist.
	 */
	public Contact getContact(String contactID) {
		if (contactID != null) {
			return contacts.get(contactID);
		} else {
			throw new IllegalArgumentException("Contact does not exist");
		}
	}
}
