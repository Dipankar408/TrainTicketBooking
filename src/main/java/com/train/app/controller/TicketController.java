package com.train.app.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.train.app.entity.Ticket;
import com.train.app.entity.User;
import com.train.app.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	private TicketService ticketService;
	
	
	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}


	@PostMapping("/purchase")
	public ResponseEntity<Ticket> purchaseTicket(@RequestBody Ticket ticket){
		return new ResponseEntity<Ticket>(ticketService.createTicket(ticket), HttpStatus.CREATED);
	}
	
	@PutMapping("/modify/{uid}/{sec}/{num}")
	public ResponseEntity<Ticket> modifySeat(@PathVariable("uid") Long uid, @PathVariable("sec") String section, @PathVariable("num") String seatNumber){
		return new ResponseEntity<>(ticketService.updateTicket(seatNumber, section, uid), HttpStatus.OK);
	}
	
	@GetMapping("/{uid}")
	public ResponseEntity<Ticket> getTicket(@PathVariable Long uid){
		return new ResponseEntity<>(ticketService.getTicket(uid), HttpStatus.OK);
	}
	
	@DeleteMapping("/{uid}")
	public ResponseEntity<String> removeUserTicket(@PathVariable Long uid){
		return new ResponseEntity<String>(ticketService.deleteTicket(uid), HttpStatus.OK);
	}
	
	@GetMapping("passengers/{section}")
	public ResponseEntity<Map<User, String>> getUserAndTicket( @PathVariable String section){
		return new ResponseEntity<Map<User,String>>(ticketService.getUsersWithTicket(section), HttpStatus.OK);
	}

}
