package com.xyz.cotroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.cotroller.service.MovieFilterService;
import com.xyz.vo.MovieDetails;
import com.xyz.vo.MovieRequestVo;

@RestController
@RequestMapping(path = "explore")
public class MovieExplorerController {

	private MovieFilterService movieFilterService;

	public MovieExplorerController(MovieFilterService movieFilterService) {
		super();
		this.movieFilterService = movieFilterService;
	}

	@PostMapping("/")
	public ResponseEntity<List<MovieDetails>> movies(@RequestBody MovieRequestVo movieRequestVo) {
		return new ResponseEntity<>(this.movieFilterService.filterMovie(movieRequestVo), HttpStatus.OK);
	}

}
