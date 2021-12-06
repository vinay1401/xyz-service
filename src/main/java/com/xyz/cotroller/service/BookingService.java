package com.xyz.cotroller.service;

import java.util.List;

import com.xyz.model.ShowBooking;

public interface BookingService {
	public List<ShowBooking> findAllById(List<Long> bookingIds);
	public void book(List<ShowBooking> showBookings);
}
