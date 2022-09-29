
package com.mozzart.obuka.domain;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CalculationStatistics implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date processingTime;
	
	
	@Override
	public String toString() {
		return "ID:" + id + " time:" + processingTime;
	}



}
