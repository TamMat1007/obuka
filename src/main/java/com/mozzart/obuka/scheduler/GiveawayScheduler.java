package com.mozzart.obuka.scheduler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.mozzart.obuka.domain.CalculationStatistics;
import com.mozzart.obuka.domain.ComparationPattern;
import com.mozzart.obuka.domain.Giveaway;
import com.mozzart.obuka.domain.GiveawayStage;
import com.mozzart.obuka.domain.Ticket;
import com.mozzart.obuka.service.CalculationStatisticsService;
import com.mozzart.obuka.service.ComparationPatternService;
import com.mozzart.obuka.service.GiveawayService;
import com.mozzart.obuka.service.GiveawayStageService;
import com.mozzart.obuka.service.GiveawayStageWinnerTicketService;
import com.mozzart.obuka.service.MatchOddSubgameWinnStatusService;
import com.mozzart.obuka.service.MatchService;
import com.mozzart.obuka.service.RulesCompetitionService;
import com.mozzart.obuka.service.RulesSumService;
import com.mozzart.obuka.service.TicketService;
import com.mozzart.obuka.service.UtilService;
import com.mozzart.obuka.util.Util;

@Configuration
@EnableScheduling
public class GiveawayScheduler {

	@Autowired
	TicketService ticketService;
	@Autowired
	GiveawayStageService giveawayStageService;
	@Autowired
	GiveawayService giveawayService;
	@Autowired
	MatchService matchService;
	@Autowired
	MatchOddSubgameWinnStatusService matchOddSubgameWinnStatusService;
	@Autowired
	RulesSumService rulesSumService;
	@Autowired
	RulesCompetitionService rulesCompetitionService;
	@Autowired
	CalculationStatisticsService calculationStatisticsService;
	@Autowired
	UtilService utilService;
	@Autowired
	GiveawayStageWinnerTicketService giveawayStageWinnerTicketService;
	@Autowired
	ComparationPatternService comparationPatternService;


	@Scheduled(fixedRateString = "${schedule.fixedRate}")
	public void scheduleTicketProcessing() {
		
		System.out.println("processing...");
		long millis = System.currentTimeMillis();
		Date systemTime = new Date(millis);

		Date lastProcessingTime = calculationStatisticsService.getLastProcessingTime().getProcessingTime();

		List<Giveaway> activeGiveaways = giveawayService.findActiveGiveaways(systemTime);

		for (Giveaway giveaway : activeGiveaways) {
			GiveawayStage giveawayStage = giveawayStageService.findActiveGiveawayStage(systemTime, giveaway.getId());
			if (giveawayStage != null) {
				List<Ticket> unprocessedTickets = ticketService.findUnprocessedTickets(lastProcessingTime, systemTime,
						giveaway.getId());
				if (unprocessedTickets.isEmpty()) continue;
				List<Ticket> winnerTickets = giveawayStageWinnerTicketService.getGiveawayStageWinners(giveaway.getId(),
						giveawayStage.getId());
				List<Ticket> newWinnerTickets = new ArrayList<>();
				for (Ticket ticket : unprocessedTickets) {
					Boolean valid = utilService.checkConditions(giveaway, giveawayStage, ticket);
					if (valid)
						newWinnerTickets.add(ticket);
				}
				if (newWinnerTickets.isEmpty()) continue;
				
				ComparationPattern pattern=comparationPatternService.getPattern(giveaway.getComparationPatternId());
				Comparator<Ticket> comparator = Util.createComparatorChain(pattern);
				
				if (winnerTickets == null || winnerTickets.isEmpty())
					giveawayStageWinnerTicketService.insertNewLeaderboard(giveaway, giveawayStage, newWinnerTickets,comparator);
				else
					giveawayStageWinnerTicketService.compareWinningTickets(giveaway, giveawayStage, winnerTickets, newWinnerTickets,comparator);

			}
		}
		calculationStatisticsService.addLastProcessingTime(new CalculationStatistics(
				calculationStatisticsService.getLastProcessingTime().getId() + 1, systemTime));
	}

}
