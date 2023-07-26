package stepDefinitions;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import resources.WeatherApiClient;
import resources.WeatherData;


public class WeatherApiStepDefinitions {

	private String apiKey;
	private WeatherApiClient weatherApiClient;
	private WeatherData weatherData;
	Response response;
	ResponseSpecification responseSpecification;

	@Given("I have an API key")
	public void iHaveAnApiKey() {
		apiKey = "488a8c960a4a4e519bd66219340023b6";
		// Create an instance of the WeatherApiClient with the API key
		weatherApiClient = new WeatherApiClient(apiKey);
	}

	@When("I get the current weather data by latitude {string} and longitude {string}")
	public void iGetTheCurrentWeatherDataByLatLon(String lat, String lon) {

		double latitude = 0.0;
		double longitude = 0.0;

		try {
			// Parse latitude and longitude from string to double
			latitude = Double.parseDouble(lat);
			longitude = Double.parseDouble(lon);
		} catch (NumberFormatException e) {

		}
		// Call the WeatherApiClient to get current weather data by latitude and longitude
		weatherData = weatherApiClient.getCurrentWeatherByLatLon(latitude, longitude);
	}

	@When("I get the current weather data by postal code {string}")
	public void iGetTheCurrentWeatherDataByPostalCode(String post_code) {
		// Call the WeatherApiClient to get current weather data by postal code
		weatherData = weatherApiClient.getCurrentWeatherByPostalCode(post_code);
	}

	@Then("I should see the weather details for that location")
	public void iShouldSeeTheWeatherDetailsForThatLocation() {
		System.out.println("Location: " + weatherData.getLocation());
		System.out.println("Temperature: " + weatherData.getTemperature() + "°C");
		System.out.println("Weather Description: " + weatherData.getWeatherDescription());
		System.out.println("");
		// Perform assertions to validate weather data
		assertWeatherDataValid(weatherData);
	}

	private void assertWeatherDataValid(WeatherData weatherData) {
		// Assert that the weatherData object is not null
		Assert.assertNotNull("WeatherData should not be null", weatherData);

		// Assert that the location is not null or empty
		Assert.assertNotNull("Location should not be null", weatherData.getLocation());
		Assert.assertNotEquals("Location should not be empty", "", weatherData.getLocation());

		// Assert that the temperature is not null
		Assert.assertNotNull("Temperature should not be null", weatherData.getTemperature());

		// Assert that the weather description is not null or empty
		Assert.assertNotNull("Weather description should not be null", weatherData.getWeatherDescription());
		Assert.assertNotEquals("Weather description should not be empty", "", weatherData.getWeatherDescription());
	}
}

