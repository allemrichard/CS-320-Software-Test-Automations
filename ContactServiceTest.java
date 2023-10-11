package contact;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@Test
	// Testing add contact method
	void test_addContact_Method() {
		Contact c = new Contact ("456", "Larry", "Davis", "1234567893", "800 Makeshift Drive");
		ContactService.addContact(c);
		
		ContactService.addContact("1234", "Mary", "Jane", "1111111111", "Address");
		
		// If it is greater than zero, contact is added successfully
		assertTrue(ContactService.getTotalContacts() > 0);
	

	}
	
	
	@Test
	// Testing update contact method
	void test_updateContact_Method() {
		
		
		//Updating from an empty list
		assertThrows(IllegalArgumentException.class, () ->{ContactService.updateContact("122", "Gary", '1');});
		
		
		// Add new contact to list
		Contact contact = new Contact ("9999", "Donald", "Duck", "1234569855", "810 Makeshift Drive");
		ContactService.addContact(contact);
		
		
		// No matching Contact ID found so content remains the same, "Contact not found"
		ContactService.updateContact("122", "Gary", '1');
		
		// Invalid option input
		ContactService.updateContact("9999", "Larry", '6');
		
		// Update first name
		ContactService.updateContact("9999", "Gary", '1');
		assertTrue(contact.getFirstName().equals("Gary"));
		
		// Update last name
		ContactService.updateContact("9999", "Glover", '2');
		assertTrue(contact.getLastName().equals("Glover"));
		
		// Update number
		ContactService.updateContact("9999", "5135131234", '3');
		assertTrue(contact.getNumber().equals("5135131234"));
		
		// Update Address
		ContactService.updateContact("9999", "1110 Madeup Drive", '4');
		assertTrue(contact.getAddress().equals("1110 Madeup Drive"));
	}
	
	
	@Test
	// Testing delete contact method
	void test_deleteContact_Method() {
		
		// Deleting with invalid input
		assertThrows(IllegalArgumentException.class, () ->{ContactService.deleteContact("1234564894846");});
		
		
		// Deleting non existing contact
		// "Contact Not found"
		ContactService.deleteContact("1212");
		
		
		// Contacts deleted successfully so contact list has zero contacts
		ContactService.deleteContact("9999");
		assertTrue(ContactService.getTotalContacts() == 0);
		
	}

}
