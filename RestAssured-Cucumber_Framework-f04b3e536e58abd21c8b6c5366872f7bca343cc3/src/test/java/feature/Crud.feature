Feature: CRUD operation on GitHub


  Scenario: Creates a new repository for the authenticated user using Pojo.
    Given Create a payload
    When Send a post Request to create the repository
    Then the repository should be successfully created with HTTP status 201
    Then Verify the Repository name
    And  Verify the Repository description
    And  Verify the JSON Schema

  Scenario: Delete a repository for the authenticated user.
    Given Get the endpoint of a repository
    When Send a delete Request
    Then the repository should be successfully deleted and should be show the status 204 "HTTP/1.1 204 No Content"
    Then Verify the Repository body




