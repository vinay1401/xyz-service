package com.xyz.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.xyz.model.ShowBooking;

@Repository
public interface ShowBookingRepository extends JpaRepository<ShowBooking, Long> {

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "10000")})
	public Optional<List<ShowBooking>> getItemAndObtainPessimisticWriteLockingOnItByIdIn(List<Long> bookingIds);
	
}
