package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.PlaceBean;

@Repository
public class PlaceDao {

	@Autowired
	JdbcTemplate stmt;
//addding a places
	public void addPlaces(PlaceBean pbean) {
		stmt.update(
				"insert into places (userid,title,location,speciality,best_time_to_visit,approved,createdAt,category) values (?,?,?,?,?,?,?,?)",
				pbean.getUserid(), pbean.getTitle(), pbean.getLocation(), pbean.getBestTimeToVisit(),
				pbean.isApproved(), pbean.getCreatedAt(), pbean.getCategory(),pbean.getSpeciality());
	}
// all place 
	public List<PlaceBean> getAllPlaces() {
		List<PlaceBean> places = stmt.query("select * from places",
				new BeanPropertyRowMapper<PlaceBean>(PlaceBean.class));
		return places;
	}
	//delete place
	public Integer deletePlace(Integer placeid)
	{
		return stmt.update("delete from places where placeid = ?",placeid);
	}
}