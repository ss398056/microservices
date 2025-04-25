package com.micro.rating.service.services.imp;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.rating.service.entities.Rating;
import com.micro.rating.service.repositories.RatingRepository;
import com.micro.rating.service.services.RatingService;

@Service
public class RatingServiceImp implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;
	
	
	@Override
	public Rating createRating(Rating rating) {
		String id = UUID.randomUUID().toString();
		rating.setRatingId(id);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingsByUser(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotel(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}
