package com.mozzart.obuka.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mozzart.obuka.domain.Sum;

@Mapper
public interface RulesSumMapper {

	List<Sum> findIncludedSums(Long ruleId);

}
