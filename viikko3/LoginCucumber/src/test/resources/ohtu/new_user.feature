Feature: A new user account can be created if a proper unused username and password are given

  Scenario: creation is successful with valid username and password
    Given command new is selected
    When  username "eero" and password "salainen1" are entered
    Then  the system will respond with "new user registered"

  Scenario: creation fails with already taken username and valid password
    Given command new is selected
    When  "eero" and password "lodwdwwd1l" are entered
    Given command new is selected
    When  "eero" and password "lodwdwwd1l" are entered
    Then  the system will respond with "new user not registered"

  Scenario: creation fails with too short username and valid password
    Given command new is selected
    When  "aa" and "memeeheh1he" are entered
    Then  the system will respond with "username too short"

  Scenario: creation fails with valid username and too short password
    Given command new is selected
    When  "oeioeiroe" and shortP "uuu1u" are entered
    Then  the system will respond with "password is too short"

  Scenario: creation fails with valid username and password long enough but consisting of only letters
    Given command new is selected
    When  "meh" and Numbers0 P "meeehehehe" are entered
    Then  the system will respond with "password consists only of letters"

  Scenario: can login with successfully generated account
    Given user "eero" with password "salainen1" is created
    And   command login is selected
    When  user "eero" with password "salainen1" are entered
    Then  the system will respond with "logged in"