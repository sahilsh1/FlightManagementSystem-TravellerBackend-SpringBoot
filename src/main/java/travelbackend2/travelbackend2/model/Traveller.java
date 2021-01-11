package travelbackend2.travelbackend2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Traveller {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String flying_to;
	private String flying_from;
	private Date departure_date;
	private Date end_date;
	
	@ManyToOne
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlying_to() {
		return flying_to;
	}

	public void setFlying_to(String flying_to) {
		this.flying_to = flying_to;
	}

	public String getFlying_from() {
		return flying_from;
	}

	public void setFlying_from(String flying_from) {
		this.flying_from = flying_from;
	}

	public Date getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(Date departure_date) {
		this.departure_date = departure_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}

