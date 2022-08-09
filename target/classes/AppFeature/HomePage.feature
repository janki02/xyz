Feature:  nopcommerce Home_Page Feature

Background: 
Given User has already Logged in to applicatioin
|Email|Password|
|admin@yourstore.com|admin|

Scenario: Home_Page Title
Given: User is on Home_Page
When user get title of the page
 Then  title should be "Dashboard / nopCommerce administration"
And nopcommerce Logo Should be displayed 

Scenario: Home_Page Link Count
Given User is on Home_Page  
Then User gets Dashboard Link
|Dashboard|
|Catalog|
|Sales  |
|Customers|
|Promotions|
|Content management|
|Configuration|
|System|
|Reports|
|Help|
And Dashboard Link Count Should be 10
And Logout







