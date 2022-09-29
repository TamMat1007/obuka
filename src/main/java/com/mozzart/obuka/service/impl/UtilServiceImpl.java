package com.mozzart.obuka.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozzart.obuka.domain.Competition;
import com.mozzart.obuka.domain.Giveaway;
import com.mozzart.obuka.domain.Match;
import com.mozzart.obuka.domain.MatchOddSubgameWinnStatus;
import com.mozzart.obuka.domain.Rules;
import com.mozzart.obuka.domain.GiveawayStage;
import com.mozzart.obuka.domain.Sum;
import com.mozzart.obuka.domain.Ticket;
import com.mozzart.obuka.domain.TicketRow;
import com.mozzart.obuka.mapper.MatchMapper;
import com.mozzart.obuka.mapper.MatchOddSubgameWinnStatusMapper;
import com.mozzart.obuka.mapper.RulesCompetitionMapper;
import com.mozzart.obuka.mapper.RulesSumMapper;
import com.mozzart.obuka.mapper.TicketGiveawayMapper;
import com.mozzart.obuka.service.UtilService;

@Service
public class UtilServiceImpl implements UtilService {

	@Autowired
	TicketGiveawayMapper ticketGiveawayMapper;
	@Autowired
	RulesSumMapper rulesSumMapper;
	@Autowired
	RulesCompetitionMapper rulesCompetitionMapper;
	@Autowired
	MatchMapper matchMapper;
	@Autowired
	MatchOddSubgameWinnStatusMapper matchOddSubgameWinnStatusMapper;

	@Override
	public Boolean checkConditions(Giveaway giveaway, GiveawayStage stage, Ticket ticket) {
		Rules rule = giveaway.getRules();

		if (stage == null) {
			giveaway.getRules().setSums(rulesSumMapper.findIncludedSums(rule.getId()));
			Sum sum = new Sum();
			sum.setId(ticket.getSumId());

			boolean minOddTicketRuleSatisfied = ticket.getTicketRows().size() >= rule.getMinRows();
			boolean minPaymentRuleSatisfied = ticket.getPayment() >= rule.getMinPayment();
			boolean sumContainedRuleSatisfied = rule.getSums().contains(sum);
			boolean systemTicketRuleSatisfied=rule.getSystem() == true || ticket.getSystem() == false;

			if (!sumContainedRuleSatisfied || !minOddTicketRuleSatisfied || !minPaymentRuleSatisfied
					|| !systemTicketRuleSatisfied)
				return false;
			return true;
		}

		List<Match> ticketMatches = new ArrayList<>();
		List<Competition> ticketCompetitions = new ArrayList<>();
		Integer winRows = 0;
		Integer loseRows = 0;

		for (TicketRow row : ticket.getTicketRows()) {
			if (row.getWinnStatus() == null) {
				MatchOddSubgameWinnStatus status = matchOddSubgameWinnStatusMapper.getStatus(row.getMatchId(),
						row.getGameId(), row.getSubgameId());
				row.setWinnStatus(status.getStatus());
			}
			switch (row.getWinnStatus()) {
			case ACTIVE:
				return false;
			case WINNING:
				winRows++;
				break;
			case LOSING:
				loseRows++;
				break;
			case CANCELLED:
				break;
			}
		}
		rule.setCompetitions(rulesCompetitionMapper.findIncludedCompetitions(rule.getId()));
		
		boolean minWinTicketRowsRuleSatisfied = winRows >= rule.getMinWinRows();
		boolean maxLoseTicketRowsRuleSatisfied = loseRows <= rule.getMaxLoseRows();
		boolean competitionsContainedRuleSatisfied = rule.getCompetitions().containsAll(ticketCompetitions);
		boolean matchDateRuleSatisfied = rule.getOutOfTimeBorder() == true || checkMatchDates(ticketMatches, stage) == 1;

		if (!competitionsContainedRuleSatisfied || !minWinTicketRowsRuleSatisfied
				|| !maxLoseTicketRowsRuleSatisfied
				|| !matchDateRuleSatisfied)
			return false;
		return true;
	}

	@Override
	public int checkMatchDates(List<Match> ticketMatches, GiveawayStage stage) {
		for (Match match : ticketMatches) {
			if (match.getMatchDate().before(stage.getStartDate()) || (match.getMatchDate().after(stage.getEndDate())))
				return 0;
		}
		return 1;
	}
	
}
