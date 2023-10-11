package contact;
import java.util.Vector;


public class ContactService {
	
	// Vector to store contacts
	private static Vector<Contact> contactList = new Vector<Contact>();

	
	// Number of contacts in list
	private static int totalContacts = 0;
	
	// To get total number of contacts
	public static int getTotalContacts() {
		return totalContacts;
	}
	
	
	
	
	// Methods to add contacts
	public static void addContact(String contactId, String firstName, String lastName, String number, String address) {
		Contact newContact = new Contact(contactId, firstName, lastName, number, address);
		
		contactList.add(newContact);
		totalContacts ++;
	}
	public static void addContact(Contact contact) {
		contactList.add(contact);
		totalContacts ++;
	}
	
	
	
	
	// Methods to delete contacts per contact ID
	public static void deleteContact (String contactId) {
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		
		// If there are no contacts in list to begin with
		if (contactList.isEmpty()) {
			throw new IllegalArgumentException("No Contacts in list");
		}
	
		int index = -1;
		// Loop through vector to search for contact ID
		for (Contact contact : contactList) {
			if (contact.getContactId() == contactId) {
			index = contactList.indexOf(contact);
			}
		}
		
		if (index == -1) {
			System.out.println("Contact not Found");
			return;
		}
		
		// If contact ID found, removes it and updates number of contacts
		else {
			contactList.remove(index);
			totalContacts --;
			System.out.println("Contact Removed.");
		}
	}
	
	public static void deleteContact(Contact contact) {
		contactList.remove(contact);
		totalContacts --;
	}
	
	
	/* Menu Option for updating Contact
	 * "To update First Name press 1"
	 * "To update Last Name press 2"
	 * "To update Phone Number press 3"
	 * "To update Address press 4"
	 */
	
	
	// Method to update contact fields
	public static void updateContact (String contactId, String updated, char selection) {
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		
		// If there are no contacts in list to begin with
		if (contactList.isEmpty()) {
			throw new IllegalArgumentException("No Contacts in list");
		}

		int index = -1;
		// Loop through vector to search for contact ID
		for (Contact contact : contactList) {
			index = contactList.indexOf(contact);
		}
		
		if (index == -1) {
			System.out.println("Contact not Found");
			return;
		}
		
		Contact updateContact = contactList.get(index);
		
				// Would require input from user
				switch(selection) {
					case '1': {
						updateContact.setFirstName(updated);
						System.out.println("First Name updated");
						break;
					}
					case '2': {
						updateContact.setLastName(updated);
						System.out.println("Last Name updated");
						break;
					}
					case '3': {
						updateContact.setNumber(updated);
						System.out.println("Phone Number updated");
						break;
					}
					case '4': {
						updateContact.setAddress(updated);
						System.out.println("Address updated");
						break;
					}
					default: {
						System.out.println("Contact not updated, invalid change requested.");
						break;
					}
				}
				
				ContactService.deleteContact(contactList.elementAt(index));
				ContactService.addContact(updateContact);
				
			}
		}


