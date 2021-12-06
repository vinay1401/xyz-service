package com.xyz.specification.impl;

import com.xyz.specification.Specification;
import com.xyz.vo.MovieDetails;

public class TheaterCitySpecification implements Specification<MovieDetails> {
	private String city;

	public TheaterCitySpecification(String city) {
		super();
		this.city = city;
	}

	@Override
	public boolean isSatisfied(MovieDetails item) {
		// TODO Auto-generated method stub
		return item.getCity().contains(this.city);
	}
}
