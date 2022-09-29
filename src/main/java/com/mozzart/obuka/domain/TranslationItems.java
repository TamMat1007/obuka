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

public class TranslationItems implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long translationId;
	private Long languageId;
	private String value;
	
	@Override
	public String toString() {
		return "Translation: " + value ;
	}

}
