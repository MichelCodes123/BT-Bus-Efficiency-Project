package com.michelcodes.busefficiency.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.michelcodes.busefficiency.Models.PenaltyKey;
import com.michelcodes.busefficiency.Models.PenaltyRecord;



@Repository
public interface RecordRepository extends CrudRepository<PenaltyRecord, PenaltyKey>{


	@Query(nativeQuery=true, value = "SELECT * FROM daily_penalty_records WHERE bus_name = ?1")
	List<PenaltyRecord> getBus(String bus);
	
	
	@Query(nativeQuery=true, value = "SELECT * FROM daily_penalty_records Where stop_id = ?2 and bus_name = ?1"
			+ " ORDER BY record_date DESC LIMIT 7")
	List<PenaltyRecord> getLast7Days(String busName, String stop_id);
	
}
