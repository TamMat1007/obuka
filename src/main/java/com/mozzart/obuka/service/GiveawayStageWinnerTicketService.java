package com.mozzart.obuka.service;

import java.util.Comparator;
import java.util.List;

import com.mozzart.obuka.domain.Giveaway;
import com.mozzart.obuka.domain.GiveawayStage;
import com.mozzart.obuka.domain.Ticket;

public interface GiveawayStageWinnerTicketService {

	List<Ticket> getGiveawayStageWinners(Long id, Long id2);

	void insertNewLeaderboard(Giveaway giveaway, GiveawayStage giveawayStage, List<Ticket> newWinnerTickets, Comparator<Ticket> comp);

	void compareWinningTickets(Giveaway giveaway, GiveawayStage giveawayStage, List<Ticket> winningTickets, List<Ticket> newWinningTickets, Comparator<Ticket> comp);

}
