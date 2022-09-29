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

public class Giveaway implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Translation translation;
	private Date startDate;
	private Date endDate;
	
    private Rules rules;
    private Integer totalStageWinners;
    private Long comparationPatternId;

	private List<GiveawayStage> giveawayStages;
	
	@Override
	public String toString() {
		return "Giveaway - ID:" + id +
	" number of stages:" + giveawayStages.size();
	}
}
