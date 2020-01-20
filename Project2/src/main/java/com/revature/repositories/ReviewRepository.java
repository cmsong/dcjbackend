package com.revature.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer>{
	List<Review> findByUsernameAndGid(String username, int Gid);
	List<Review> findByGid(int Gid);
	List<Review> findByUsername(String username);
	List<Review> findByRid(int Rid);
}