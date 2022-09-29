package com.mozzart.obuka.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mozzart.obuka.domain.TicketGiveaway;

@Mapper
public interface TicketGiveawayMapper {

	void insertTicketGiveaway(TicketGiveaway ticketGiveaway);

}
