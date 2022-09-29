package com.mozzart.obuka.service;

import com.mozzart.obuka.domain.CalculationStatistics;

public interface CalculationStatisticsService {

	CalculationStatistics getLastProcessingTime();

	void addLastProcessingTime(CalculationStatistics newTime);

}
