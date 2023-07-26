package resources;

public class WeatherData {
	private String location;
	private double temperature;
	private String weatherDescription;

	//Constructor to create a new WeatherData object.
	public WeatherData(String location, double temperature, String weatherDescription) {
		this.location = location;
		this.temperature = temperature;
		this.weatherDescription = weatherDescription;
	}

	public String getLocation() {
		return location;
	}

	public double getTemperature() {
		return temperature;
	}

	public String getWeatherDescription() {
		return weatherDescription;
	}
}
