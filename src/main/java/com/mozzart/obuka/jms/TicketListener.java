package com.mozzart.obuka.jms;

import java.sql.Date;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mozzart.obuka.domain.Ticket;
import com.mozzart.obuka.service.TicketService;

@Component
public class TicketListener {

	@Autowired
	TicketService ticketService;

	@Autowired
	@Qualifier("customObjectMapper")
	private ObjectMapper objectMapper;

	@JmsListener(destination = "obuka.queue")
	public void processTicketMessage(TextMessage message) {
		try {
			final List<Ticket> tickets = objectMapper.readValue(message.getText(), new TypeReference<List<Ticket>>() {});
			
			for (Ticket ticket : tickets) {
				long millis = System.currentTimeMillis();
				Date systemTime = new Date(millis);
				ticket.setTimeChanged(systemTime);
				
				if (ticketService.getTicket(ticket.getId()) != null)
					ticketService.update(ticket);
				else
					ticketService.save(ticket);
			}
		} catch (JsonProcessingException | JMSException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
}
