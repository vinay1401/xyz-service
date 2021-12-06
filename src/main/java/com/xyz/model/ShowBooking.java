package com.xyz.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "show_booking")
public class ShowBooking implements Serializable {

	private static final long serialVersionUID = 867321244435481029L;

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "seat_id")
	private Long seatId;

	@Column(name = "movie_show_id")
	private Long movieShowId;

	@Column(name = "movie_id")
	private Long movieId;

	@Column(name = "show_time_id")
	private Long showTimeId;

	@Column(name = "theater_id")
	private Long theaterId;

	@Column(name = "row_id")
	private Long rowId;

	@Column(name = "screen_id")
	private Long screenId;

	@Column(name = "isBooked")
	private Boolean isBooked;
	
	//@Version
	@Column(name = "version")
	private Timestamp version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public Long getMovieShowId() {
		return movieShowId;
	}

	public void setMovieShowId(Long movieShowId) {
		this.movieShowId = movieShowId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getShowTimeId() {
		return showTimeId;
	}

	public void setShowTimeId(Long showTimeId) {
		this.showTimeId = showTimeId;
	}

	public Long getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(Long theaterId) {
		this.theaterId = theaterId;
	}

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public Long getScreenId() {
		return screenId;
	}

	public void setScreenId(Long screenId) {
		this.screenId = screenId;
	}

	public Boolean getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(Boolean isBooked) {
		this.isBooked = isBooked;
	}

	public Timestamp getVersion() {
		return version;
	}

	public void setVersion(Timestamp version) {
		this.version = version;
	}
}
