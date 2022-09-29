 package com.mozzart.obuka.domain;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Competition  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Translation translation;
	
	
	@Override
	public String toString() {
		return "Competition- ID:" +id + " translation id:" + translation.getId();
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (this == o)
	        return true;
	    if (o == null)
	        return false;
	    if (getClass() != o.getClass())
	        return false;
	    Competition competition = (Competition) o;
	    return Objects.equals(id, competition.id);
	}
}
