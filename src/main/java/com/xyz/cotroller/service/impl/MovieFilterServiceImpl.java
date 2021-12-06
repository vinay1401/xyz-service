package com.xyz.cotroller.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.xyz.cotroller.service.MovieExplorerService;
import com.xyz.cotroller.service.MovieFilterService;
import com.xyz.specification.Filter;
import com.xyz.specification.Specification;
import com.xyz.specification.impl.MovieTitleSpecification;
import com.xyz.specification.impl.ShowDateSpecification;
import com.xyz.specification.impl.ShowTimeSpecification;
import com.xyz.specification.impl.TheaterCitySpecification;
import com.xyz.specification.impl.TheaterNameSpecification;
import com.xyz.vo.MovieDetails;
import com.xyz.vo.MovieRequestVo;

@Service
public class MovieFilterServiceImpl implements MovieFilterService {

	private MovieFilter movieFilter;
	private MovieExplorerService movieExplorerService;

	public MovieFilterServiceImpl(MovieFilter movieFilter, MovieExplorerService movieExplorerService) {
		super();
		this.movieExplorerService = movieExplorerService;
		this.movieFilter = movieFilter;
	}

	@Override
	public List<MovieDetails> filterMovie(MovieRequestVo movieRequestVo) {
		
		List<MovieDetails> movies = movieExplorerService.findMovie();
		
		Stream<MovieDetails> filterStream = movies.stream();

		if (null != movieRequestVo.getCity()) {
			filterStream = movieFilter.filter(filterStream, new TheaterCitySpecification(movieRequestVo.getCity()));
		}

		if (null != movieRequestVo.getTheaterName()) {
			filterStream = movieFilter.filter(filterStream,
					new TheaterNameSpecification(movieRequestVo.getTheaterName()));
		}

		if (null != movieRequestVo.getShowDate()) {
			filterStream = movieFilter.filter(filterStream, new ShowDateSpecification(movieRequestVo.getShowDate()));
		}

		if (null != movieRequestVo.getStartTime()) {
			filterStream = movieFilter.filter(filterStream, new ShowTimeSpecification(movieRequestVo.getStartTime()));
		}

		if (null != movieRequestVo.getTitle()) {
			filterStream = movieFilter.filter(filterStream, new MovieTitleSpecification(movieRequestVo.getTitle()));
		}

		return filterStream.collect(Collectors.toList());
	}
}

@Component
class MovieFilter implements Filter<MovieDetails> {

	@Override
	public Stream<MovieDetails> filter(Stream<MovieDetails> items, Specification<MovieDetails> specification) {
		// TODO Auto-generated method stub
		return items.filter(e -> specification.isSatisfied(e));
	}

}