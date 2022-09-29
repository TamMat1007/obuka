package com.mozzart.obuka.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Ticket implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Double payment;
	private Date paymentDate;
	private Long sumId;
	private Origin origin;
	private Integer potentialPayout;
	private Double winOdds;
	private Long playerId;
	private Boolean system;
	private Date timeChanged;
	private List<TicketRow> ticketRows;
	
	
	@Override
	public String toString() {
		return "Ticket- ID:" + id + " payment:" + payment + " potential payout:" + potentialPayout + " win odds:" + winOdds;
	}
	

	@Override
	public boolean equals(Object o) {
		
		if (this == o)
	        return true;
	    if (o == null)
	        return false;
	    if (getClass() != o.getClass())
	        return false;
	    Ticket ticket = (Ticket) o;
	    return Objects.equals(id, ticket.id);
	}
	
	public static Comparator<Ticket> TicketRowComparator = new Comparator<Ticket>() {

        @Override
        public int compare(Ticket t1, Ticket t2) {
            return (int) (t1.getTicketRows().size() - t2.getTicketRows().size() );
        }
	};
    public static Comparator<Ticket> OddsComparator = new Comparator<Ticket>() {

        @Override
        public int compare(Ticket t1, Ticket t2) {
            return (int) (t1.getWinOdds() - t2.getWinOdds());
        }
    };
    
    public static Comparator<Ticket> PaymentDateComparator = new Comparator<Ticket>() {

        @Override
        public int compare(Ticket t1, Ticket t2) {
            return t2.getPaymentDate().compareTo(t1.getPaymentDate());
        }
    };
}