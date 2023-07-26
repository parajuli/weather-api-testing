Feature: Weather API Testing

  Scenario: Get current weather data by latitude and longitude
    Given I have an API key
    When I get the current weather data by latitude "<lat>" and longitude "<lon>"
    Then I should see the weather details for that location

Examples:
  | lat    | lon    |
  | -40.98 | -74.60 |
  | 33.86  | 151.20 |
  | -30.65 | 32.77  |

  Scenario: Get current weather data by postal code
    Given I have an API key
    When I get the current weather data by postal code "<post_code>"
    Then I should see the weather details for that location

Examples:
  | post_code |
  | 10001     |
  | 43283     |
  | 54321     |