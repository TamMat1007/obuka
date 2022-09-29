package com.mozzart.obuka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozzart.obuka.domain.Game;
import com.mozzart.obuka.mapper.GameMapper;
import com.mozzart.obuka.service.GameService;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
    GameMapper gameMapper;

	@Override
	public Game findById(Long id) {
		return gameMapper.findById(id.longValue());
	}

	
}
