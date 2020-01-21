package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Users {
	
	@Id
	@Column(name="username")
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private int isPremium;
	@Column(nullable = false)
	private int isAdmin;
	@ManyToOne
	@JoinColumn(name="Billing", nullable=false)
	private Billing billing;
	@Column(nullable = false)
	private String fname;
	@Column(nullable = false)
	private String lname;
	@Column(nullable = false)
	private String email;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="games_users_jt",joinColumns=@JoinColumn(name="username"),inverseJoinColumns=@JoinColumn(name="g_id"))
	private List<Games> ug;

	 
	
	public List<Games> getUg() {
		return ug;
	}

	public void setUg(List<Games> ug) {
		this.ug = ug;
	}

	public Users(String username, String password, int isPremium, int isAdmin, Billing billing, String fname,
			String lname, String email, List<Games> ug) {
		super();
		this.username = username;
		this.password = password;
		this.isPremium = isPremium;
		this.isAdmin = isAdmin;
		this.billing = billing;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.ug = ug;
	}

	public Users() {
		super();
	}

	public Users(String username, String password, int isPremium, int isAdmin, Billing billing, String fname,
			String lname, String email) {
		super();
		this.username = username;
		this.password = password;
		this.isPremium = isPremium;
		this.isAdmin = isAdmin;
		this.billing = billing;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}

	public Users(String username, String password, int isPremium, int isAdmin, String fname, String lname,
			String email) {
		super();
		this.username = username;
		this.password = password;
		this.isPremium = isPremium;
		this.isAdmin = isAdmin;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsPremium() {
		return isPremium;
	}

	public void setIsPremium(int isPremium) {
		this.isPremium = isPremium;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", isPremium=" + isPremium + ", isAdmin="
				+ isAdmin + ", billing=" + billing + ", fname=" + fname + ", lname=" + lname + ", email=" + email + "]";
	}


}