package me.alexwebber.covid.display.util;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.alexwebber.covid.data.COVIDData;
import me.alexwebber.covid.data.models.BasicHistoricalData;
import me.alexwebber.covid.display.data.ProcessHistoricalData;

@Service("sessionHandler")
public class SessionHandler {

	@Autowired
	ProcessHistoricalData historicalData;

	@Autowired
	DataConversion dataConversion;

	public void addIncreaseToStatistics(COVIDData covid, HttpSession session, String date) throws IOException {
		BasicHistoricalData lastWeek = covid.us.getDataForDate(date);
		BasicHistoricalData today = covid.us.getDataForDate(dataConversion.getTodayDate());

		session.setAttribute("confirmedCases", today.getPositive());
		session.setAttribute("confirmedDeaths", today.getDeath());
		session.setAttribute("confirmedTests", today.getTotalTestResults());

		session.setAttribute("confirmedCases7d", lastWeek.getPositive());
		session.setAttribute("confirmedDeaths7d", lastWeek.getDeath());
		session.setAttribute("confirmedTests7d", lastWeek.getTotalTestResults());

		session.setAttribute("caseIncreaseDay", today.getPositiveIncrease());
		session.setAttribute("deathIncreaseDay", today.getDeathIncrease());
		session.setAttribute("testIncreaseDay", today.getTotalTestResultsIncrease());

		session.setAttribute("caseIncrease7d", today.getPositive() - lastWeek.getPositive());
		session.setAttribute("deathIncrease7d", today.getDeath() - lastWeek.getDeath());
		session.setAttribute("testIncrease7d", today.getTotalTestResults() - lastWeek.getTotalTestResults());

		double casePercentIncrease = 100.0 / today.getPositive() * (today.getPositive() - lastWeek.getPositive());
		double deathPercentIncrease = 100.0 / today.getDeath() * (today.getDeath() - lastWeek.getDeath());
		double testPercentIncrease = 100.0 / today.getTotalTestResults()
				* (today.getTotalTestResults() - lastWeek.getTotalTestResults());
		/**
		 * Percents
		 */
		session.setAttribute("casePercentage", casePercentIncrease);
		session.setAttribute("deathPercentage", deathPercentIncrease);
		session.setAttribute("testPercentage", testPercentIncrease);
	}

}
