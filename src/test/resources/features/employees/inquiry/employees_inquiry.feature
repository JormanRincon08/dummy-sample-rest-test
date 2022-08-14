Feature: Employees inquiry
  As a user,
  I want to search the information of all the employees through the dummy api example services.

  @getAllEmployees
  Scenario: Successful employees inquiry through dummy api example services
    Given that user wants to list all employees
    When he calls get employees API service
    Then he validates status code service 200
    Then he validates quantity data employees is 24
    Then he validates schema employees response "GetSchemaEmployees"
    Then he validates fields get response employees api