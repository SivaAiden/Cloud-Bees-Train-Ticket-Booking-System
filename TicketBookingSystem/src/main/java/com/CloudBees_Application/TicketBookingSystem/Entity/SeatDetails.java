package com.CloudBees_Application.TicketBookingSystem.Entity;

public class SeatDetails {
	private int seatnumber;
	private String seatsection;
	
	public SeatDetails(int seatnumber, String seatsection) {
		this.seatnumber = seatnumber;
		this.seatsection = seatsection;
	}
	public int getSeatnumber() {
		return seatnumber;
	}
	public void setSeatnumber(int seatnumber) {
		this.seatnumber = seatnumber;
	}
	public String getSeatsection() {
		return seatsection;
	}
	public void setSeatsection(String seatsection) {
		this.seatsection = seatsection;
	}
	
	
}
