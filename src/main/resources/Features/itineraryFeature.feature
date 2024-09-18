Feature: itinerary Feature test
  Scenario: Adding an event
    Given I am logged in with username "nxttester" and password "nxt#qA@23"
    And I open "a8fd7896f6785be9a957" code Event
    And I click on content option
    And I click on itinerary option
    #date must be month then day
    And I choose the date "November" "10"
    #time must be in 24hours format
    And I select  the start time "03:00" and the end time "04:00"
    And I upload a "src/main/resources/data/test2.jpg" cover image
    And I enter the "Meeting" in activity title
    And I click on save the activity
    Then I see the "Meeting" activity is created

    Scenario: Editing the event title
      Given I am logged in with username "nxttester" and password "nxt#qA@23"
      And I open "a8fd7896f6785be9a957" code Event
      And I click on content option
      And I click on itinerary option
      And I open the "Edit" event in "September" "24"
      When I update the activity title by "Conference"
      And I click on the update button
      Then I see "Conference" activity is updated

      Scenario: Deleteing an event
        Given I am logged in with username "nxttester" and password "nxt#qA@23"
        And I open "a8fd7896f6785be9a957" code Event
        And I click on content option
        And I click on itinerary option
        And I open the "Edit" event in "September" "24"
        When I click on delete icon
        And I confrim the deletion
        Then The "Edit" event is deleted

