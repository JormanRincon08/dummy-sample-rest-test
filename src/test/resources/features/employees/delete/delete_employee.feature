Feature: Delete employee
  As a user,
  I want to delete a employee information through the dummy api example services
  for remove obsolete employee information

  @deleteEmployee
  Scenario: Successful delete employee information through dummy api example services
    Given that "user" wants to delete employee information by id "2"
    When he calls delete employee API service
    Then he validates status code delete employee service is 200
    Then he validates schema delete employee response "DeleteSchemaEmployee"
    Then he validates fields delete response employee api
    Then he validates fields values delete response employee api