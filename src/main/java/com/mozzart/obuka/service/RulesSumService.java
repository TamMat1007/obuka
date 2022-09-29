package com.mozzart.obuka.service;

import java.util.List;

import com.mozzart.obuka.domain.Sum;

public interface RulesSumService {
	
	List<Sum> findIncludedSums(Long ruleId);

}
