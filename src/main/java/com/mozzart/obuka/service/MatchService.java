package com.mozzart.obuka.service;

import java.util.List;

import com.mozzart.obuka.domain.Competition;
import com.mozzart.obuka.domain.Match;

public interface MatchService {
	
	List<Match> findAll();
	
	void save(Match match);

	Competition getMatchCompetition(Long matchId);

	Match getMatch(Long matchId);

	void update(Match match);

}
