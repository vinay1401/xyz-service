package com.xyz.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xyz.vo.MovieDetails;

public class MovieDetailsMapper implements RowMapper<MovieDetails> {

	@Override
	public MovieDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		MovieDetails md = new MovieDetails();

		md.setMovieId(rs.getLong("movie_id"));
		md.setTitle(rs.getString("title"));
		md.setGenre(rs.getString("genre"));
		md.setGenre(rs.getString("genre"));
		md.setDirector(rs.getString("director"));
		md.setCast(rs.getString("cast"));
		md.setYear(rs.getInt("year"));
		md.setDescription(rs.getString("description"));
		md.setShowName(rs.getString("show_name"));
		md.setStartTime(rs.getTime("start_time"));
		md.setEndTime(rs.getTime("end_time"));
		md.setShowDate(rs.getDate("show_date"));
		md.setTheaterName(rs.getString("theater_name"));
		md.setAddress(rs.getString("address"));
		md.setCity(rs.getString("city"));
		md.setCountry(rs.getString("country"));

		return md;
	}

}
