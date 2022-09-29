package com.mozzart.obuka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozzart.obuka.domain.TicketRow;
import com.mozzart.obuka.mapper.TicketRowMapper;
import com.mozzart.obuka.service.TicketRowService;

@Service
public class TicketRowServiceImpl implements TicketRowService {
	
	@Autowired
    TicketRowMapper ticketRowMapper;

	@Override
	public List<TicketRow> findAll() {
		return ticketRowMapper.findAllTicketRows();
	}

	@Override
	public void save(TicketRow ticketRow) {
		ticketRowMapper.insertTicketRow(ticketRow);
		
	}

}
