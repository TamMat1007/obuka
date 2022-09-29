package com.mozzart.obuka.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozzart.obuka.domain.GiveawayStage;
import com.mozzart.obuka.mapper.GiveawayStageMapper;
import com.mozzart.obuka.service.GiveawayStageService;
@Service
public class GiveawayStageServiceImpl implements GiveawayStageService{
	
	@Autowired
    GiveawayStageMapper stageMapper;

	@Override
	public GiveawayStage findActiveGiveawayStage(Date sysDate, Long giveawayId) {
		return stageMapper.findActiveGiveawayStage(sysDate,giveawayId);
	}

	/*@Override
	public void compareToWinner(GiveawayStage stage, Ticket ticket) {
		if(stage.getWinner()==null || ticket.getTicketRows().size()>=stage.getWinner().getTicketRows().size()) {
			stage.setWinner(ticket);
			stageMapper.updateWinner(stage);
		}
		
	}*/

}
