package serialization;

import java.io.Serializable;

public class Person implements Serializable {
	private String name;
	private String phone;
	private String dob;
	private String email;
	
	/*
	 * CONSTRUCTORS
	 */
	public Person() {
		name = "Steve Pav";
		phone = "1234567890";
		dob = "3/13/2000";
		email = "stevepav3@gmail.com";
	}
	
	public Person(String name, String phone, String dob, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.dob = dob;
		this.email = email;
	}
	
	/*
	 * ACCESSOR AND MUTATOR METHODS
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Overriding toString() method	
	@Override
	public String toString() {
		return "Person [name=" + name + ", phone=" + phone + ", dob=" + dob + ", email=" + email + "]\n";
	}
	
	
	
}
