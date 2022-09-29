package com.mozzart.obuka.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozzart.obuka.domain.ComparationPattern;
import com.mozzart.obuka.mapper.ComparationPatternMapper;
import com.mozzart.obuka.service.ComparationPatternService;

@Service
public class ComparationPatternServiceImpl implements ComparationPatternService{

	@Autowired
    ComparationPatternMapper comparationPatternMapper;
	
	@Override
	public ComparationPattern getPattern(Long id) {
		return comparationPatternMapper.getPattern(id);
	}

}
