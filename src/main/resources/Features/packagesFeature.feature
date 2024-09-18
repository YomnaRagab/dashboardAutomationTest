Feature: Packages Feature test

  Scenario: verify when entering a valid date then a new package will be generated
    Given I am logged in with username "nxttester" and password "nxt#qA@23"
    And I open "ef5d97ef91afda35453a" code Event
    And I click on planning option
    And I choose Packages option
    And I click on add a new package button
    When I enter "Test" in the package title
    And I enter "1" in the priority
    And I choose the "2" in Feature Icon
    And I enter "Flights" in the Feature name
    And I choose "Text Add" in the Type menu
    And I click on Save package
    Then The new "Test" package is generated

    Scenario: verify when trying to edit the existing package then it will be updated
      Given I am logged in with username "nxttester" and password "nxt#qA@23"
      And I open "ef5d97ef91afda35453a" code Event
      And I click on planning option
      And I choose Packages option
      And I click on edit "Test" package
      When I enter "gold" in the package title
      And I click on Update button
      Then The "gold" package is updated
Scenario: verify when trying to delete the package then it will be deleted
  Given I am logged in with username "nxttester" and password "nxt#qA@23"
  And I open "ef5d97ef91afda35453a" code Event
  And I click on planning option
  And I choose Packages option
  And I click on edit "Test" package
  When I click on delete package button
  And I confrim the delete
  Then The "Test" package will be deleted

