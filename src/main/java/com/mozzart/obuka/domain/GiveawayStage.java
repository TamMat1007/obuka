package com.mozzart.obuka.domain;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class GiveawayStage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long giveawayId;
	private Date startDate;
	private Date endDate;
    private Integer totalWinners;
	
	
	@Override
	public String toString() {
		return "Stage- ID:" + id + " Giveaway Id:" + giveawayId;
	}
}