package com.xyz.specification.impl;

import com.xyz.specification.Specification;
import com.xyz.vo.MovieDetails;

public class MovieTitleSpecification implements Specification<MovieDetails> {
	private String title;

	public MovieTitleSpecification(String title) {
		super();
		this.title = title;
	}

	@Override
	public boolean isSatisfied(MovieDetails item) {
		// TODO Auto-generated method stub
		return item.getTitle().contains(this.title);
	}
}
