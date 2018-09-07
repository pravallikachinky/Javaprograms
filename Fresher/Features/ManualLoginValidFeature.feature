Feature: valid login page feature
         User will be able to valid the username and password
@manual        
Scenario: user sign in to 'loginpage' using valid username and password
Given  user is on Loginpage
When user enter valid username and password      
Then user logins successfully 



@manual
Scenario: user sign in to 'loginpage' using invalid username and password
Given  user is on Loginpage
When user enter invalid username and password      
Then user login fails     