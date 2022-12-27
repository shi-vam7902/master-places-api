package com.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Bean.PlaceBean;
import com.dao.PlaceDao;

@RestController
public class PlaceController {

	@Autowired
	PlaceDao placedao;
	// adding places
	@PostMapping("/place")
	public ResponseEntity addPlace(@RequestBody PlaceBean places)
	{
		LocalDate time = LocalDate.now();
		places.setCreatedAt(time.toString());
		placedao.addPlaces(places);
		return ResponseEntity.ok(places);
	}
	// get all places
	@GetMapping("/place")
	public ResponseEntity getAllPlaces()
	{
		List<PlaceBean> places = placedao.getAllPlaces();
		return ResponseEntity.ok(places);
	}
	//delete place
	@DeleteMapping("/place")
	public ResponseEntity deletePlace(@RequestParam("placeid") int placeid)
	{
		
		return ResponseEntity.ok(placeid);
	}
}
