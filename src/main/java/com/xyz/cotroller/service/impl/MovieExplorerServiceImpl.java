package com.xyz.cotroller.service.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.xyz.cotroller.service.MovieExplorerService;
import com.xyz.mapper.MovieDetailsMapper;
import com.xyz.vo.MovieDetails;
import com.xyz.vo.MovieRequestVo;

@Service
public class MovieExplorerServiceImpl implements MovieExplorerService{

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public MovieExplorerServiceImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		super();
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}


	@Override
	public List<MovieDetails> findMovie(MovieRequestVo movieRequestVo){
		
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		
		StringBuilder sql = new StringBuilder("select distinct m.*, ms.show_date, st.name as show_name, st.start_time, st.end_time, t.name as theater_name, t.address, city.place_name as city, country.place_name as country\r\n"
				+ "from movie_show ms "
				+ "inner join show_time st on ms.show_time_id = st.show_id "
				+ "inner join movie m on m.movie_id = ms.movie_id "
				+ "inner join screen s on s.screen_id = ms.screen_id "
				+ "inner join theater t on t.theater_id = s.theater_id "
				+ "inner join place_lookup city on t.place_id = city.place_id "
				+ "inner join place_lookup country on city.place_parent_id = country.place_id where ms.is_cancel is false");
		
		
		StringBuilder whereClouse = new StringBuilder();
		
		if(null != movieRequestVo.getCity()) {
			whereClouse.append(" and city.place_name like :cityName");
			mapSqlParameterSource.addValue("cityName", "%"+movieRequestVo.getCity()+"%");
		}
		
		if(null != movieRequestVo.getTheaterName()) {
			whereClouse.append(" and t.name like :theaterName");
			mapSqlParameterSource.addValue("theaterName", "%"+movieRequestVo.getTheaterName()+"%");
		}
		
		if(null != movieRequestVo.getTitle()) {
			whereClouse.append(" and m.title like :movieTitle");
			mapSqlParameterSource.addValue("movieTitle", "%"+movieRequestVo.getTitle()+"%");
		}
		
		if(null != movieRequestVo.getStartTime()) {
			whereClouse.append(" and st.start_time = :startTime");
			mapSqlParameterSource.addValue("startTime", movieRequestVo.getStartTime());
		}
		
		sql.append(whereClouse);
		
		return this.namedParameterJdbcTemplate.query(sql.toString(), mapSqlParameterSource, new MovieDetailsMapper());
	}
	
	@Override
	@Cacheable(value="movies")
	public List<MovieDetails> findMovie() {
		StringBuilder sql = new StringBuilder(
				"select distinct m.*, ms.show_date, st.name as show_name, st.start_time, st.end_time, t.name as theater_name, t.address, city.place_name as city, country.place_name as country\r\n"
						+ "from movie_show ms " + "inner join show_time st on ms.show_time_id = st.show_id "
						+ "inner join movie m on m.movie_id = ms.movie_id "
						+ "inner join screen s on s.screen_id = ms.screen_id "
						+ "inner join theater t on t.theater_id = s.theater_id "
						+ "inner join place_lookup city on t.place_id = city.place_id "
						+ "inner join place_lookup country on city.place_parent_id = country.place_id where ms.is_cancel is false");

		return this.namedParameterJdbcTemplate.query(sql.toString(), new MovieDetailsMapper());
	}
}

