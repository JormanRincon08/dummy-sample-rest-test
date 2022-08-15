Feature: Employee inquiry
  As a user,
  I want to search the information of specific employee through the dummy api example services
  for list the employee information

  @getEmployee
  Scenario: Successful employee inquiry through dummy api example services
    Given that user wants to list employee information with id
      | 21 |
    When he calls get employee API service
    Then he validates status code get employee service is 200
    Then he validates schema employee response "GetSchemaEmployee"
    Then he validates fields get response employee api
    Then he validates fields values get response employee api