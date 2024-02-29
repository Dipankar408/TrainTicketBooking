package com.train.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.train.app.entity.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {

	public Ticket findByTicketHolderUid(Long uid);
	
	public List<Ticket> findBySection(String section);
}
