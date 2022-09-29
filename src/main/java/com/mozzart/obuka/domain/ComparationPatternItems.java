
package com.mozzart.obuka.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ComparationPatternItems implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long comparationPatternId;
	private Long priority;
	private ComparationCriteria comparationCriteria;
	
	@Override
	public String toString() {
		return "Pattern id: " + comparationPatternId + " priority:" + priority + " comparation criteria:" + comparationCriteria;
	}

}

