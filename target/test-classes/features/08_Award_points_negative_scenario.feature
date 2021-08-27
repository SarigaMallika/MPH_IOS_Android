Feature: Validation on Award Points Page

  #User must click on the Award Point and navigated to the Redeemed award points page
  Scenario: Validate navigation to award points page
  
    Given user on home page
    When Navigated to home page
    And Click on Utilities tab and Award points tab
    Then validate Award points page
    
    Scenario: Verify the validation message on entering amount more than the available amount in "Redeem Award Points" page
    Given Click on redeem points button
    When Enter the amount more than available amount
    Then Validate the message on award points page

  
 Scenario: Validate the validation message on entering amount less than the available amount in "Redeem Award Points" page
    When Enter the amount less than the available amount
    Then Validate the message on award points page on less amount

  Scenario: Unable to click on the 'Redeem' button on leaving the field 'Select a gift card' blank"
    When Click the Redeem button on leaving the field Select a gift card blank
    Then Validate the error message displayed

  Scenario: Unable to click on the 'Redeem' button on leaving the field 'Enter Amount' blank on "Redeem Award Points" page
    When Click on the Redeem button on leaving the field Enter Amount blank
    Then Validate the message displayed