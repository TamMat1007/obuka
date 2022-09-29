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

public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	
	
	@Override
	public String toString() {
		return "Player- ID:" + id + "  username:" + username;
	}
}
