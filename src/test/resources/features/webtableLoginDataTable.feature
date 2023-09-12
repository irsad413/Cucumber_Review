Feature: Webtable application login with data table
  User Story: User should be able to login webtable application

  @webtableLoginDataTable
  Scenario: login webtable app with using datatable
    Given user is on the login page og webtable app
    When user enter below credentials
      | username | Test   |
      | password | Tester |
    Then user should see url contains orders