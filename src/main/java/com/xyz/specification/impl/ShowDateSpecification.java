package com.xyz.specification.impl;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.xyz.specification.Specification;
import com.xyz.vo.MovieDetails;

public class ShowDateSpecification implements Specification<MovieDetails> {
	private Date showDate;
	
	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public ShowDateSpecification(Date showDate) {
		super();
		this.showDate = showDate;
	}

	@Override
	public boolean isSatisfied(MovieDetails item) {
		// TODO Auto-generated method stub
		return sdf.format(item.getShowDate()).equals(sdf.format(this.showDate));
	}
}
