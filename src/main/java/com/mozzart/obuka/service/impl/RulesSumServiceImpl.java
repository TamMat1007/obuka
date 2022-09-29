package com.mozzart.obuka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozzart.obuka.domain.Sum;
import com.mozzart.obuka.mapper.RulesSumMapper;
import com.mozzart.obuka.service.RulesSumService;


@Service
public class RulesSumServiceImpl implements RulesSumService{
	
	@Autowired
    RulesSumMapper rulesSumMapper;

	@Override
	public List<Sum> findIncludedSums(Long ruleId) {
		return rulesSumMapper.findIncludedSums(ruleId);
	}


	
}
