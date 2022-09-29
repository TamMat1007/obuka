package com.mozzart.obuka.service;


import com.mozzart.obuka.domain.MatchOddSubgameWinnStatus;

public interface MatchOddSubgameWinnStatusService {

	MatchOddSubgameWinnStatus getStatus(Long matchId, Long gameId, Long subgameId);

	

}
