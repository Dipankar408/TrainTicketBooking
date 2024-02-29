package com.train.app.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.app.entity.Ticket;
import com.train.app.entity.User;
import com.train.app.repo.TicketRepo;
import com.train.app.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepo ticketRepo;

	@Override
	public Ticket createTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	@Override
	public Ticket getTicket(Long uid) {
		Ticket ticket = ticketRepo.findByTicketHolderUid(uid);
		if(ticket == null) {
			throw new RuntimeException("No ticket found");
		}
		
		return ticket;
	}

	@Override
	public Ticket updateTicket(String seatNumber, String section, Long uid) {
		Ticket ticket = ticketRepo.findByTicketHolderUid(uid);
		ticket.setSeatNumber(seatNumber);
		ticket.setSection(section);
		return ticketRepo.save(ticket);
	}

	@Override
	public String deleteTicket(Long uid) {
		Ticket ticket = ticketRepo.findByTicketHolderUid(uid);
		if(ticket == null) {
			throw new RuntimeException("No ticket found");
		}
		ticketRepo.delete(ticket);
		return "Ticket deleted";
	}

	@Override
	public Map<User, String> getUsersWithTicket(String section) {
		Map<User, String> userSeatMap = new HashMap<>();
		ticketRepo.findBySection(section).forEach(it -> userSeatMap.put(it.getTicketHolder(), it.getSection() + "/" + it.getSeatNumber()));
		return userSeatMap;
	}

}
