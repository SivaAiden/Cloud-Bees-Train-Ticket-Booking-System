package com.CloudBees_Application.TicketBookingSystem.Entity;

public class UserDetails {
	private String First_name;
	private String Last_name;
	private String Email;
	
	public UserDetails(String First_name, String Last_name,String Email) {
		this.First_name = First_name;
		this.Last_name = Last_name;
		this.Email = Email;
	}

	public String getFirst_name() {
		return First_name;
	}

	public void setFirst_name(String first_name) {
		First_name = first_name;
	}

	public String getLast_name() {
		return Last_name;
	}

	public void setLast_name(String last_name) {
		Last_name = last_name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
}
