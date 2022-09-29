package com.mozzart.obuka.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Match  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private List<Participant> participants;
	private Date matchDate;
	private Competition competition;
	private MatchStatus matchStatus;

	
	
	@Override
	public String toString() {
		return "Match- ID:" + id + " competition:" + competition.getId() + " participants:" + participants.size() +
				" status:" + matchStatus;
	}
}
