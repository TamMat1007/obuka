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

public class Sum implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	
	@Override
	public String toString() {
		return "Sum- ID:" + id + " name:" + name;
	}
	
	@Override
	public boolean equals(Object o) {

		if (this == o)
	        return true;
	    if (o == null)
	        return false;
	    if (getClass() != o.getClass())
	        return false;
	    Sum sum = (Sum) o;
	    return Objects.equals(id, sum.id);
	}
}