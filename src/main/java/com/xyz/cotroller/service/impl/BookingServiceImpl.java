package com.xyz.cotroller.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.cotroller.service.BookingService;
import com.xyz.model.ShowBooking;
import com.xyz.repository.ShowBookingRepository;

@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
@Service
public class BookingServiceImpl implements BookingService {

	private ShowBookingRepository showBookingRepository;

	public BookingServiceImpl(ShowBookingRepository showBookingRepository) {
		super();
		this.showBookingRepository = showBookingRepository;
	}


	@Override
	public List<ShowBooking> findAllById(List<Long> bookingIds) {
		Optional<List<ShowBooking>> bookingOptional =  showBookingRepository.getItemAndObtainPessimisticWriteLockingOnItByIdIn(bookingIds);
		
		if(bookingOptional.isPresent())
			return bookingOptional.get();
		
		return new ArrayList<>();
	}
	
	@Override
	public void book(List<ShowBooking> showBookings) {
		
		showBookings.forEach(e -> e.setIsBooked(true));
		
		this.showBookingRepository.saveAll(showBookings);
	}

}
