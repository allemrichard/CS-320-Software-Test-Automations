package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void test_Contact_Setters_And_Getters() {
		Contact contact = new Contact ("123456", "John", "Smith", "1234567890", "1112 Makeshift Drive");
		
		// call setters
		contact.setFirstName("John");
		contact.setLastName("Smith");
		contact.setNumber("1234567890");
		contact.setAddress("1112 Makeshift Drive");
	
		
		// assert if getters and setters works
		assertEquals("123456", contact.getContactId());
		assertEquals("John", contact.getFirstName());
		assertEquals("Smith", contact.getLastName());
		assertEquals("1234567890", contact.getNumber());
		assertEquals("1112 Makeshift Drive", contact.getAddress());
		
		
		// If setter conditionals work
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setFirstName(null);
		});
						
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setLastName(null);
		});
						
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setNumber(null);
		});
						
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setAddress(null);
		});
					
	}
	
	@Test
	// Testing for if all arguments are null
	void test_Contact_Null_Arguments() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, null, null, null, null);
		});
	}
	
	
	
	
	@Test
	// Testing for invalid inputs
	void test_Contact_invalid_Arguments() {
		
		// Contact ID exceeding limit
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("12345678987", "Name", "Last", "1234567899", "Street Address");
		});
		
		// First name exceeding limit
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234", "Mary Jane Watson", "Last", "1234567899", "Street Address");
		});
		
		// Last name exceeding limit
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234", "First", "Last Name exceeds", "1234567899", "Street Address");
		});
		
		// Phone number under 10 digits
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234", "Name", "Last", "12345", "Street Address");
		});
		
		// Address exceeding limit
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("1234", "Name", "Last", "1234567899" ,"1234 5th Invalid Street, New York City, New York");
		});
		
		
	}

}
