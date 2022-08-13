Feature: Consulta de datos básicos
As a user,
I want to search the information of all the employees through the dummy api example services.

@getAllEmployees
Scenario: Successful employees inquiry through dummy api example services
Given user
When call get employees API service
Then validate status code service 200
Then validate quantity data employees is 230
Then validate fields get response api