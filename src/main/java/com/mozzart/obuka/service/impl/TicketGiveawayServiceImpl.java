package com.mozzart.obuka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozzart.obuka.mapper.TicketGiveawayMapper;

@Service
public class TicketGiveawayServiceImpl {

	@Autowired
	TicketGiveawayMapper ticketGiveawayMapper;
}
