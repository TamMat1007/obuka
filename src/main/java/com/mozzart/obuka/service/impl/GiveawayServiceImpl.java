package com.mozzart.obuka.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozzart.obuka.domain.Giveaway;
import com.mozzart.obuka.mapper.GiveawayMapper;
import com.mozzart.obuka.service.GiveawayService;

@Service
public class GiveawayServiceImpl implements GiveawayService{
	
	@Autowired
    GiveawayMapper giveawayMapper;

	@Override
	public Giveaway getById(Long giveawayId) {
		return giveawayMapper.getById(giveawayId);
	}

	@Override
	public List<Giveaway> findActiveGiveaways(Date systemTime) {
		return giveawayMapper.findActiveGiveaways(systemTime);
	}

	
	


}
