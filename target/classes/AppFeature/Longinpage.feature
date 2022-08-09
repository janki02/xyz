Feature:  nopcommerce Longin Feature

Scenario: Login Page Title
    
   Given  user is on longin page
   When user get title of the page
   Then  title should be "Your store. Login"
   
  Scenario: Remember me CheckBox 
   Given  user is on longin page
   Then  Remember me CheckBox should be displayed
   
   Scenario: Login with Valid Cresentials
    Given  user is on longin page
   When  user enter the Email  " admin@yourstore.com" 
   And   user enter the Password "admin"
   And user click longin button
   When user get title of the page 
   Then homePage title should be "Dashboard / nopCommerce administration"


  
