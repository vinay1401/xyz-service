package com.xyz.cotroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.cotroller.service.BookingService;
import com.xyz.model.ShowBooking;

@RestController
@RequestMapping(path = "booking")
public class MovieBookingController {
	private BookingService bookingService;

	public MovieBookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}

	
	@PostMapping("/")
	public ResponseEntity<List<ShowBooking>> booking(@RequestBody List<Long> ids){
		
		List<ShowBooking> shows = this.bookingService.findAllById(ids);
		
		// Perform Payment Operation, call payment service and wait till certain time to complete payment,
		// use Async call
		
		//if done confirm book seat
		this.bookingService.book(shows);
	
		return new ResponseEntity<List<ShowBooking>>(shows, HttpStatus.OK);
	}
}
