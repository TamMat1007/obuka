package com.mozzart.obuka.domain;

public enum ParticipantType {
	HOME(1), AWAY(2), PARTICIPANT(3);
	
	private Integer id;
	
	private ParticipantType(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}
	
	public static ParticipantType getById(Integer id) {

		switch (id) {
			case 1:
				return HOME;
			case 2:
				return AWAY;
			case 3:
				return PARTICIPANT;

			default:
				return PARTICIPANT;
		}
	}
}
