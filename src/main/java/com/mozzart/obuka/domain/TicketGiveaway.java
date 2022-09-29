package com.mozzart.obuka.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class TicketGiveaway implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long ticketId;
	private Long giveawayId;
	
	@Override
	public String toString() {
		return "ticketId" + ticketId + " giveawayId:" + giveawayId;
	}
}