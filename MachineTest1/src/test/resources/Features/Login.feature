Feature: Login and Customer Addition Journey

  Scenario: Automate login with valid credentials
    Given I navigate to the login page
    When I enter valid username "user123" and password "password123"
    Then I should be logged in successfully

  Scenario: Verify Toast/Popup after PunchIn
    Given I am logged in
    When I perform PunchIn
    Then I should see a toast message "PunchIn successful"

  Scenario: Add a Customer
    Given I am logged in
    When I add a customer with name "John Doe" and email "john.doe@example.com"
    Then the customer should be added successfully

