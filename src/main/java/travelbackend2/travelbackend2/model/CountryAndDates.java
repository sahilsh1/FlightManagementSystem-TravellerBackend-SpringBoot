package travelbackend2.travelbackend2.model;

public class CountryAndDates {

	
	private String name;
	private int days;
	public CountryAndDates(String name, int days) {
		super();
		this.name = name;
		this.days = days;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
}
