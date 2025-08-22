package com.michelcodes.busefficiency.Repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.michelcodes.busefficiency.Models.BusStopsRecord;
import com.michelcodes.busefficiency.Models.StopsKey;

@Repository
public interface StopsRepository extends CrudRepository<BusStopsRecord, StopsKey> {
	
	
	@Query(nativeQuery=true, value = "SELECT * FROM bus_stops WHERE bus_name = ?1 ORDER BY stop_sequence ASC")
	ArrayList<BusStopsRecord> getStops(String busName);
	
	@Query(nativeQuery=true, value = "SELECT DISTINCT bus_name from bus_stops")
	ArrayList<String> getRoutes();
	
	

}
