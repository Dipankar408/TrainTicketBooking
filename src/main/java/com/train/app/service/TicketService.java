package com.train.app.service;

import java.util.Map;

import com.train.app.entity.Ticket;
import com.train.app.entity.User;

public interface TicketService {

	public Ticket createTicket(Ticket ticket);
	
	public Ticket getTicket(Long uid);
	
	public Ticket updateTicket(String seatNumber, String section, Long uid);
	
	public String deleteTicket(Long uid);
	
	public Map<User,String> getUsersWithTicket(String section);
	
}
