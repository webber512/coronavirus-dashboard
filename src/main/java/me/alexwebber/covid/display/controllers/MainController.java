package me.alexwebber.covid.display.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import me.alexwebber.covid.data.COVIDData;
import me.alexwebber.covid.data.models.StateData;
import me.alexwebber.covid.display.data.ProcessHistoricalData;
import me.alexwebber.covid.display.util.DataConversion;
import me.alexwebber.covid.display.util.SessionHandler;
import me.alexwebber.covid.display.util.US;

@Controller
public class MainController {

	@Autowired
	ProcessHistoricalData historicalData;

	@Autowired
	DataConversion dataConversion;

	@Autowired
	SessionHandler sessionHandler;

	@GetMapping(value = { "/home", "/" })
	public String getHomeView(Model model, HttpServletRequest request, HttpSession session)
			throws IOException, ParseException {
		COVIDData covid = new COVIDData();
		model.addAttribute("title", "COVID Dashboard");

		session.setAttribute("dailyDeathIncrease", historicalData.processHistorical(covid, "deaths", "daily"));
		session.setAttribute("dailyCaseIncrease", historicalData.processHistorical(covid, "cases", "daily"));

		session.setAttribute("cumulativeCases", historicalData.processHistorical(covid, "cases", "cumulative"));
		session.setAttribute("cumulativeDeaths", historicalData.processHistorical(covid, "deaths", "cumulative"));

		session.setAttribute("totalTests", historicalData.processHistorical(covid, "tests", "daily"));

		sessionHandler.addIncreaseToStatistics(covid, session, dataConversion.getDateLastWeek());
		model.addAttribute("active", "active");

		return "home";
	}

	@GetMapping(value = { "/maps" })
	public String getMaps(Model model, HttpServletRequest request, HttpSession session) throws IOException {
		COVIDData covid = new COVIDData();
		List<StateData> data = covid.state.getDataAsOfToday();
		StringBuilder totalData = new StringBuilder();
		StringBuilder perCapData = new StringBuilder();

		for (StateData d : data) {
			if (d.getState().equals("AS")) {

			} else {
				Integer pop = dataConversion.getPopulation(d.getState().toString());
				Integer cases = d.getPositive();
				Integer deaths = d.getDeath();
				Integer tests = d.getTotalTestResults();

				double caseRate = Math.round(((((double) cases / (double) pop) * 100000) * 100) / 100);
				double deathRate = Math.round(((((double) deaths / (double) pop) * 100000) * 100) / 100);
				double testRate = Math.round(((((double) tests / (double) pop) * 100000) * 100) / 100);

				System.out.println(d.getState() + "\t" + caseRate + "\t" + deathRate + "\t" + testRate);

				totalData.append("[\"" + d.getState().toString() + "\", " + d.getPositive() + ", " + d.getDeath() + ", "
						+ d.getTotalTestResults() + "],");
				perCapData.append("[\"" + d.getState().toString() + "\", " + caseRate + ", " + deathRate + ", "
						+ testRate + "],");
			}
		}

		perCapData.setLength(perCapData.length() - 1);

		model.addAttribute("stateData", totalData.toString());
		model.addAttribute("perCapData", perCapData.toString());

		sessionHandler.addIncreaseToStatistics(covid, session, dataConversion.getDateLastWeek());

		model.addAttribute("title", "COVID Dashboard - Maps");
		return "maps";
	}

	@GetMapping(value = { "/states" })
	public String getAllStateData(Model model, HttpServletRequest request, HttpSession session) throws IOException {
		model.addAttribute("title", "COVID Dashboard - State");
		return "states";
	}

	@GetMapping(value = { "/state/{state}" })
	public String getStateData(@PathVariable("state") String state, Model model, HttpServletRequest request,
			HttpSession session) throws IOException, ParseException {
		if (US.getFullName(state).equalsIgnoreCase("")) {
		} else {
			COVIDData covid = new COVIDData();

			model.addAttribute("state", US.getFullName(state));
			model.addAttribute("stateDeathIncrease", historicalData.processHistorical(covid, "deaths", "daily", state));
			model.addAttribute("stateCaseIncrease", historicalData.processHistorical(covid, "cases", "daily", state));

			model.addAttribute("stateCumulativeCases", historicalData.processHistorical(covid, "cases", "cumulative", state));
			model.addAttribute("stateCumulativeDeaths", historicalData.processHistorical(covid, "deaths", "cumulative", state));

			model.addAttribute("stateTotalTests", historicalData.processHistorical(covid, "tests", "daily", state));
		}
		return "state";
	}
}