package com.mozzart.obuka.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mozzart.obuka.domain.GiveawayStage;

@Mapper
public interface GiveawayStageMapper {

	GiveawayStage findActiveGiveawayStage(@Param("sysDate") Date sysDate, @Param("giveawayId") Long giveawayId);

	void updateWinner(GiveawayStage stage);
  

	

}
