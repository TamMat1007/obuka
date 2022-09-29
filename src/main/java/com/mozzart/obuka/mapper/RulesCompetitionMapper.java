package com.mozzart.obuka.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mozzart.obuka.domain.Competition;

@Mapper
public interface RulesCompetitionMapper {

	List<Competition> findIncludedCompetitions(Long ruleId);

}
