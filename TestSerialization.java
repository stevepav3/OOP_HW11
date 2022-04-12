/* This program uses the Person class to demonstrate
 * serialization.  It is a menu-driven program that
 * allows the user to add info to a file, view contents
 * of the file, update fields in a file, and delete
 * records.  The Person objects are added to a binary
 * file and read from the binary file using serialization.
 * 
 * Assignment: 11
 * Name: Steve Pav
 */
package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TestSerialization {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		ArrayList<Person> list = new ArrayList<>();
		
		int userChoice = 0;
		
		while(userChoice != 5) {
			
			// Make sure user enters valid selection
			do {
				displayMenu();
				userChoice = input.nextInt();
				input.nextLine();  // Go past newline character in buffer
			} while(userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 4 && userChoice != 5);
			
			System.out.println();  // Blank line
			
			// Decide what menu option to execute based on user choice
			switch(userChoice) {
				// Add information into a file
				case 1:
					// Add person to list
					list.add(newPerson());
			
					// Attempt to write entire list to file
					try {
						writeToFile(list);
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				// Retrieve information from a file and display them
				case 2:
					try {
						readFromFile();
					} catch (ClassNotFoundException | IOException e) {
						System.out.println(e.getMessage());
					}
					
					break;
					
				// Delete information
				case 3:
					deleteInfo(list);
					break;
					
				// Update information
				case 4:
					updateInfo(list);
					break;
				
				// Exit
				default:
					break;
			
			}
			
			System.out.println();  // Blank line
		}
		
	}
	
	// Write data to a binary file
	public static void writeToFile(ArrayList<Person> list) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Person.bin"));
		
		// Write entire list to file
		oos.writeObject(list);
		oos.close();
	}
	
	// Read data from a binary file
	public static void readFromFile() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Person.bin"));				
		
		// Read entire list from file
		System.out.println(ois.readObject());		
		ois.close();
	}

	// Returns new person with user-entered info
	public static Person newPerson() {
		
		// Prompt user to enter person info
		System.out.println("ADD PERSON");
		
		System.out.print("Enter name: ");
		String name = input.nextLine();
		
		System.out.print("Enter phone #: ");
		String phone = input.nextLine();
		
		System.out.print("Enter date of birth: ");
		String dob = input.nextLine();
		
		System.out.print("Enter email: ");
		String email = input.nextLine();
		
		return new Person(name, phone, dob, email);
	}
	
	
	// Updates one of the person objects
	public static void updateInfo(ArrayList<Person> list) {
		// Prompt user to enter name to search for
		System.out.print("Enter the name of the person you'd like to update: ");
		String name = input.nextLine();
		
		// Search for name in list
		for(Person p : list) {
			if(name.equals(p.getName())) {
				// Prompt user to re-enter person info
				System.out.println("UPDATE FIELDS");
				
				System.out.print("Enter name: ");
				String newName = input.nextLine();
				
				System.out.print("Enter phone #: ");
				String newPhone = input.nextLine();
				
				System.out.print("Enter date of birth: ");
				String newDob = input.nextLine();
				
				System.out.print("Enter email: ");
				String newEmail = input.nextLine();
				
				// Update information
				p.setName(newName);
				p.setPhone(newPhone);
				p.setDob(newDob);
				p.setEmail(newEmail);
				
				System.out.println("Person updated successfully.");
				
				return;
			}
		
		}
		
		System.out.println("Name not found in database.");
	}
	
	
	// Delete a record
	public static void deleteInfo(ArrayList<Person> list) {
		// Prompt user to enter name to search for
		System.out.print("Enter the name of the person you'd like to update: ");
		String name = input.nextLine();
		
		// Search for name in list
		for(Person p : list) {
			// Delete the person from the list if found
			if(name.equals(p.getName())) {
				list.remove(p);
				System.out.println(name + " deleted successfully.");
				return;
			}
		
		}
		
		System.out.println("Name not found in database.");
	}
	
	
	// Displays options for user
	public static void displayMenu() {
		System.out.println("MENU");
		System.out.println("1. Add person and update file");
		System.out.println("2. View file contents");
		System.out.println("3. Delete information");
		System.out.println("4. Update information");
		System.out.println("5. Exit");
		System.out.print("Enter your choice: ");
	}
}
