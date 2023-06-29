Feature: Register User Functionality

  Scenario Outline: As a user i want to register in SafeTechnology.
    Given I want to register as user
    And I enter my own information like firstName <firstName>, lastName <lastName>, dni <dni>, email <email>, password <password>, address <address>, phone <phone> and birthday <birthday>
    Then I should be able to see my newly account

    Examples:
      | firstName | lastName | dni        | email              | password     | address       | phone       | birthday     |
      | "Debie"   | "Garcia" | "72028897" | "string@gmail.com" | "stringasdf" | "La Victoria" | "942121545" | "08-07-2000" |