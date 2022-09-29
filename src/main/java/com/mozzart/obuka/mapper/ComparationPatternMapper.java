package com.mozzart.obuka.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.mozzart.obuka.domain.ComparationPattern;

@Mapper
public interface ComparationPatternMapper {

	ComparationPattern getPattern(Long id);

}
