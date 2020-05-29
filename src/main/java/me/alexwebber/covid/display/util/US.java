package me.alexwebber.covid.display.util;

public enum US {

	ALABAMA("Alabama", "AL", 4903185), ALASKA("Alaska", "AK", 731545), ARIZONA("Arizona", "AZ", 7278717),
	ARKANSAS("Arkansas", "AR", 3017825), CALIFORNIA("California", "CA", 39512223), COLORADO("Colorado", "CO", 5758736),
	CONNECTICUT("Connecticut", "CT", 3565287), DELAWARE("Delaware", "DE", 973764), FLORIDA("Florida", "FL", 21477737),
	GEORGIA("Georgia", "GA", 10617423), HAWAII("Hawaii", "HI", 1415872), IDAHO("Idaho", "ID", 1787065),
	ILLINOIS("Illinois", "IL", 12671821), INDIANA("Indiana", "IN", 6732219), IOWA("Iowa", "IA", 3155070),
	KANSAS("Kansas", "KS", 2913314), KENTUCKY("Kentucky", "KY", 4467673), LOUISIANA("Louisiana", "LA", 4648794),
	MAINE("Maine", "ME", 1344212), MARYLAND("Maryland", "MD", 6045680), MASSACHUSETTS("Massachusetts", "MA", 6949503),
	MICHIGAN("Michigan", "MI", 9986857), MINNESOTA("Minnesota", "MN", 5639632),
	MISSISSIPPI("Mississippi", "MS", 2976149), MISSOURI("Missouri", "MO", 6137428), MONTANA("Montana", "MT", 1068778),
	NEBRASKA("Nebraska", "NE", 1934408), NEVADA("Nevada", "NV", 3080156), NEW_HAMPSHIRE("New Hampshire", "NH", 1359711),
	NEW_JERSEY("New Jersey", "NJ", 8882190), NEW_MEXICO("New Mexico", "NM", 2096829),
	NEW_YORK("New York", "NY", 19453561), NORTH_CAROLINA("North Carolina", "NC", 10488084),
	NORTH_DAKOTA("North Dakota", "ND", 762062), OHIO("Ohio", "OH", 11689100), OKLAHOMA("Oklahoma", "OK", 3956971),
	OREGON("Oregon", "OR", 4217737), PENNSYLVANIA("Pennsylvania", "PA", 12801989),
	RHODE_ISLAND("Rhode Island", "RI", 1059361), SOUTH_CAROLINA("South Carolina", "SC", 5148714),
	SOUTH_DAKOTA("South Dakota", "SD", 884659), TENNESSEE("Tennessee", "TN", 6833174), TEXAS("Texas", "TX", 28995881),
	UTAH("Utah", "UT", 3205958), VERMONT("Vermont", "VT", 623989), VIRGINIA("Virginia", "VA", 8535519),
	WASHINGTON("Washington", "WA", 7614893), WEST_VIRGINIA("West Virginia", "WV", 1792147),
	WISCONSIN("Wisconsin", "WI", 5822434), WYOMING("Wyoming", "WY", 578759);

	String unabbreviated;
	String ANSIabbreviation;
	Integer population;

	US(String unabbreviated, String ANSIabbreviation, Integer population) {
		this.unabbreviated = unabbreviated;
		this.ANSIabbreviation = ANSIabbreviation;
		this.population = population;
	}

	/**
	 * The full, unabbreviated name of this state.
	 */
	public String getUnabbreviated() {
		return this.unabbreviated;
	}

	/**
	 * The ANSI abbreviated name of this state, e.g. "NY", or "WY".
	 */
	public String getANSIAbbreviation() {
		return this.ANSIabbreviation;
	}

	/**
	 * The ISO abbreviated name of this state, e.g. "US-NY", or "US-WY".
	 */
	public Integer getPopulation() {
		return this.population;
	}

	public static Integer getPopulation(String input) {
		if (null == input) {
			return null;
		}
		input = input.trim();
		for (US state : values()) {
			if (state.ANSIabbreviation.equalsIgnoreCase(input)) {

				return state.population;
			}
		}
		return null;
	}

	/**
	 * Parse string input to enum. Accepts unabbreviated and abbreviated forms. Case
	 * insensitive.
	 * 
	 * @param input String to parse
	 * @return The parsed US state, or null on failure.
	 */
	public static String parse(String input) {
		if (null == input) {
			return null;
		}
		input = input.trim();
		for (US state : values()) {
			if (state.unabbreviated.equalsIgnoreCase(input) || state.ANSIabbreviation.equalsIgnoreCase(input)) {
				return state.unabbreviated;
			}
		}
		return null;
	}

	public static String getFullName(String input) {
		if (null == input) {
			return null;
		}
		input = input.trim();
		for (US state : values()) {
			if (state.unabbreviated.equalsIgnoreCase(input) || state.ANSIabbreviation.equalsIgnoreCase(input)) {
				return state.unabbreviated;
			}
		}
		return "";
	}

}