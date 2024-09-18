Feature: New Event Feature test

  Scenario: verify when entering valid data in add event page then the event will be created
    Given I am logged in with username "nxttester" and password "nxt#qA@23"
    When I click on New Event button
    And I click on Start from scratch Card
    And I enter "Testing5050" in Event Name
    And I enter "Meeting" in Event Type
    And I enter "Testing5050" in Event Slung
    And I enter "01/01/2024" in Start Date
    And I enter "01:01am" in Start Time
    And I enter "01/01/2025" in End Date
    And I enter "01:00am" in End Time
    And I enter "(UTC-05:00) Eastern Time (US & Canada)" in Timezone
    And I enter "10" in Latitude
    And I enter "10" in Longitude
    And I click on create for the event
    Then The "Testing5050" event should be created successfully


