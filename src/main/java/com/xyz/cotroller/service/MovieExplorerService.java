package com.xyz.cotroller.service;

import java.util.List;

import com.xyz.vo.MovieDetails;
import com.xyz.vo.MovieRequestVo;

public interface MovieExplorerService {
	public List<MovieDetails> findMovie(MovieRequestVo movieRequestVo);
	public List<MovieDetails> findMovie();
}
