@all
Feature: This is dummy test scenario
  Scenario Outline: Eating
    Given There are <start> cucumbers
    When I eat <eat> cucumbers
    Then I should have <left> cucumbers

    Examples:
      | start | eat | left |
      |  12   |  5  |  7   |
      |  20   |  5  |  15  |
      |  30   |  5  |  25  |