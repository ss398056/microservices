package com.micro.hotel.service.services.imp;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.hotel.service.entities.Hotel;
import com.micro.hotel.service.exceptions.ResourceNotFoundException;
import com.micro.hotel.service.repositories.HotelRepository;
import com.micro.hotel.service.services.HotelService;

@Service
public class HotelServiceImp implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		String id = UUID.randomUUID().toString();
		hotel.setHotelId(id);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String hotelId) {
		return hotelRepository.findById(hotelId).
				orElseThrow(()-> new ResourceNotFoundException("Hotel not found with given id "+hotelId));
	}

}
