Feature: Google search feature
         Using this feature user can search any kind of relevant information
@google
Scenario: User want to search information about 'Agile Methodology' by entering valid set of word
Given User is on google home page
When User searches for 'Agile Methodology' term
Then All pages linked with 'Agile Methodology' should be displayed          