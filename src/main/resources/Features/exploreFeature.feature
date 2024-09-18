Feature: Explore Feature test
  Scenario: Validate adding group
    Given I am logged in with username "nxttester" and password "nxt#qA@23"
    And I open "979befc7bce91522e28b" code Event
    And I click on content option
    And I click on Explore Option
    When I click on add a group button
    And I upload a "src/main/resources/data/test1.jpg" photo
    And I eneter the "Hearos" in the group title
    And I click on Save a group
    Then The group "Hearos" is added successfully
