package com.project.beltreview.repositories;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.beltreview.models.Event;

@Repository 												
public interface EventRepository extends CrudRepository<Event,Long>{
	ArrayList<Event> findByState(String state);

	// @Query(value="SELECT * FROM events WHERE state != ?1", nativeQuery=true)
	// ArrayList<Event> findByStateNotEquals(String state);

}
