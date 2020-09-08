package me.alexwebber.covid.display.data;

import com.google.gson.annotations.SerializedName;

public class Point {

	@SerializedName("x")
	String date;
	@SerializedName("y")
	Integer numberOfCases;

	public Point(String date, Integer numberOfCases) {
		super();
		this.date = date;
		this.numberOfCases = numberOfCases;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the numberOfCases
	 */
	public Integer getNumberOfCases() {
		return numberOfCases;
	}

	/**
	 * @param numberOfCases the numberOfCases to set
	 */
	public void setNumberOfCases(Integer numberOfCases) {
		if (numberOfCases < 0) {
			this.numberOfCases = 0;
		} else {
			this.numberOfCases = numberOfCases;
		}
	}

}
