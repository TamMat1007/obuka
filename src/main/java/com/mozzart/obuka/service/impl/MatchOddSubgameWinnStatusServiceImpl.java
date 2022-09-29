package com.mozzart.obuka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozzart.obuka.domain.MatchOddSubgameWinnStatus;
import com.mozzart.obuka.mapper.MatchOddSubgameWinnStatusMapper;
import com.mozzart.obuka.service.MatchOddSubgameWinnStatusService;


@Service
public class MatchOddSubgameWinnStatusServiceImpl implements MatchOddSubgameWinnStatusService{

	@Autowired
    MatchOddSubgameWinnStatusMapper matchOddSubgameWinnStatusMapper;

	@Override
	public MatchOddSubgameWinnStatus getStatus(Long matchId, Long gameId, Long subgameId) {
		return matchOddSubgameWinnStatusMapper.getStatus(matchId,gameId,subgameId);
	}
	
}
