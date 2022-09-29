package com.mozzart.obuka.service;

import java.util.List;

import com.mozzart.obuka.domain.Giveaway;
import com.mozzart.obuka.domain.Match;
import com.mozzart.obuka.domain.GiveawayStage;
import com.mozzart.obuka.domain.Ticket;

public interface UtilService {

	int checkMatchDates(List<Match> ticketMatches, GiveawayStage stage);

	Boolean checkConditions(Giveaway giveaway, GiveawayStage stage, Ticket ticket);

	
	
	
}
