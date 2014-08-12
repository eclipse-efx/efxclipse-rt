package application;

import java.util.Date;

public class Person {
	private boolean female;
	private String firstname;
	private String lastname;
	private Date birthdate;

	public Person(boolean female, String firstname, String lastname, Date birthdate) {
		this.female = female;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
	}
	
	public boolean isFemale() {
		return female;
	}
	
	public void setFemale(boolean female) {
		this.female = female;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

}
