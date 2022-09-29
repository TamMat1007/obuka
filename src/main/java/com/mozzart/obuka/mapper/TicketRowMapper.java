package com.mozzart.obuka.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mozzart.obuka.domain.TicketRow;

@Mapper
public interface TicketRowMapper {
  

	List<TicketRow> findAllTicketRows();

	void insertTicketRow(TicketRow ticketRow);


}
