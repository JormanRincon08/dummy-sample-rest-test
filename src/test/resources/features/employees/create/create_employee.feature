Feature: Create employee
  As a user,
  I want to create a employee record through the dummy api example services
  for save employee information

  @createEmployee
  Scenario: Successful create employee through dummy api example services
    Given that user wants to create a employee
    When he calls post create employee API service
    Then he validates status code create employee service is 200
    Then he validates schema create employee response "PostCreateSchemaEmployee"
    Then he validates fields post create response employee api
    Then he validates fields values post create response employee api