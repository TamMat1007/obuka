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

public class MatchParticipant implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long matchId;
	private Long participantId;
	private ParticipantType participantType;
	
	
	@Override
	public String toString() {
		return "MP- match id:" + matchId + " participant id:" + participantId;
	}
}
