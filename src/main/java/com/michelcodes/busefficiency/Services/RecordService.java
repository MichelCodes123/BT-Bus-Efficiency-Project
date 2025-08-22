package com.michelcodes.busefficiency.Services;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michelcodes.busefficiency.Repositories.RecordRepository;
import com.michelcodes.busefficiency.Models.BusStopsRecord;
import com.michelcodes.busefficiency.Models.PenaltyRecord;
import com.michelcodes.busefficiency.Repositories.StopsRepository;

@Service
public class RecordService {
	
	
	@Autowired
	private RecordRepository repo; 
	@Autowired
	private StopsRepository srepo;
	
	
	public ArrayList<String> getRoutes(){
		return srepo.getRoutes();
	}
	
	
	/**
	 * Function retrieves all stops for a given bus route, and returns a mapping of that stop to it's penalty average.
	 * 
	 * @param busName Name of the bus to index.
	 * @return Dictionary containing mapping of a particular bus stop to it's penalty average for the week.
	 */
	

	public Map <String, String> getLast7Days(String busName) {
		
	
		//StopName -> Penalty Avg
		Map<String, String> record = new LinkedHashMap<String,String>();
		
		ArrayList<BusStopsRecord> r = srepo.getStops(busName);
		
		
		for (BusStopsRecord a: r) {
				
			String penalty = getPenaltyForStop(busName, a.getStop_id());
			record.put(a.getStop_name(), penalty);
		}

		return record;
		
	}
	
	/**
	 * Retrieves the penalty score for a given stop, over 7 days. Then returns the average.
	 * 
	 * 
	 * @param busName	Name of the bus
	 * @param stopID	The particular stop to find the weekly average for.
	 * @return	Returns floating point average formatted as a string. 
	 */
	public String getPenaltyForStop(String busName, String stopID) {
		float sum = 0;
		float num = 0;
		float avg = 0;
		List<PenaltyRecord> l = repo.getLast7Days(busName, stopID);
			
		for (PenaltyRecord p: l) {
			
			num = num+1;
			sum += p.getPenalty();
		}
		avg=sum/num;
		
		if (Float.isNaN(avg)) {
			return "0.0";
		}
		
		return String.format("%.2f",avg);
	}
	
	
	public String getTotalScore(Collection <String> r) {
		
		float sum = 0;
		for (String a: r) {
			sum += Float.parseFloat(a);
			
		}
		
		return String.format("%.2f",sum/r.size());
	}
	


	}

