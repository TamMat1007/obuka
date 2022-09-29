package com.mozzart.obuka.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mozzart.obuka.domain.Ticket;

@Mapper
public interface TicketMapper {
  

	List<Ticket> findAllTickets();

	void insertTicket(Ticket ticket);

	List<Ticket> findUnprocessedTickets(@Param("lastEdit") Date lastEdit, @Param("sysDate") Date sysDate, @Param("giveawayId")Long giveawayId);

	void processTicket(@Param("id")Long id, @Param("sysDate") Date sysDate);

	Ticket getTicket(Long ticketId);

	void updateTicket(Ticket ticket);




}
