Feature: Make my trip web page testing.

    Scenario: This is my Make my trip Validation Test Case
          Given Successfully Navigated to Make my trip Home Page
          When I enter all the valid data to search flights between destinations and click on submit
          |  Fields   |   Value     |
          |From       | Bengaluru   |
          |To         |  New Delhi  |
          Then It should list down all the flights available with fare filtered based on departure time