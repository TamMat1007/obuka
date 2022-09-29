package com.mozzart.obuka.util;

import java.util.Comparator;

import com.mozzart.obuka.domain.ComparationCriteria;
import com.mozzart.obuka.domain.ComparationPattern;
import com.mozzart.obuka.domain.ComparationPatternItems;
import com.mozzart.obuka.domain.Ticket;

public class Util {

	public static Comparator<Ticket> createComparatorChain(ComparationPattern pattern) {
		Comparator<Ticket> resultedComparator = null;
		for(ComparationPatternItems item : pattern.getComparationPatternItems()) {
			Comparator<Ticket> singleComparator = getSingleComparator(item.getComparationCriteria());
			if(resultedComparator == null) {
				resultedComparator = singleComparator;
			}else {
				resultedComparator = resultedComparator.thenComparing(singleComparator);
			}
		}
		return resultedComparator;
	}


	public static Comparator<Ticket> getSingleComparator(ComparationCriteria criteria) {
		switch (criteria) {
		case ODDS: {
			return Ticket.OddsComparator;
		}
		case PAYMENT_DATE: {
			return Ticket.PaymentDateComparator;
		}
		case TICKET_ROW:{
			return Ticket.TicketRowComparator;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + criteria);
		}
	}
	
}


