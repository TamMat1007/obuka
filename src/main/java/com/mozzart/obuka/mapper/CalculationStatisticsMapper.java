
package com.mozzart.obuka.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mozzart.obuka.domain.CalculationStatistics;

@Mapper
public interface CalculationStatisticsMapper {

	CalculationStatistics getLastProcessingTime();

	void addLastProcessingTime(CalculationStatistics newTime);


}

