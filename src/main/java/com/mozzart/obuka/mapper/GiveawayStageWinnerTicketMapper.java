package com.mozzart.obuka.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mozzart.obuka.domain.GiveawayStage;
import com.mozzart.obuka.domain.GiveawayStageWinnerTicket;
import com.mozzart.obuka.domain.Ticket;

@Mapper
public interface GiveawayStageWinnerTicketMapper {

	List<Ticket> getGiveawayStageWinners(@Param("giveawayId")Long giveawayId, @Param("giveawayStageId")Long giveawayStageId);

	void insertNewLeaderboard(List<GiveawayStageWinnerTicket> leaderboard);

	Ticket getById(Long ticketId);

	//void insertNewWinnerTicket(GiveawayStageWinnerTicket winnerTicket);

	void deleteLeaderboard(GiveawayStage giveawayStage);

}
