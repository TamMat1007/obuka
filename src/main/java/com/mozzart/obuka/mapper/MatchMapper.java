package com.mozzart.obuka.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mozzart.obuka.domain.Competition;
import com.mozzart.obuka.domain.Match;

@Mapper
public interface MatchMapper {
  
	List<Match> findAllMatches();

	void insertMatch(Match match);

	Competition getMatchCompetition(Long matchId);

	Match getMatch(Long matchId);

	void updateMatch(Match match);


}
