Feature: Register Technical Functionality

  Scenario Outline: As a technical i want to register in SafeTechnology.
    Given I want to register as technical
    And I enter my own information like firstName <firstName>, lastName <lastName>, dni <dni>, email <email>, password <password>, address <address>, phone <phone>, birthday <birthday> and aboutMe <aboutMe>
    Then  I should be able to see my newly technical account

    Examples:
      | firstName | lastName   | dni        | email              | password    | address     | phone       | birthday     | aboutMe         |
      | "Jose"    | "Tarazona" | "72812255" | "string@gmail.com" | "stringasd" | "Av Brasil" | "123456789" | "28-04=2001" | "persona feliz" |