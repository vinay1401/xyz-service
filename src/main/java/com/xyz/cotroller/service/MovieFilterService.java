package com.xyz.cotroller.service;

import java.util.List;

import com.xyz.vo.MovieDetails;
import com.xyz.vo.MovieRequestVo;

public interface MovieFilterService {
	List<MovieDetails> filterMovie(MovieRequestVo movieRequestVo);
}
