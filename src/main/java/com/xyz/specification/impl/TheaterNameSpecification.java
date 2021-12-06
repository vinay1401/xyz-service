package com.xyz.specification.impl;

import com.xyz.specification.Specification;
import com.xyz.vo.MovieDetails;

public class TheaterNameSpecification implements Specification<MovieDetails> {
	private String theaterName;

	public TheaterNameSpecification(String theaterName) {
		super();
		this.theaterName = theaterName;
	}

	@Override
	public boolean isSatisfied(MovieDetails item) {
		// TODO Auto-generated method stub
		return item.getTheaterName().contains(this.theaterName);
	}
}
