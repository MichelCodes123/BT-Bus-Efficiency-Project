package com.michelcodes.busefficiency.Models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@IdClass(PenaltyKey.class)
@Table(name = "daily_penalty_records")
public class PenaltyRecord {
	
	
	@Id
	private String stop_id;
	@Id
	private String bus_name;
	@Id
	private LocalDate record_date;
	
	
	private float penalty;
	
	public PenaltyRecord() {
		
	}
	public PenaltyRecord(String stop_id, String bus_name, LocalDate record_date, float penalty) {
		this.stop_id = stop_id;
		this.bus_name = bus_name;
		this.record_date = record_date;
		this.penalty = penalty;
	}


	public String getStopID() {
		return stop_id;
	}


	public void setStopID(String stop_id) {
		this.stop_id = stop_id;
	}


	public String getBusName() {
		return bus_name;
	}


	public void setBusName(String bus_name) {
		this.bus_name = bus_name;
	}


	public LocalDate getDate() {
		return record_date;
	}


	public void setDate(LocalDate record_date) {
		this.record_date = record_date;
	}


	public float getPenalty() {
		return penalty;
	}


	public void setPenalty(float penalty) {
		this.penalty = penalty;
	}
	

	
	

	

}
