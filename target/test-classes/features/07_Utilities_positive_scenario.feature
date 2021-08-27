Feature: Validation on Utilities page negative test cases

  #User should be able to click on the Utilities tab and able to use all the services under Utilities
  Scenario: Navigate to Utilities screen
    Given user is on home page
    When clicks on Utilities tab
    Then Navigate to Utilities Dashboard

  Scenario: Verify that click on all the Tiles in the Utilities dashboard
    When Click all tiles in utilities dashboard
    Then verify navigation to the pages

  Scenario: Add card details  in the Wallet dashboard
  Given user is on wallet page
    When Enter card details in wallet dashboard
    Then Verify card details is saved

  Scenario: Add bank details  in the Wallet dashboard
  Given user is on add bank details page
    When Enter bank details in wallet dashboard
    
  Scenario: Check deactivate tab 
    Given user is on settings page
    Then User should able to click on Deactivate tile

  