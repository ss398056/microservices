package com.micro.user.service.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.micro.user.service.entities.Rating;

@FeignClient(name="RATINGSERVICE")
public interface RatingService {
	
	//It is used for get rating details without using RestTemplete API Call
	
	@GetMapping("/ratings/user/{userId}")
	List<Rating> getRatingByUser(@PathVariable String userId);
	
	@PostMapping("/ratings")
	Rating createRating(@RequestBody Rating rating);
	
	@PutMapping("/ratings/{ratingId}")
	Rating updateRating(@RequestBody Rating rating, @PathVariable String ratingId);
	
	@DeleteMapping("/ratings/{ratingId}")
	Rating deleteRating(@PathVariable String ratingId);
}
