Feature: User must click on the Award Point and navigated to the Reddemed award points page

  Scenario: Validate navigation to utility page
    Given User is on landing page
    When Click on 'Utilities'
    Then Verify award points tab is available

  Scenario: Validate Tile "Award Points"in the Utilities dashboard
    When Click on Award points tile
    Then Validate Award points page
    
   Scenario: Validate the Redeem points  in the Award points dashboard.
    Given User is on redeem points page
    When Enter giftcard and amount to redeem
    Then Validate user is able to redeem points
 
  Scenario: Validate the navigation to the redeemed page
    When Navigated to the redeemed page
    Then Validate the redeemed page 