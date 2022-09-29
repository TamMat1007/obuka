package com.mozzart.obuka.service;

import java.sql.Date;
import java.util.List;

import com.mozzart.obuka.domain.Ticket;

public interface TicketService {
	
	List<Ticket> findAll();
	
	void save(Ticket ticket);

	List<Ticket> findUnprocessedTickets(Date lastEdit, Date sysDate, Long giveawayId);

	void processTicket(Long id, Date sysDate);

	Ticket getTicket(Long id);

	void update(Ticket ticket);

	//Boolean checkAdditionalConditions(Rules rule, Stage stage, Ticket ticket);

}
