
  Feature: Login Feature test

    Scenario: verify when entering a valid username and a valid password then I will be logged in
      When I eneter "nxttester" in the username
      And I enter "nxt#qA@23" in the password text field
      And I click on the login button
      And I click on the Skip button
      Then I land on my Events page




