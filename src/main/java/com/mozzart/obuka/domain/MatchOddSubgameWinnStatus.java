package com.mozzart.obuka.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class MatchOddSubgameWinnStatus implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long matchId;
	private Long gameId;
	private Long subgameId;
	private WinnStatus status;
	
	
	
	@Override
	public String toString() {
		return "status:" + status;
	}
}
