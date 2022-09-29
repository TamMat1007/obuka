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

public class GiveawayStageWinnerTicket implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long giveawayId;
	private Long giveawayStageId;
	private Long ticketId;
	private Long rank;
	private Long comparationPatternId;
	
	
	
	@Override
	public String toString() {
		return "winner: " + ticketId;
	}
}


