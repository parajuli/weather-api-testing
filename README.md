# Weather API Testing

This repository contains automated tests for testing the Weather API using Cucumber and RestAssured. The tests are written to validate the current weather data for a given location using either latitude and longitude or postal code.

## Test Description
The Weather API testing framework includes Cucumber scenarios that cover two main test cases:

1. **Get current weather data by latitude and longitude:** This scenario tests the API's ability to provide accurate weather details when queried with latitude and longitude coordinates. The latitude and longitude values are provided as test data examples, and the response is validated to ensure it contains the expected weather information.

2. **Get current weather data by postal code:** This scenario tests the API's capability to retrieve weather data for a specific location using postal codes. Postal codes are provided as test data examples, and the API response is verified to ensure it contains the relevant weather details.

The tests are designed to ensure that the API key is correctly integrated and utilized for making API calls. The response from the API is then parsed using JSONPath to extract the necessary weather data, which is further validated using assertions.

## Prerequisites

Before running the Weather API tests, ensure you have the following prerequisites set up:

1. Java Development Kit (JDK) - Install JDK on your system, as the project requires Java to run.

2. API Key - Obtain a valid API key from WeatherBit API. Replace the dummy API key in the `WeatherApiClient` class with your actual API key.

3. Dependencies - Install the required dependencies listed in the `pom.xml` file. You can use Maven to manage the dependencies.

## Getting Started

To get started with the Weather API testing, follow the steps below:

1. Clone the repository to your local machine:

```
git clone https://github.com/parajuli/weather-api-testing.git
```

2. Install the required dependencies.

3. Ensure you have a valid API key from WeatherBit API. Replace the dummy API key in the `WeatherApiClient` class with your actual API key.

4. Navigate to the `src/test/java/cucumber/Options/TestRunner.java` class and run it as a JUnit test to execute the Cucumber scenarios.

## Troubleshooting

If you encounter any issues while running the tests, consider the following troubleshooting steps:

- **API Key Error**: Double-check your API key to ensure it is valid and correctly entered in the `WeatherApiClient` class.

- **Dependency Issues**: Ensure that all dependencies listed in the `pom.xml` file are installed and properly configured.

- **Cucumber Step Definitions**: Verify that the step definitions in the `WeatherApiStepDefinitions` class are correctly implemented for each scenario.

## Features

## Step Definitions

The step definitions for the Cucumber scenarios are implemented in the `WeatherApiStepDefinitions` class. It uses the RestAssured library to interact with the Weather API and validates the response using assertions.

## Resources

The `resources` package contains classes for interacting with the Weather API and storing weather data. Here are the main classes:

### WeatherApiClient

- The `WeatherApiClient` class contains methods for making API calls to the Weather API using latitude and longitude or postal code.
- The API key is provided in the constructor and used in each API call.
- The response is parsed using JSONPath to extract relevant weather data.
- The `extractWeatherData` method creates a `WeatherData` object with the extracted data.

### WeatherData

- The `WeatherData` class represents the weather details for a specific location.
- It contains properties for the location, temperature, and weather description.
- A constructor is provided to create a new `WeatherData` object with the specified properties.

## Running Tests Using Linux Command

To run the Weather API tests using the Linux command line, follow these steps:

1. Open a terminal and navigate to the root folder of the project.

2. Use Maven to build the project:

```
mvn clean install
```

3. Run the tests using the following command:

```
mvn test
```

The tests will execute, and the results will be displayed on the terminal.

## Running Tests Using Jenkins

To run the Weather API tests using Jenkins, follow these steps:

1. Open Jenkins and create a new Freestyle project.

2. In the project configuration, set up the following:

   - Specify the Git repository URL where the project is hosted.
   - Add a build step to execute a Maven build, specifying the goals as `clean install test`.

3. Save the configuration and run the Jenkins project. Jenkins will fetch the code, build the project, and execute the tests.

4. After the test execution, you can access the generated Cucumber JSON report for further analysis.

## Test Results
The test results are generated in a Cucumber JSON report, which can be found at `target/jsonReports/cucumber-report.json`. You can customize the reporting format and output by modifying the `CucumberOptions` in the `TestRunner` class.

---

