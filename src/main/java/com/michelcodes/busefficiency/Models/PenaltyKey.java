package com.michelcodes.busefficiency.Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class PenaltyKey implements Serializable {
	
	private String stop_id, bus_name;
	private LocalDate record_date;
	
	
	@Override
	public boolean equals(Object o) {
		
		if (this == o) return true;
		PenaltyKey obj = (PenaltyKey) o;
		return record_date.equals(obj.record_date) &&  Objects.equals(bus_name, obj.bus_name) && (Objects.equals(stop_id, obj.stop_id));
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(stop_id, bus_name, record_date);
	}

}
