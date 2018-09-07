Feature: Github Account Creation Feature

@create
Scenario: User wants to create an github account using valid Details
Given user has to be on signin page of github
When user enters valid emailid, username, password
Then Github account should be created for user

@create
Scenario: user wants to create an account using invalid details
Given user has to be on signin page of github
When user enters invalid emailid, valid username, password
Then Github account should not be created for user

@create
Scenario: user wants to create an account using invalid details
Given user has to be on signin page of github
When user enters invalid username, valid emailid, password
Then Github account should not be created for user because of email

@create
Scenario: user wants to create an account using invalid details
Given user has to be on signin page of github
When user enters invalid password, valid emailid, username
Then Github account should not be created for user because of password



@create
Scenario: user wants to create an account using invalid details of password
Given user has to be on signin page of github
Given user enters invalid password with no number
Then Github account should not be created beacuse of no numbers