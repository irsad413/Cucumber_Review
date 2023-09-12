Feature: Google Search

  @googleSearch
  Scenario Outline: Google search for capital city of countries
    Given user is on google home page
    When user searches for "<country>" capital
    Then user should see "<capital>" result

    Examples:
      | country   | capital         |
      | USA       | Washington, DC |
      | Turkey    | Ankara          |
      | Japan     | Tokyo           |
      | France    | Paris           |
      | Germany   | Berlin          |
      | Argentina | Buenos Aires    |
      | Nigeria   | Abuja            |