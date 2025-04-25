package com.micro.hotel.service.services;

import java.util.List;

import com.micro.hotel.service.entities.Hotel;

public interface HotelService {
	
	Hotel createHotel(Hotel hotel);
	
	List<Hotel> getAllHotel();
	
	Hotel getHotel(String hotelId);
	
}
