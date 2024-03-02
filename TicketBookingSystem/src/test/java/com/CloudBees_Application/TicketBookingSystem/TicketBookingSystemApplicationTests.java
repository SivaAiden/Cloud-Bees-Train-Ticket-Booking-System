package com.CloudBees_Application.TicketBookingSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import com.CloudBees_Application.TicketBookingSystem.Entity.SeatDetails;
import com.CloudBees_Application.TicketBookingSystem.Entity.TrainTicketDetails;
import com.CloudBees_Application.TicketBookingSystem.Entity.UserDetails;
import com.CloudBees_Application.TicketBookingSystem.Services.TrainTicketServices;
import java.util.*;

@SpringBootTest
class TicketBookingSystemApplicationTests {

	private TrainTicketServices  service;
	@Test
	void contextLoads() {
	}
	
	@BeforeEach
	void Value() {
		service = new TrainTicketServices();
	}
	
	@Test
	void purchaseTicket() {
		UserDetails user = new UserDetails("Siva","S","siva@gmail.com");
		//UserDetails user1 = new UserDetails("darun","n","darun@gmail.com");
		
		SeatDetails s1 = new SeatDetails(1,"A");
		
		service.purchaseticket("London", "Europe", user, s1, 1000.2);
		
		assertNotNull(service.getReciptofUser(user.getEmail()));
		assertEquals(user.getEmail(),service.getReciptofUser(user.getEmail()).getUserdetails().getEmail());
	}
	
	@Test
	void RecieptofUser() {
		
		System.out.println("<---------------------------Reciept of User Output TestCase-------------------------->");
		UserDetails user = new UserDetails("Siva","S","siva@gmail.com");
		UserDetails user1 = new UserDetails("darun","n","darun@gmail.com");
		
		SeatDetails s1 = new SeatDetails(1,"A");
		SeatDetails s2 = new SeatDetails(1,"A");
		
		service.purchaseticket("London", "Paris", user, s1, 20.0 );
		service.purchaseticket("London", "Europe", user1, s2, 1000.2);
		
		
		TrainTicketDetails t = service.getReciptofUser("darun@gmail.com");
		System.out.println("Name "+t.getFrom()+"  "+t.getSeatDetails().getSeatnumber());
		
		assertNotNull(t);
		assertEquals("London", t.getFrom());
		assertEquals("Europe", t.getTo());
		assertEquals("darun", t.getUserdetails().getFirst_name());
		assertEquals(1000.2, t.getPrice());
		assertEquals("A", t.getSeatDetails().getSeatsection());
	}
	
	@Test
	void getUserbySection() {
		
		System.out.println("<---------------------------Get User By Section Output TestCase-------------------------->");
		UserDetails user = new UserDetails("Siva","S","siva@gmail.com");
		UserDetails user1 = new UserDetails("darun","n","darun@gmail.com");
		
		SeatDetails s1 = new SeatDetails(1,"A");
		SeatDetails s2 = new SeatDetails(1,"A");
		
		service.purchaseticket("London", "Paris", user, s1, 20.0 );
		service.purchaseticket("London", "Europe", user1, s2, 1000.2);
		
		Map<String,TrainTicketDetails> service1 = service.getUserbySection("A");
		
		for(Map.Entry<String, TrainTicketDetails> map:service1.entrySet()) {
			System.out.println("Email -> "+map.getKey()+" First Name " +map.getValue().getUserdetails().getFirst_name());
		}
		
		assertNotNull(service1);
		assertEquals(2, service1.size());
		assertTrue(service1.containsKey("siva@gmail.com"));
		assertFalse(service1.containsKey("darun1@gmail.com"));
	}
	
	@Test
	void removeUser() {
		
		System.out.println("<---------------------------Remove User Output TestCase-------------------------->");
		
		UserDetails user = new UserDetails("Siva","S","siva@gmail.com");
		UserDetails user1 = new UserDetails("darun","n","darun@gmail.com");
		
		SeatDetails s1 = new SeatDetails(1,"A");
		SeatDetails s2 = new SeatDetails(1,"A");
		
		service.purchaseticket("London", "Paris", user, s1, 20.0 );
		service.purchaseticket("London", "Europe", user1, s2, 1000.2);
		
		System.out.println("Before--->  ");
		Map<String,TrainTicketDetails> service1 = service.getUserbySection("A");
		
		for(Map.Entry<String, TrainTicketDetails> map:service1.entrySet()) {
			System.out.println("Email -> "+map.getKey()+" First Name " +map.getValue().getUserdetails().getFirst_name());
		}
		
		service.removeuser("siva@gmail.com");
		
		System.out.println("After--->  ");
		
		Map<String,TrainTicketDetails> service2 = service.getUserbySection("A");
		
		for(Map.Entry<String, TrainTicketDetails> map:service2.entrySet()) {
			System.out.println("Email After -> "+map.getKey()+" First Name " +map.getValue().getUserdetails().getFirst_name());
		}
		
		assertNull(service.getReciptofUser(user.getEmail()));
	}
	
	@Test
	void modifyuserseat() {
		System.out.println("<---------------------------Modify User Seat Output TestCase-------------------------->");

		UserDetails user = new UserDetails("Siva","S","siva@gmail.com");
		UserDetails user1 = new UserDetails("darun","n","darun@gmail.com");
		
		SeatDetails s1 = new SeatDetails(1,"A");
		SeatDetails s2 = new SeatDetails(1,"A");
		
		service.purchaseticket("London", "Paris", user, s1, 20.0 );
		service.purchaseticket("London", "Europe", user1, s2, 1000.2);
		
		service.modifyuser("siva@gmail.com",21);
		
		Map<String,TrainTicketDetails> service2 = service.getUserbySection("A");
		
		for(Map.Entry<String, TrainTicketDetails> map:service2.entrySet()) {
			System.out.println("Email After -> "+map.getKey()+" First Name " +map.getValue().getUserdetails().getFirst_name() +" Seat Number " +map.getValue().getSeatDetails().getSeatnumber());
		}
		
		assertEquals(21, service.getReciptofUser("siva@gmail.com").getSeatDetails().getSeatnumber());
		
	}
	
}
