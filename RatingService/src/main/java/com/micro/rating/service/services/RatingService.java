package com.micro.rating.service.services;

import java.util.List;

import com.micro.rating.service.entities.Rating;

public interface RatingService {
	
	Rating createRating(Rating rating);
	
	List<Rating> getRatings();
	
	List<Rating> getRatingsByUser(String userId);
	
	List<Rating> getRatingByHotel(String hotelId);
	
}
