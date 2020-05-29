package me.alexwebber.covid.display.data;

public class StateDataObject {

	String name;
	Integer positive;
	Integer deaths;
	Integer tests;
	String grade;
	String lastUpdate;
	double positivePerCap;
	double deathPerCap;
	double testPerCap;

	public StateDataObject(String name, Integer positive, Integer deaths, Integer tests, String grade,
			String lastUpdate, double positivePerCap, double deathPerCap, double testPerCap) {
		super();
		this.name = name;
		this.positive = positive;
		this.deaths = deaths;
		this.tests = tests;
		this.grade = grade;
		this.lastUpdate = lastUpdate;
		this.positivePerCap = positivePerCap;
		this.deathPerCap = deathPerCap;
		this.testPerCap = testPerCap;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the positive
	 */
	public Integer getPositive() {
		return positive;
	}

	/**
	 * @param positive the positive to set
	 */
	public void setPositive(Integer positive) {
		this.positive = positive;
	}

	/**
	 * @return the deaths
	 */
	public Integer getDeaths() {
		return deaths;
	}

	/**
	 * @param deaths the deaths to set
	 */
	public void setDeaths(Integer deaths) {
		this.deaths = deaths;
	}

	/**
	 * @return the tests
	 */
	public Integer getTests() {
		return tests;
	}

	/**
	 * @param tests the tests to set
	 */
	public void setTests(Integer tests) {
		this.tests = tests;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the lastUpdate
	 */
	public String getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
