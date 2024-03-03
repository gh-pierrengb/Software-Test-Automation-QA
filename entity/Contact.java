package com.snhu.entity;

public class Contact {

	private final String contactID; // Unique identifier, immutable
	private String firstName; // First name of the contact
	private String lastName; // Last name of the contact
	private String phone; // Phone number, exactly 10 digits
	private String address; // Address, max 30 characters

	/**
	 * Constructor for Contact. Validates and sets the contact's details.
	 *
	 * @param contactID Unique identifier for the contact, max 10 characters, not
	 *                  null.
	 * @param firstName First name of the contact, max 10 characters, not null.
	 * @param lastName  Last name of the contact, max 10 characters, not null.
	 * @param phone     Phone number of the contact, exactly 10 digits, not null.
	 * @param address   Address of the contact, max 30 characters, not null.
	 */
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		// Validations for each parameter
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}

		// Setting the properties
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}

	// Getters and setters with validation for the mutable fields

	public String getContactID() {
		return contactID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName != null && firstName.length() <= 10) {
			this.firstName = firstName;
		} else {
			throw new IllegalArgumentException("Invalid first name");
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName != null && lastName.length() <= 10) {
			this.lastName = lastName;
		} else {
			throw new IllegalArgumentException("Invalid last name");
		}
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone != null && phone.length() == 10 && phone.matches("\\d+")) {
			this.phone = phone;
		} else {
			throw new IllegalArgumentException("Invalid phone number");
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address != null && address.length() <= 30) {
			this.address = address;
		} else {
			throw new IllegalArgumentException("Invalid address");
		}
	}
}
