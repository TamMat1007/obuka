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

public class RulesCompetition implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long rulesId;
	private Long competitionId;
	private Boolean included;
	
	
	
	@Override
	public String toString() {
		return "included:" + included;
	}
}


