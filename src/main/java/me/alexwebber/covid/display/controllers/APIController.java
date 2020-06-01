package me.alexwebber.covid.display.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import me.alexwebber.covid.data.COVIDData;
import me.alexwebber.covid.data.models.StateData;
import me.alexwebber.covid.display.data.StateDataObject;
import me.alexwebber.covid.display.util.US;

@Controller
public class APIController {
	@RequestMapping(value = "/api/states/all", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getStateData() throws IOException {
		Gson gson = new Gson();
		StringBuilder builder = new StringBuilder();

		COVIDData covid = new COVIDData();

		List<StateData> data = covid.state.getDataAsOfToday();
		List<StateDataObject> dataObjects = new ArrayList<StateDataObject>();
		for (StateData d : data) {
			if (d.getState().equals("AS") || d.getState().equals("GU") || d.getState().equals("MP")
					|| d.getState().contentEquals("VI") || d.getState().contentEquals("DC")
					|| d.getState().contentEquals("PR")) {

			} else {
				String sUrl = "<a href=\"/state/" + d.getState().toString() + "\">"
						+ US.getFullName(d.getState().toString()) + "</a>";
				String grade = "-";
				if (d.getGrade() != null)
					grade = d.getGrade();

				dataObjects.add(new StateDataObject(sUrl, d.getPositive(), d.getDeath(), d.getTotal(), grade,
						d.getLastUpdateEt(),
						(Math.round((double) d.getPositive() / US.getPopulation(d.getState()) * 100000) / 1.00),
						(Math.round((double) d.getDeath() / US.getPopulation(d.getState()) * 100000) / 1.00),
						(Math.round((double) d.getTotalTestResults() / US.getPopulation(d.getState()) * 100000)
								/ 1.00)));
			}
		}

		builder.append("{ \"data\": ");
		builder.append(gson.toJson(dataObjects).toString());
		builder.append("}");
		return builder.toString();
	}
}
