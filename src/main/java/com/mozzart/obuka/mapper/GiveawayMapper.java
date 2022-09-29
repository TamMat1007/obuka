package com.mozzart.obuka.mapper;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mozzart.obuka.domain.Giveaway;
@Mapper
public interface GiveawayMapper {

	Giveaway getById(Long giveawayId);

	List<Giveaway> findActiveGiveaways(Date systemTime);

	List<Giveaway> findAllGiveaways();
  

}
