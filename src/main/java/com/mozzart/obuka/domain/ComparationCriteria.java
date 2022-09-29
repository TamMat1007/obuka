
package com.mozzart.obuka.domain;

public enum ComparationCriteria {
	TICKET_ROW(1), ODDS(2), PAYMENT_DATE(3);
	
	private Integer id;
	
	private ComparationCriteria(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}
	
	public static ComparationCriteria getById(Integer id) {

		switch (id) {
			case 1:
				return TICKET_ROW;
			case 2:
				return ODDS;
			case 3:
				return PAYMENT_DATE;

			default:
				return TICKET_ROW;
		}
	}
}

