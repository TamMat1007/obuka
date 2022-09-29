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

public class Translation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private List<TranslationItems> translationItems;
	
	
	@Override
	public String toString() {
		return "TRANSLATION- ID:" + id ;
	}
}