Feature: DataDriven operation on GitHub

  Scenario Outline: Creates a new repository for the authenticated user using DataDriven.
    Given Create a payload "<name>" and "<description>"
    When Send a post Request to create the repository
    Then the repository should be successfully created with HTTP status 201
    Then Verify the Repository name
    And  Verify the Repository description
    And  Verify the JSON Schema
    Examples:
      | name  | description       |
      | Repo1 | Repo1 Description |
      | Repo2 | Repo2 Description |

  Scenario Outline: Delete a repository for the authenticated user using DataDriven.
    Given Get the name of a repository "<name>"
    When Send a delete Request
    Then the repository should be successfully deleted and should be show the status 204 "HTTP/1.1 204 No Content"
    Then Verify the Repository body
    Examples:
      | name  |
      | Repo1 |
      | Repo2 |
