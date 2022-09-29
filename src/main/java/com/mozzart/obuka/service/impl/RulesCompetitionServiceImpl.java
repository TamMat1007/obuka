package com.mozzart.obuka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozzart.obuka.domain.Competition;
import com.mozzart.obuka.mapper.RulesCompetitionMapper;
import com.mozzart.obuka.service.RulesCompetitionService;


@Service
public class RulesCompetitionServiceImpl implements RulesCompetitionService{
	
	@Autowired
    RulesCompetitionMapper rulesCompetitionMapper;


	@Override
	public List<Competition> findIncludedCompetitions(Long ruleId) {
		return rulesCompetitionMapper.findIncludedCompetitions(ruleId);
	}

}
