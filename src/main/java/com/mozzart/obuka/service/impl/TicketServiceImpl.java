package com.mozzart.obuka.service.impl;

import com.mozzart.obuka.domain.Giveaway;
import com.mozzart.obuka.domain.Ticket;
import com.mozzart.obuka.domain.TicketGiveaway;
import com.mozzart.obuka.domain.TicketRow;
import com.mozzart.obuka.mapper.GiveawayMapper;
import com.mozzart.obuka.mapper.MatchMapper;
import com.mozzart.obuka.mapper.RulesCompetitionMapper;
import com.mozzart.obuka.mapper.RulesSumMapper;
import com.mozzart.obuka.mapper.TicketGiveawayMapper;
import com.mozzart.obuka.mapper.TicketMapper;
import com.mozzart.obuka.mapper.TicketRowMapper;
import com.mozzart.obuka.service.TicketService;
import com.mozzart.obuka.service.UtilService;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	MatchMapper matchMapper;
	@Autowired
	TicketMapper ticketMapper;
	@Autowired
	TicketRowMapper ticketRowMapper;
	@Autowired
	GiveawayMapper giveawayMapper;
	@Autowired
	RulesSumMapper rulesSumMapper;
	@Autowired
	RulesCompetitionMapper rulesCompetitionMapper;
	@Autowired
	TicketGiveawayMapper ticketGiveawayMapper;
	
	@Autowired
	UtilService utilService;

	public List<Ticket> findAll() {
		List<Ticket> tickets = this.ticketMapper.findAllTickets();
		return tickets;
	}

	public void save(Ticket ticket) {
		if (ticket.getTicketRows() != null) {
			this.ticketMapper.insertTicket(ticket);

			List<TicketRow> ticketRows = ticket.getTicketRows();
			for (TicketRow row : ticketRows) {
				row.setTicketId(ticket.getId());
				this.ticketRowMapper.insertTicketRow(row);
			}

			long millis = System.currentTimeMillis();
			Date systemTime = new Date(millis);
			
			List<Giveaway> giveaways = giveawayMapper.findActiveGiveaways(systemTime);
			for (Giveaway giveaway : giveaways) {
				Boolean valid=utilService.checkConditions(giveaway, null, ticket);
				if(valid) ticketGiveawayMapper.insertTicketGiveaway(new TicketGiveaway(ticket.getId(), giveaway.getId()));
			}
		}
	}

	public List<Ticket> findUnprocessedTickets(Date lastEdit, Date sysDate, Long giveawayId) {
		return this.ticketMapper.findUnprocessedTickets(lastEdit, sysDate, giveawayId);
	}

	public void processTicket(Long id, Date sysDate) {
		this.ticketMapper.processTicket(id, sysDate);
	}

	@Override
	public Ticket getTicket(Long ticketId) {
		return ticketMapper.getTicket(ticketId);
	}

	@Override
	public void update(Ticket ticket) {
		ticketMapper.updateTicket(ticket);
	}

	/*
	 * @Override public Boolean checkAdditionalConditions(Rules rule,Stage
	 * stage,Ticket ticket) { if(rule.getOutOfTimeBorder()==true ||
	 * checkMatchDates(ticketMatches, giveaway) == 1) return true; else return
	 * false; }
	 */

}