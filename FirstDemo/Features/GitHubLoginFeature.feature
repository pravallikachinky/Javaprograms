Feature: Github Login feature
         Using this feature user will login to github account

Background: User already has an account in Github  
@execute
Scenario: User wants to Sign in to 'Github account' using valid username and password
Given user is on the homepage of 'Github'
When user enters valid login credentials
Then user should login to 'Github account'

@execute
Scenario: User wants to Sign in to 'Github account' using invalid username and password
Given user is on the homepage of 'Github'
When user enters invalid login credentials
Then user shouldnot login to 'Github account'         