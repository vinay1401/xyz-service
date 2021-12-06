package com.xyz.specification.impl;

import java.sql.Time;

import com.xyz.specification.Specification;
import com.xyz.vo.MovieDetails;

public class ShowTimeSpecification implements Specification<MovieDetails> {
	private Time showTime;

	public ShowTimeSpecification(Time showTime) {
		super();
		this.showTime = showTime;
	}

	@Override
	public boolean isSatisfied(MovieDetails item) {
		// TODO Auto-generated method stub
		return item.getStartTime().equals(this.showTime);
	}
}
