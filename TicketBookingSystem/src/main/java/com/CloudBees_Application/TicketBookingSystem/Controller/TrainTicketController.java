package com.CloudBees_Application.TicketBookingSystem.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CloudBees_Application.TicketBookingSystem.Entity.SeatDetails;
import com.CloudBees_Application.TicketBookingSystem.Entity.UserDetails;
import com.CloudBees_Application.TicketBookingSystem.Entity.TrainTicketDetails;
import com.CloudBees_Application.TicketBookingSystem.Services.TrainTicketServices;

@RestController
@RequestMapping("/api")
public class TrainTicketController {
	
	@Autowired
	private TrainTicketServices service;
	
	
	@PostMapping("/purchase")
	public String createticket(@RequestParam String From,@RequestParam String To,
			@RequestParam UserDetails user,@RequestParam double price,@RequestParam SeatDetails seat) {
		//UserDetails user = new UserDetails(First_name, Last_name, Email);
		//SeatDetails seat = new SeatDetails(seatnumber, seatsection);
		service.purchaseticket( From,  To,user,seat, price);
		return "Ticket Booked Successully";
	}
	
	@GetMapping("/user/reciept/{Email}")
	public TrainTicketDetails RecieptofUser(@PathVariable String Email) {
		return service.getReciptofUser(Email);
	}
	
	@GetMapping("/user/section/{seatsection}")
	public Map<String,TrainTicketDetails> getUserbySection(@PathVariable String seatsection){
		 return service.getUserbySection(seatsection);
	}
	
	@DeleteMapping("/remove/{Email}")
	public String removetheuser(@PathVariable String Email) {
		service.removeuser(Email);
		return "User removed Successfully";
	}
	
	@PutMapping("/modify/{Email}")
	public String modifyUserseat(@PathVariable String Email,@RequestParam int seatnumber) {
		service.modifyuser(Email,seatnumber);
		return "User Seat Modified Successfully";
	}
}
