package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Review;
import com.revature.repositories.ReviewRepository;
@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	ReviewRepository rp;
	
	@Override
	public Review createReview(Review review) {
		rp.save(review);
		return review;
	}

	@Override
	public Review getReviewByIds(String user, int Gid) {
		return (Review) (rp.findByUsernameAndGid(user, Gid));
	}

	@Override
	public List<Review> getReviewByGame(int Gid) {
		return rp.findByGid(Gid);
	}

	@Override
	public List<Review> getReviewByUser(String user) {
		return rp.findByUsername(user);
	}

	@Override
	public List<Review> allReviews() {
		return (List<Review>) rp.findAll();
	}

	@Override
	public Review updateReview(Review change) {
		return rp.save(change);
	}

	@Override
	public boolean deleteReview(Review review) {
		try {
			rp.delete(review);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Review getReviewByRid(int Rid) {
		return (Review) rp.findByRid(Rid);
	}

}