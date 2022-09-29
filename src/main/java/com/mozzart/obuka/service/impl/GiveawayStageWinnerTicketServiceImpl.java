package com.mozzart.obuka.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozzart.obuka.domain.Giveaway;
import com.mozzart.obuka.domain.GiveawayStage;
import com.mozzart.obuka.domain.GiveawayStageWinnerTicket;
import com.mozzart.obuka.domain.Ticket;
import com.mozzart.obuka.mapper.GiveawayStageWinnerTicketMapper;
import com.mozzart.obuka.service.GiveawayStageWinnerTicketService;

@Service
public class GiveawayStageWinnerTicketServiceImpl implements GiveawayStageWinnerTicketService {

	@Autowired
	GiveawayStageWinnerTicketMapper giveawayStageWinnerTicketMapper;

	@Override
	public List<Ticket> getGiveawayStageWinners(Long giveawayId, Long giveawayStageId) {
		return giveawayStageWinnerTicketMapper.getGiveawayStageWinners(giveawayId, giveawayStageId);
	}

	@Override
	public void insertNewLeaderboard(Giveaway giveaway, GiveawayStage giveawayStage, List<Ticket> newWinnerTickets, Comparator<Ticket> comparator) {
		List<GiveawayStageWinnerTicket> leaderboard = new ArrayList<>();
		int totalWinners = giveawayStage.getTotalWinners() == 0 ? giveaway.getTotalStageWinners() : giveawayStage.getTotalWinners();
		int max = newWinnerTickets.size() < totalWinners ? newWinnerTickets.size() : totalWinners;

		Collections.sort(newWinnerTickets, comparator.reversed());
		for (int i = 0; i < max; i++) {
			leaderboard.add(new GiveawayStageWinnerTicket(giveawayStage.getGiveawayId(), giveawayStage.getId(), newWinnerTickets.get(i).getId(), Long.valueOf(i+1), giveaway.getComparationPatternId()));
		}
		giveawayStageWinnerTicketMapper.insertNewLeaderboard(leaderboard);
	}

	@Override
	public void compareWinningTickets(Giveaway giveaway, GiveawayStage giveawayStage, List<Ticket> winnerTickets, List<Ticket> newWinnerTickets, Comparator<Ticket> comparator) {
		List<Ticket> joined = new ArrayList<Ticket>();
		joined.addAll(winnerTickets);
		joined.addAll(newWinnerTickets);
		Collections.sort(joined, comparator.reversed());

		int totalWinners = giveawayStage.getTotalWinners() == 0 ? giveaway.getTotalStageWinners() : giveawayStage.getTotalWinners();
		int max = joined.size() < totalWinners ? joined.size() : totalWinners;

		List<GiveawayStageWinnerTicket> leaderboard = new ArrayList<>();
		List<Ticket> leaderboardTickets = new ArrayList<>();
		for (int i = 0; i < max; i++) {
			leaderboardTickets.add(joined.get(i));
			leaderboard.add(new GiveawayStageWinnerTicket(giveawayStage.getGiveawayId(), giveawayStage.getId(), joined.get(i).getId(),Long.valueOf(i+1), giveaway.getComparationPatternId()));
		}

		if (!winnerTickets.equals(leaderboardTickets)) {
			giveawayStageWinnerTicketMapper.deleteLeaderboard(giveawayStage);
			giveawayStageWinnerTicketMapper.insertNewLeaderboard(leaderboard);
		}
	}
}
