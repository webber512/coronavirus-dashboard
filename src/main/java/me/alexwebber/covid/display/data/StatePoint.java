package me.alexwebber.covid.display.data;

import com.google.gson.annotations.SerializedName;

public class StatePoint {

	@SerializedName("state")
	String state;
	@SerializedName("cases")
	Integer cases;
	@SerializedName("pop")
	Integer population;

	public StatePoint(String state, Integer cases) {
		super();
		this.state = state;
		this.cases = cases;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the numberOfCases
	 */
	public Integer getCases() {
		if (cases < 0) {
			return 0;
		} else {
			return cases;
		}
	}

	/**
	 * @param numberOfCases the numberOfCases to set
	 */
	public void setNumberOfCases(Integer cases) {
		if (cases < 0) {
			this.cases = 0;
		} else {
			this.cases = cases;
		}
	}

}
