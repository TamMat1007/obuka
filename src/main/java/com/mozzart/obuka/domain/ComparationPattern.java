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

public class ComparationPattern   implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private List<ComparationPatternItems> comparationPatternItems;
	
	
	@Override
	public String toString() {
		return "ID:" +id;
	}
	
}
