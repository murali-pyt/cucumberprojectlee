Feature: Login action

Scenario Outline: Login Test scenario

Given User is on Homepage
When Title of homepage is Pickyourtrail
Then User enters Login
Then User enter "<mobile>"
Then User enters "<otp>"
Then User clicks Login
Then Checking all the logos are working or not


Examples:
   | mobile      |   | otp     |
   | 6383589200  |   | 666666  |