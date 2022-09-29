package com.mozzart.obuka.domain;

public enum Origin {
	WEB(2), ANDROID(3), LAND(1), IOS(4);
	
	private Integer id;
	
	private Origin(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}
	
	public static Origin getById(Integer id) {

		switch (id) {
			case 1:
				return LAND;
			case 2:
				return WEB;
			case 3:
				return ANDROID;
			case 4:
				return IOS;

			default:
				return LAND;
		}
	}
}
