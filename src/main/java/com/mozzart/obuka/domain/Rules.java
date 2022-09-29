package com.mozzart.obuka.domain;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rules implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private Integer minRows;
    private Double minPayment;
    private Boolean system;
    private Integer minWinRows;
    private Integer maxLoseRows;
	private List<Sum> sums;
	private Boolean outOfTimeBorder;
	
	private List<Competition> competitions;

	
	@Override
	public String toString() {
		return "Rules- ID:" + id ;
	}
}
