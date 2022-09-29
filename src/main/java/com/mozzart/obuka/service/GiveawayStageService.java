package com.mozzart.obuka.service;

import java.util.Date;

import com.mozzart.obuka.domain.GiveawayStage;

public interface GiveawayStageService {

	GiveawayStage findActiveGiveawayStage(Date sysDate,Long giveawayId);

	//void compareToWinner(GiveawayStage stage, Ticket ticket);

}
