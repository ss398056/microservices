package com.micro.rating.service.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.micro.rating.service.entities.Rating;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {
	
	//custom methods as per requirement
	
	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);
	
	
}
