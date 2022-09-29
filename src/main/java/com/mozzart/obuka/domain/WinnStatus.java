package com.mozzart.obuka.domain;

public enum WinnStatus {
	ACTIVE(1), WINNING(2), LOSING(3), CANCELLED(4);
	
	private Integer id;
	
	private WinnStatus(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}
	
	public static WinnStatus getById(Integer id) {

		switch (id) {
			case 1:
				return ACTIVE;
			case 2:
				return WINNING;
			case 3:
				return LOSING;
			case 4:
				return CANCELLED;

			default:
				return ACTIVE;
		}
	}
}
