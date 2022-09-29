
package com.mozzart.obuka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozzart.obuka.domain.CalculationStatistics;
import com.mozzart.obuka.mapper.CalculationStatisticsMapper;
import com.mozzart.obuka.service.CalculationStatisticsService;

@Service
public class CalculationStatisticsServiceImpl implements CalculationStatisticsService {
	
	@Autowired
    CalculationStatisticsMapper calculationStatitisticsMapper;

	@Override
	public CalculationStatistics getLastProcessingTime() {
		return calculationStatitisticsMapper.getLastProcessingTime();
	}

	@Override
	public void addLastProcessingTime(CalculationStatistics newTime) {
		calculationStatitisticsMapper.addLastProcessingTime(newTime);
		
	}

	

	
}
