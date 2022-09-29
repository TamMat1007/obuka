package com.mozzart.obuka.service;

import java.util.List;

import com.mozzart.obuka.domain.Competition;

public interface RulesCompetitionService {

	List<Competition> findIncludedCompetitions(Long ruleId);

}
