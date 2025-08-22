package com.michelcodes.busefficiency.Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class StopsKey implements Serializable {
	
	
	private String stop_id, bus_name;
	
	private int stop_sequence;

	
	
	@Override
	public boolean equals(Object o) {
		
		if (this == o) return true;
		StopsKey obj = (StopsKey) o;
		return Objects.equals(stop_id, obj.stop_id) &&  Objects.equals(bus_name, obj.bus_name) && stop_sequence == obj.stop_sequence;
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(stop_id, bus_name,stop_sequence);
	}

}



