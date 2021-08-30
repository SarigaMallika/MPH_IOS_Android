Feature: User should be able to click on the Utilities tab and able to use all the services under Utilities

  Scenario: Validate the navigation to Utilities screen
    When Open the app in IOS
    Then Clicks on Utilities tab

  Scenario: Validate the message on leaving fields blank in the Add Card page
    When Click on utilities wallet
    Then click on add card
    And Validate message on leaving fields blank

  Scenario: Validate the message on entering invalid details in the Add Card page
    When Enter invalid details in the Add Card page
    Then Validate message on entering invalid details on add card page

  Scenario: Validate message on leaving fields blank in the Add Bank page
    When Click on add bank
    Then Leave fields blank in the Add Bank page
    And Validate message on leaving fields blank in Add Bank page

  Scenario: Validate message on entering invalid details in the Add Bank page
    When Enter invalid details in the Add Bank page
    Then Validate message on entering invalid details in Add Bank page

  Scenario: Validate award points page
    When Click on award points
    Then Verify the award points page

    Scenario: Validate ID card
      When Click on ID card
      Then Verify the ID card page

      Scenario: Validate Upload
        When Click on Upload
        Then Verify Upload
