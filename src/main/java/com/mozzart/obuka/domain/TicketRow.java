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

public class TicketRow implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long ticketId;
	private Long matchId;
	private Long gameId;
	private Long subgameId;
	private Double oddValue;
	private WinnStatus winnStatus;
	
	
	
	@Override
	public String toString() {
		return "Ticket Row- ID:" + id + " odd: " + oddValue;
	}
}
