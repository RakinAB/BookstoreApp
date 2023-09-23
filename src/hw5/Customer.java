package hw5;

import java.util.ArrayList;

/**
 * @author rakinbhuyan
 *
 */
public class Customer {
	
	private String firstName, lastName, email, address, phoneNum;
	
	//Each customer will have their own array of books
	public ArrayList<Book> books = new ArrayList<Book>();
	
	public Customer(String fName, String lName, String email, String address, String phone) {
		this.setFirstName(fName);
		this.setLastName(lName);
		this.setEmail(email);
		this.setAddress(address);
		this.setPhoneNum(phone);
	}
	
	/*
	 * If a customer wants to rent a book, 
	 * the program will take the book object
	 * and add it to the Array of books the 
	 * customer already has
	 * 
	 * @param book
	 */

	//Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	/*
	 * This ToString method will output the full information of a customer
	 */
	public String toString() {
		return "Name: " + this.firstName + " " + this.lastName + "	Email: " + this.email 
				+ "\nAddress: " + this.address + "	Phone#: " + this.phoneNum + "\n\n";
	}
}

