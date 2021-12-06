package com.xyz.vo;

import java.sql.Date;
import java.sql.Time;

public class MovieRequestVo {
	private String title;
	private String theaterName;
	private String city;
	private Time startTime;
	private Date showDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	@Override
	public String toString() {
		return "MovieRequestVo [title=" + title + ", theaterName=" + theaterName + ", city=" + city + ", startTime="
				+ startTime + ", showDate=" + showDate + "]";
	}
}
