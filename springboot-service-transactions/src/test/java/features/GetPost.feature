Feature:
   Verify different GET operations using REST-assured
   
   Scenario: Verify one operation of the post
   Given: A transaction that is not stored in our system
   When: I check the status from any channel
   Then: The system returns the status 'INVALID'