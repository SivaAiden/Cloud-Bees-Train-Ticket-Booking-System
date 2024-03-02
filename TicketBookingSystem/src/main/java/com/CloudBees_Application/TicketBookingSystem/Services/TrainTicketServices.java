package com.CloudBees_Application.TicketBookingSystem.Services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.CloudBees_Application.TicketBookingSystem.Entity.SeatDetails;
import com.CloudBees_Application.TicketBookingSystem.Entity.TrainTicketDetails;
import com.CloudBees_Application.TicketBookingSystem.Entity.UserDetails;

@Service
public class TrainTicketServices {
	
	Map<String,TrainTicketDetails> traindetails = new HashMap<>();
	
	public void purchaseticket(String from,String to,UserDetails user, SeatDetails seat,double price) {
		TrainTicketDetails details = new TrainTicketDetails(from,to,user,price,seat);
		traindetails.put(user.getEmail(), details);
	}
	
	public TrainTicketDetails getReciptofUser(String email) {
		return traindetails.get(email);
	}
	
	public Map<String,TrainTicketDetails> getUserbySection(String section) {
		Map<String,TrainTicketDetails> sectiondetails = new HashMap<>();
		for(Map.Entry<String, TrainTicketDetails> map : traindetails.entrySet()) {
			if(map.getValue().getSeatDetails().getSeatsection().equals(section)) {
				sectiondetails.put(map.getKey(),map.getValue());
			}
		}
		return sectiondetails;
		
	}
	
	public void removeuser(String email) {
		 traindetails.remove(email);
	}
	
	public  void modifyuser(String email,int seatnumber) {
		if(traindetails.containsKey(email)) {
		TrainTicketDetails t = traindetails.get(email);
		
		t.getSeatDetails().setSeatnumber(seatnumber);
		}
	}
}
