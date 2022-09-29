package com.mozzart.obuka.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mozzart.obuka.domain.MatchOddSubgameWinnStatus;

@Mapper
public interface MatchOddSubgameWinnStatusMapper {

	MatchOddSubgameWinnStatus getStatus(@Param("matchId")Long matchId, @Param("gameId")Long gameId, @Param("subgameId")Long subgameId);

}
