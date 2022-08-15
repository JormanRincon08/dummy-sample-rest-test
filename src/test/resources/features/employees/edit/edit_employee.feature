Feature: Edit employee
  As a user,
  I want to edit a employee record information through the dummy api example services
  for update employee information

  @editEmployee
  Scenario Outline: Successful edit employee information through dummy api example services
    Given that user wants to edit information a employee with the following information
      | <id> | <name> | <salary> | <age> | <profile_image> |
    When he calls put edit employee API service
    Then he validates status code edit employee service is 200
    Then he validates schema edit employee response "PutEditSchemaEmployee"
    Then he validates fields put edit response employee api
    Then he validates fields values put edit response employee api
    Examples:
      | id | name          | salary  | age | profile_image                                                     |
      | 21 | Jorman Rincon | 96810.0 | 28  | https://s3.amazonaws.com/uifaces/faces/twitter/souperphly/128.jpg |