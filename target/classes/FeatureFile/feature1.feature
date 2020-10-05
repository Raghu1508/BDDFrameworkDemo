Feature: Check Google Website

 
  Scenario: Check weather the google search is working
    Given Launch Chrome Browser 
    When Navigate to Google
    And Search for facebook
    Then Result displays facebook
