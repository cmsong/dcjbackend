package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Review;
import com.revature.services.ReviewService;
@RestController
public class ReviewController {
	@Autowired
	ReviewService rs;
	@CrossOrigin(origins="*")
	@RequestMapping(value="/reviews", method=RequestMethod.POST, consumes="application/json")
	public Review createAssociate(@RequestBody Review review) {
		return rs.createReview(review);
	}
	@CrossOrigin(origins="*")
	@GetMapping(value="/reviews")
	public List<Review> allReviews() {
		return rs.allReviews();
	}
	@CrossOrigin(origins="*")
	@GetMapping(value="/reviews/search")
	public Review getReviewByIds(@RequestParam(required=true)String user , @RequestParam(required=true) int gId) {
		return rs.getReviewByIds(user, gId);
	}
	@CrossOrigin(origins="*")
	@GetMapping(value="/reviews/user")
	public List<Review> getReviewByUser(@RequestParam String user){
		return rs.getReviewByUser(user);
	}
	@CrossOrigin(origins="*")
	@GetMapping(value="/reviews/game")
	public List<Review> getReviewByGame(@RequestParam int gId){
		return rs.getReviewByGame(gId);
	}
	@CrossOrigin(origins="*")
	@PutMapping(value="/review", consumes="application/json")
	public Review updateReview(@RequestBody Review change) {
		return rs.updateReview(change);
	}
	@CrossOrigin(origins="*")
	@DeleteMapping(value="/review/{id}")
	public boolean removeAssociate(@PathVariable("id") int id) {
		return rs.deleteReview((rs.getReviewByRid(id)));
	}
}
