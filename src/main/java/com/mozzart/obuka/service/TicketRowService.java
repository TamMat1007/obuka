package com.mozzart.obuka.service;

import java.util.List;

import com.mozzart.obuka.domain.TicketRow;


public interface TicketRowService {
	List<TicketRow> findAll();
	
	void save(TicketRow ticketRow);

}
