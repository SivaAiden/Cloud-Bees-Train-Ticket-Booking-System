package com.CloudBees_Application.TicketBookingSystem.Entity;

public class TrainTicketDetails {
	private String From;
	private String To;
	private UserDetails userdetails;
	private double price;
	private SeatDetails SeatDetails;
	
	public TrainTicketDetails(String From,String To,UserDetails userdetails,double price,SeatDetails SeatDetails) {
		this.From = From;
		this.To = To;
		this.price = price;
		this.userdetails = userdetails;
		this.SeatDetails = SeatDetails;
	}

	public String getFrom() {
		return From;
	}

	public void setFrom(String from) {
		From = from;
	}

	public String getTo() {
		return To;
	}

	public void setTo(String to) {
		To = to;
	}

	public UserDetails getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public SeatDetails getSeatDetails() {
		return SeatDetails;
	}

	public void setSeatDetails(SeatDetails seatDetails) {
		SeatDetails = seatDetails;
	}
	
	
	
	
}
