package com.CloudBees_Application.TicketBookingSystem.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CloudBees_Application.TicketBookingSystem.Entity.SeatDetails;
import com.CloudBees_Application.TicketBookingSystem.Entity.UserDetails;
import com.CloudBees_Application.TicketBookingSystem.Entity.TrainTicketDetails;
import com.CloudBees_Application.TicketBookingSystem.Services.TrainTicketServices;

@RestController
//@RequestMapping("/api/purchase")
public class TrainTicketController {
	
	@Autowired
	private TrainTicketServices service;
	
	@PostMapping("/purchase")
	public String createticket( @RequestBody TrainTicketDetails Traindetails ) {
			
	service.purchaseticket( Traindetails.getFrom(), Traindetails.getTo(), Traindetails.getUserdetails(),Traindetails.getSeatDetails(), Traindetails.getPrice());
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
