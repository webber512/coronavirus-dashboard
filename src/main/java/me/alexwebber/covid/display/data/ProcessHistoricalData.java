package me.alexwebber.covid.display.data;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import me.alexwebber.covid.data.COVIDData;
import me.alexwebber.covid.data.models.BasicHistoricalData;
import me.alexwebber.covid.data.models.StateHistoricalData;
import me.alexwebber.covid.display.util.DataConversion;

@Service("processHistoricalData")
public class ProcessHistoricalData {

	@Autowired
	DataConversion dataConversion;

	public String processHistorical(COVIDData covid, String variable, String type) throws IOException, ParseException {

		List<BasicHistoricalData> usDataObjects = covid.us.getDataAllTime();
		List<Point> point = new ArrayList<Point>();

		if (variable.equalsIgnoreCase("cases")) {
			if (type.equalsIgnoreCase("daily")) {
				for (BasicHistoricalData data : usDataObjects) {
					point.add(new Point(dataConversion.convertDate(data.getDate()), data.getPositiveIncrease()));
				}
			} else if (type.equalsIgnoreCase("cumulative"))
				for (BasicHistoricalData data : usDataObjects) {
					point.add(new Point(dataConversion.convertDate(data.getDate()), data.getPositive()));
				}
		} else if (variable.equalsIgnoreCase("deaths")) {
			if (type.equalsIgnoreCase("daily")) {
				for (BasicHistoricalData data : usDataObjects) {
					if (data.getDeath() == null) {
						point.add(new Point(dataConversion.convertDate(data.getDate()), 0));
					} else {
						point.add(new Point(dataConversion.convertDate(data.getDate()), data.getDeathIncrease()));
					}
				}
			} else if (type.equalsIgnoreCase("cumulative")) {
				for (BasicHistoricalData data : usDataObjects) {
					if (data.getDeath() == null) {
						point.add(new Point(dataConversion.convertDate(data.getDate()), 0));
					} else {
						point.add(new Point(dataConversion.convertDate(data.getDate()), data.getDeath()));
					}
				}
			}
		} else if (variable.equalsIgnoreCase("tests")) {
			if (type.equalsIgnoreCase("daily")) {
				for (BasicHistoricalData data : usDataObjects) {
					if (data.getTotalTestResultsIncrease() < 0) {
						point.add(new Point(dataConversion.convertDate(data.getDate()), 0));
					} else {
						point.add(new Point(dataConversion.convertDate(data.getDate()),
								data.getTotalTestResultsIncrease()));

					}
				}
			}
		}

		Gson gson = new Gson();
		String json = gson.toJson(point);

		json = json.replace("\"", "");
		return json;

	}

	public String processHistorical(COVIDData covid, String variable, String type, String state)
			throws ParseException, IOException {
		List<StateHistoricalData> usDataObjects = covid.state.getDataAllTimeForState(state);
		List<Point> point = new ArrayList<Point>();

		if (variable.equalsIgnoreCase("cases")) {
			if (type.equalsIgnoreCase("daily")) {
				for (StateHistoricalData data : usDataObjects) {
					point.add(new Point(dataConversion.convertDate(Integer.parseInt(data.getDate())),
							data.getPositiveIncrease()));
				}
			} else if (type.equalsIgnoreCase("cumulative"))
				for (StateHistoricalData data : usDataObjects) {
					point.add(new Point(dataConversion.convertDate(Integer.parseInt(data.getDate())),
							data.getPositive()));
				}
		} else if (variable.equalsIgnoreCase("deaths")) {
			if (type.equalsIgnoreCase("daily")) {
				for (StateHistoricalData data : usDataObjects) {
					if (data.getDeath() == null) {
						point.add(new Point(dataConversion.convertDate(Integer.parseInt(data.getDate())), 0));
					} else {
						point.add(new Point(dataConversion.convertDate(Integer.parseInt(data.getDate())),
								data.getDeathIncrease()));
					}
				}
			} else if (type.equalsIgnoreCase("cumulative")) {
				for (StateHistoricalData data : usDataObjects) {
					if (data.getDeath() == null) {
						point.add(new Point(dataConversion.convertDate(Integer.parseInt(data.getDate())), 0));
					} else {
						point.add(new Point(dataConversion.convertDate(Integer.parseInt(data.getDate())),
								data.getDeath()));
					}
				}
			}
		} else if (variable.equalsIgnoreCase("tests")) {
			if (type.equalsIgnoreCase("daily")) {
				for (StateHistoricalData data : usDataObjects) {
					if (data.getTotalTestResultsIncrease() > 0) {
						point.add(new Point(dataConversion.convertDate(Integer.parseInt(data.getDate())),
								data.getTotalTestResultsIncrease()));
					} else {
						point.add(new Point(dataConversion.convertDate(Integer.parseInt(data.getDate())), 0));
					}
				}
			}
		}

		Gson gson = new Gson();
		String json = gson.toJson(point);

		json = json.replace("\"", "");
		return json;
	}

	public BasicHistoricalData getDataOnDate(COVIDData covid, String date) throws IOException {
		BasicHistoricalData data = covid.us.getDataForDate(date);
		return data;
	}

}
