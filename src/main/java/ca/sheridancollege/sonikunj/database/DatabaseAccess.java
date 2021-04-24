package ca.sheridancollege.sonikunj.database;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ca.sheridancollege.sonikunj.beans.RestaurantReview;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void addReview(RestaurantReview restaurantReview) {
		String query="INSERT INTO review (name,review,reviewDate, reviewTime)"
				+ " VALUES (:n,:r,:rd,:rt)";

		MapSqlParameterSource namedParameters = 
						new MapSqlParameterSource();
		namedParameters.addValue("n", restaurantReview.getName());
		namedParameters.addValue("r", restaurantReview.getReview());		
		namedParameters.addValue("rd", restaurantReview.getReviewDate());
		namedParameters.addValue("rt", restaurantReview.getReviewTime());
		jdbc.update(query, namedParameters);
	}
	
	public ArrayList<RestaurantReview> getReview() {
		String q = "SELECT id,name, review, reviewDate, reviewTime from review";
		ArrayList<RestaurantReview> restaurantReviews = (ArrayList<RestaurantReview>) jdbc.query(q,
		new BeanPropertyRowMapper<RestaurantReview>(RestaurantReview.class));
		return restaurantReviews;
	}
}
