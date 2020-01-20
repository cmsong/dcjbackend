package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Billing {
	
	@Id
	@Column(name="b_id")
	@GeneratedValue
	private int b_id;
	@Column(nullable=false)
	private String membership_date;
	
	public Billing() {
		super();
	}

	public Billing(int b_id, String membership_date) {
		super();
		this.b_id = b_id;
		this.membership_date = membership_date;
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getMembership_date() {
		return membership_date;
	}

	public void setMembership_date(String membership_date) {
		this.membership_date = membership_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + b_id;
		result = prime * result + ((membership_date == null) ? 0 : membership_date.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Billing other = (Billing) obj;
		if (b_id != other.b_id)
			return false;
		if (membership_date == null) {
			if (other.membership_date != null)
				return false;
		} else if (!membership_date.equals(other.membership_date))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Billing [b_id=" + b_id + ", membership_date=" + membership_date + "]";
	}
	
	

}