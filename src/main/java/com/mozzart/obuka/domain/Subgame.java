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

public class Subgame implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long gameId;
	private Translation translation;
	
	
	@Override
	public String toString() {
		return "Subgame- ID:" + id + " game ID:" + gameId ;
	}
}
