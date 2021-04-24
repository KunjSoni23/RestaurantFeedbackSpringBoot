package ca.sheridancollege.sonikunj.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ca.sheridancollege.sonikunj.beans.RestaurantReview;
import ca.sheridancollege.sonikunj.database.DatabaseAccess;


@Controller
public class MyController {
	@Autowired
	DatabaseAccess da;
	
	@GetMapping("/")
	public String getIndex(Model model, RestaurantReview restaurantReview) {
		ArrayList<RestaurantReview> list = da.getReview();
		model.addAttribute("restaurantReviews", list);
		return "index";
		}
	
	@PostMapping("/")
	public String insertRestaurant(Model model, @ModelAttribute RestaurantReview restaurantReview) {
		da.addReview(restaurantReview);
		model.addAttribute("restaurantReview", new RestaurantReview());
		ArrayList<RestaurantReview> list = da.getReview();
		model.addAttribute("restaurantReviews", list);
		return "index";
	}
}
