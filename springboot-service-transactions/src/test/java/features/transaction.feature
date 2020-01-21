Feature: Create Transaction



  Scenario: WITH ALL REQUIRED FIELDS IS SUCCESSFUL



    Given user wants to create an transaction with the following attributes

      | id  | reference | ammount | create_at | account | fee | description |

      | 1 | 12225A | 193.38  | NOW() | 2342334 | 3.18 | Restaurant payment |
      | 2 | 12223435A | 13.38  | NOW() | 2342334 | 3.18 | Cine payment |


    When user saves the new transaction 'WITH ALL REQUIRED FIELDS'

    Then the save 'IS SUCCESSFUL'