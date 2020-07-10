package matura2019.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task5 {
	public static void main(String[] args) {
		// ----------------------5.1-----------------------
		List<String> strings = getStringList("pogoda.txt");
		// System.out.println("Expected: 1,19,0,0,0, Actual " + strings.get(0));
		List<WeatherData> weatherData = getWeatherData(strings);
		/*
		 * System.out.println("Expected: 1,19,0,0,0, Actual " + weatherData.get(0));
		 * System.out.println("Expected: ??? Actual " +
		 * countHotAndDryDays(weatherData));
		 */
		// ----------------------5.2-----------------------

		/*
		 * List<WeatherData> dayTemp = getDayTemp(strings); List<Double> temperatures =
		 * getTemperatures(weatherData); System.out.println("Expected: 19 Actual " +
		 * temperatures.get(0));
		 * 
		 * 
		 * System.out.println("Expected: [36,38] Actual: " + getLongestSequence(
		 * Arrays.asList(new WeatherData(34, 3.7), new WeatherData(35, 3.4), new
		 * WeatherData(36, 3.5), new WeatherData(37, 3.6), new WeatherData(38, 3.7), new
		 * WeatherData(39, 3.5))));
		 * 
		 * 
		 * System.out.println("Expected: ??? Actual: " + getLongestSequence(dayTemp));
		 */
		List<WeatherData> dayRainCloud = getDayRainCloud(strings).subList(0, 300);
		System.out.println(
				"Expected: C1:7.5, C2:1, S1: 4 Actual: " + getAverageRain(Arrays.asList(new WeatherData(1, 10, "C", 1),
						new WeatherData(1, 5, "C", 1), new WeatherData(1, 1, "C", 2), new WeatherData(1, 4, "S", 1))));
		Map<String, Double> result = getAverageRain(dayRainCloud);
		List<String> clouds = new ArrayList<>(result.keySet());
		Collections.sort(clouds);
		for (String cloud : clouds) {
			System.out.printf("%s : %.2f \n", cloud, result.get(cloud));
		}

	}

	private static List<WeatherData> getDayRainCloud(List<String> strings) {
		List<WeatherData> weatherData = new ArrayList<>();

		for (String data : strings) {
			String[] row = data.split(";");
			weatherData.add(new WeatherData(Integer.parseInt(row[0]), Integer.parseInt(row[2]), row[3],
					Integer.parseInt(row[4])));
		}
		return weatherData;
	}

	private static Map<String, Double> getAverageRain(List<WeatherData> weatherData) {
		List<WeatherData> rainData = new ArrayList<>(weatherData);
		Map<String, List<Double>> averages = new HashMap<>();
		Map<String, Double> output = new HashMap<>();
		
		for (int i = 1; i <= 5; i++) {
			averages.put("C" + i, Arrays.asList(0.0, 0.0));
			averages.put("S" + i, Arrays.asList(0.0, 0.0));
		}
		
		for (WeatherData dailyData : rainData) {
			int cloudSize = dailyData.getSize();
			int rainFall = dailyData.getRain();
			String cloudNameType = dailyData.getCategory() + cloudSize; 
			
			if (dailyData.getCategory().equals("0")) {
				continue;
			} 
				Double totalRainFall = averages.get(cloudNameType).get(0) + rainFall;
				Double daysWithSameCloudType = averages.get(cloudNameType).get(1) + 1;
				
				averages.put(cloudNameType, Arrays.asList(totalRainFall, daysWithSameCloudType));
			
		}
		
		for (int i = 1; i <= 5; i++) {
			Double cTypeCloudAverage = averages.get("C" + i).get(0) / averages.get("C" + i).get(1);
			Double sTypeCloudAverage =averages.get("S" + i).get(0) / averages.get("S" + i).get(1);
			output.put("C" + i, cTypeCloudAverage);
			output.put("S" + i, sTypeCloudAverage);
		}
		return output;
	}

	private static List<Integer> getLongestSequence(List<WeatherData> dayTemp) {
		List<Integer> firstLast = new ArrayList<>();
		firstLast.add(1);
		firstLast.add(2);

		for (int i = 0; i < dayTemp.size() - 1; i++) {

			for (int j = 0; j < dayTemp.size() - 1; j++) {

				Double temp1 = dayTemp.get(i + j).getTemp();
				Double temp2 = dayTemp.get(i + j + 1).getTemp();

				if (temp1 >= temp2) {

					break;
				} else {

					if (firstLast.get(1) - firstLast.get(0) < dayTemp.get(i + j + 1).getDayID()
							- dayTemp.get(i).getDayID()) {
						firstLast.set(0, dayTemp.get(i).getDayID());
						firstLast.set(1, dayTemp.get(j + i + 1).getDayID());
					}
				}

			}

		}
		return firstLast;
	}

	private static List<WeatherData> getDayTemp(List<String> strings) {
		List<WeatherData> weatherData = new ArrayList<>();

		for (String data : strings) {
			String[] row = data.split(";");
			weatherData.add(new WeatherData(Integer.parseInt(row[0]), Double.parseDouble(row[1].replace(",", "."))));
		}
		return weatherData;
	}

	private static List<Double> getTemperatures(List<WeatherData> weatherData) {
		List<Double> temperatures = new ArrayList<>();

		for (WeatherData data : weatherData) {
			temperatures.add(data.getTemp());
		}
		return temperatures;
	}

	private static int countHotAndDryDays(List<WeatherData> weatherData) {
		int counter = 0;
		for (WeatherData data : weatherData) {
			if (data.getTemp() >= 20 && data.getRain() <= 5) {
				counter++;
			}
		}
		return counter;
	}

	private static List<String> getStringList(String path) {
		List<String> strings = new ArrayList<>();
		try {
			strings = Files.readAllLines(Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		strings.remove(0);
		return strings;
	}

	private static List<WeatherData> getWeatherData(List<String> strings) {
		List<WeatherData> weatherData = new ArrayList<>();

		for (String data : strings) {
			String[] row = data.split(";");
			weatherData.add(new WeatherData(Integer.parseInt(row[0]), Double.parseDouble(row[1].replace(",", ".")),
					Integer.parseInt(row[2]), row[3], Integer.parseInt(row[4])));
		}
		return weatherData;

	}

}

class WeatherData {
	private Integer dayID;
	private Double temp;
	private Integer rain;
	private String category;
	private Integer size;

	public WeatherData(Integer dayID, Double temp, Integer rain, String category, Integer size) {
		super();
		this.dayID = dayID;
		this.temp = temp;
		this.rain = rain;
		this.category = category;
		this.size = size;
	}

	public WeatherData(Integer dayID, Integer rain, String category, Integer size) {
		super();
		this.dayID = dayID;
		this.rain = rain;
		this.category = category;
		this.size = size;
	}

	public WeatherData(Double temp) {
		super();
		this.temp = temp;
	}

	public Integer getDayID() {
		return dayID;
	}

	public void setDayID(Integer dayID) {
		this.dayID = dayID;
	}

	public Double getTemp() {
		return temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public Integer getRain() {
		return rain;
	}

	public void setRain(Integer rain) {
		this.rain = rain;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public WeatherData(Integer dayID, Double temp) {
		super();
		this.dayID = dayID;
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "WeatherData [dayID=" + dayID + ", temp=" + temp + ", rain=" + rain + ", category=" + category
				+ ", size=" + size + "]";
	}

}