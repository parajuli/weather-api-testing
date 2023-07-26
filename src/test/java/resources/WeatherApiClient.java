package resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class WeatherApiClient {
	private String apiKey;
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	Response response;

	public WeatherApiClient(String apiKey) {
		this.apiKey = apiKey;
	}

	// Get the current weather data by latitude and longitude
	public WeatherData getCurrentWeatherByLatLon(double lat, double lon) {
		// Build the request specification with query parameters for latitude and longitude
		requestSpecification = buildRequestSpec().addQueryParam("lat", lat).addQueryParam("lon", lon).build();
		// Define the response specification to expect status code 200
		responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).build();
		// Make the GET request and store the response
		response = RestAssured.given().spec(requestSpecification).when().get("/current");
		// Extract and return weather data from the response
		return extractWeatherData(response);
	}

	// Get the current weather data by postal code
	public WeatherData getCurrentWeatherByPostalCode(String post_code) {
		// Build the request specification with query parameter for postal code
		requestSpecification = buildRequestSpec().addQueryParam("postal_code", post_code).build();
		// Define the response specification to expect status code 200
		responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).build();
		// Make the GET request and store the response
		response = RestAssured.given().spec(requestSpecification).when().get("/current");
		// Extract and return weather data from the response
		return extractWeatherData(response);
	}

	// Build the common part of the request specification with base URL and API key
	private RequestSpecBuilder buildRequestSpec() {
		return new RequestSpecBuilder().setBaseUri("https://api.weatherbit.io/v2.0")
				.addQueryParam("key", apiKey);
	}

	// Extract weather data from the response using JSONPath
	public WeatherData extractWeatherData(Response response) {
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		// Extract the location, temperature, and weather description from the JSON response
		String location = jsonPath.getString("data[0].city_name");
		double temperature = jsonPath.getDouble("data[0].temp");
		String weatherDescription = jsonPath.getString("data[0].weather.description");
		// Create and return a new WeatherData object
		return new WeatherData(location, temperature, weatherDescription);
	}
}
