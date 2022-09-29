package com.mozzart.obuka.service;

import java.util.Date;
import java.util.List;

import com.mozzart.obuka.domain.Giveaway;

public interface GiveawayService {

	Giveaway getById(Long giveawayId);

	List<Giveaway> findActiveGiveaways(Date systemTime);

}
