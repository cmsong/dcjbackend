package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private int rid;
	
	private int gid;
	
	private String username;
	
	private String reviewCont;
	
	private int rating;
	
	public Review() {
		super();
	}
	public Review(int rid, int gid, String username, String reviewCont, int rating) {
		super();
		this.rid = rid;
		this.gid = gid;
		this.username = username;
		this.reviewCont = reviewCont;
		this.rating = rating;
	}
	public int getrid() {
		return rid;
	}
	public void setrid(int rid) {
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "Reviews [rid =" + rid + ", g_id=" + gid + ", username=" + username + ", reviewCont=" + reviewCont + ", rating=" + rating
				+ "]";
	}
	public int getgid() {
		return gid;
	}
	public void setgid(int gid) {
		this.gid = gid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getReviewCont() {
		return reviewCont;
	}
	public void setReviewCont(String reviewCont) {
		this.reviewCont = reviewCont;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}