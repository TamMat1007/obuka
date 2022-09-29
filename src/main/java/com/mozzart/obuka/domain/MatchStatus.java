package com.mozzart.obuka.domain;

public enum MatchStatus {
	FINISHED(3), POSTPONED(2), HAS_NOT_STARTED(1);
	
	private Integer id;
	
	private MatchStatus(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}
	
	public static MatchStatus getById(Integer id) {

		switch (id) {
			case 1:
				return HAS_NOT_STARTED;
			case 2:
				return POSTPONED;
			case 3:
				return FINISHED;

			default:
				return HAS_NOT_STARTED;
		}
	}
}
