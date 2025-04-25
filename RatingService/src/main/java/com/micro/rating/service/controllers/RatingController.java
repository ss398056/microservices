package com.micro.rating.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.rating.service.entities.Rating;
import com.micro.rating.service.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		return new ResponseEntity<Rating>(ratingService.createRating(rating),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		return new ResponseEntity<>(ratingService.getRatings(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
		return new ResponseEntity<>(ratingService.getRatingsByUser(userId),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
		return new ResponseEntity<>(ratingService.getRatingByHotel(hotelId),HttpStatus.ACCEPTED);
	}
	
	
	
}
