package com.micro.hotel.service.controllers;

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

import com.micro.hotel.service.entities.Hotel;
import com.micro.hotel.service.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> createHotels(@RequestBody Hotel hotel){
		Hotel res = hotelService.createHotel(hotel);
		return new ResponseEntity<Hotel>(res,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels(){
		List<Hotel> res = hotelService.getAllHotel();
		return new ResponseEntity<List<Hotel>>(res, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId){
		Hotel res = hotelService.getHotel(hotelId);
		return new ResponseEntity<Hotel>(res,HttpStatus.ACCEPTED);
	}
	
}
