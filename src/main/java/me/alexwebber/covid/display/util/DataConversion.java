package me.alexwebber.covid.display.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service("dataConversion")
public class DataConversion {

	public String getDateLastWeek() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -7);
		Date todate1 = cal.getTime();
		String fromdate = sdf.format(todate1);

		fromdate = fromdate.replaceAll("-", "");
		return fromdate;
	}

	public String getTodayDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date todate1 = cal.getTime();
		String fromdate = sdf.format(todate1);

		fromdate = fromdate.replaceAll("-", "");
		return fromdate;
	}

	/**
	 * Converts the date returned in the API (in integer format for some goofy
	 * reason) and returns a usable format.
	 * 
	 * @param date The date to be converted
	 * @return The formatted string date
	 * @throws ParseException
	 */
	public String convertDate(Integer date) throws ParseException {
		String rawDate = Integer.toString(date);
		rawDate = rawDate.replaceAll("....", "$0-");
		rawDate = rawDate.substring(0, rawDate.length() - 1);
		rawDate = rawDate.replaceAll(".......", "$0-");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = sdf.parse(rawDate);
		sdf.format(newDate);

		return Long.toString(newDate.getTime());
	}

	public String convertDateStr(Integer date) throws ParseException {
		String rawDate = Integer.toString(date);

		return rawDate;
	}

	public String casesToLevel(Integer cases) {
		String level = "";
		if (cases <= 1000)
			level = "Under 1,000";
		else if (cases > 1000 && cases < 5000)
			level = "1,000 to 5,000";
		else if (cases >= 5000 && cases < 10000)
			level = "5,000 to 10,000";
		else if (cases >= 10000 && cases < 15000)
			level = "10,000 to 15,000";
		else if (cases >= 15000 && cases < 25000)
			level = "15,000 to 25,000";
		else if (cases >= 25000 && cases < 50000)
			level = "25,000 to 50,000";
		else if (cases >= 50000 && cases < 100000)
			level = "50,000 to 100,000";
		else if (cases >= 100000 && cases < 200000)
			level = "100,000 to 200,000";
		else if (cases >= 200000)
			level = "200,000 +";

		return level;
	}

	public Integer getPopulation(String state) {
		Integer population;
		switch (state) {
		case "CA":
			population = 39512223;
			break;
		case "TX":
			population = 28995881;
			break;
		case "FL":
			population = 21477737;
			break;
		case "NY":
			population = 19453561;
			break;
		case "PA":
			population = 12801989;
			break;
		case "IL":
			population = 12671821;
			break;
		case "OH":
			population = 11689100;
			break;
		case "GA":
			population = 10617423;
			break;
		case "NC":
			population = 10488084;
			break;
		case "MI":
			population = 9986857;
			break;
		case "NJ":
			population = 8882190;
			break;
		case "VA":
			population = 8535519;
			break;
		case "WA":
			population = 7614893;
			break;
		case "AZ":
			population = 7278717;
			break;
		case "MA":
			population = 6949503;
			break;
		case "TN":
			population = 6833174;
			break;
		case "IN":
			population = 6732219;
			break;
		case "MO":
			population = 6137428;
			break;
		case "MD":
			population = 6045680;
			break;
		case "WI":
			population = 5822434;
			break;
		case "CO":
			population = 5758736;
			break;
		case "MN":
			population = 5639632;
			break;
		case "SC":
			population = 5148714;
			break;
		case "AL":
			population = 4903185;
			break;
		case "LA":
			population = 4648794;
			break;
		case "KY":
			population = 4467673;
			break;
		case "OR":
			population = 4217737;
			break;
		case "OK":
			population = 3956971;
			break;
		case "CT":
			population = 3565287;
			break;
		case "UT":
			population = 3205958;
			break;
		case "IA":
			population = 3155070;
			break;
		case "NV":
			population = 3080156;
			break;
		case "AR":
			population = 3017825;
			break;
		case "MS":
			population = 2976149;
			break;
		case "KS":
			population = 2913314;
			break;
		case "NM":
			population = 2096829;
			break;
		case "NE":
			population = 1934408;
			break;
		case "WV":
			population = 1792147;
			break;
		case "ID":
			population = 1787065;
			break;
		case "HI":
			population = 1415872;
			break;
		case "NH":
			population = 1359711;
			break;
		case "ME":
			population = 1344212;
			break;
		case "MT":
			population = 1068778;
			break;
		case "RI":
			population = 1059361;
			break;
		case "DE":
			population = 973764;
			break;
		case "SD":
			population = 884659;
			break;
		case "ND":
			population = 762062;
			break;
		case "AK":
			population = 731545;
			break;
		case "VT":
			population = 623989;
			break;
		case "WY":
			population = 578759;
			break;
		default:
			population = 9999999;
		}
		return population;
	}

}
