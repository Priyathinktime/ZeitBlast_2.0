@leadrespondtodripmessage
@entiretest

Feature: TC_26 If lead respond to drip message it status should move to no status

Scenario: 00 Change the Time Zone to UTC
Given the user turns on the server using valid credentials
    When the user sets the time zone to UTC on the server
    And the user turns off the server
 
Scenario: 01 Delete all existing documents in MongoDB
    Given the user initializes the MongoDB connection
    #When the user changes the value of initial message
    When the user deletes all existing documents from the collection
    Then no documents should exist in the collection
    And the user closes the MongoDB connection
   
Scenario: 02 Change the Time Zone to UTC
    Given the user turns on the server using valid credentials
    When the user sets the time zone to UTC on the server
    And the user turns off the server
     
 Scenario: 03 To upload an Excel in the Direct Import Page
    Given The user logs in the Zeitblast application with "super admin" credentials
    When The user navigate to the direct import page from the home page
    And The user upload the excel file "testingdata01.xlsx" in the import file field
    And The user import the excel file by clicking the import button
    Then The excel file has to be imported
    And The user logs out from the Zeitblast application

Scenario: 04 Changing the Time Zone to market hours (8:00 AM EST)
  Given the user turns on the server using valid credentials
  When the EST timing is adjusted for today
    Then the user turns off the server
    
Scenario: 05 To Send Message to the Prospects
 Given The user logs in the Zeitblast application with "super admin" credentials
   When The user creates a new market
     Then The user should observe a success message confirming the creation of the new market
     And The user adds an outbound number in the existing market
    Then The user should observe a success message confirming the outbound number is added 
    And The user creates a new campaign and enters the campaign name and selects the market 
    Then The user should observe a success message confirming the creation of the new campaign
    And The user assigns the prospects to the created campaign in the direct import page
    Then The user should observe a success message confirming the prospects assigned to the campaign
    And The user creates a batch by selecting the campaign, choosing the message template, and adding the batch size
    And The user sends a message to the prospects who were added in the batch
    And The user logs out from the Zeitblast application
   
Scenario: 06 Fetch the phone number & other details from MongoDB 
Given the user initializes the MongoDB connection
  When fetching the required data for phone 1
  Then the user closes the MongoDB connection

Scenario: 07 Trigger the Delivery Receipt API for phone no 1
  Given the Delivery API is triggered for phone no 1

Scenario: 08 Trigger the Send Message API for phone no 1
  Given the Send Message API is triggered for 50 leads for phone no 1

Scenario: 09 Verify phone1 for the first 30 leads 
  Given the user initializes the MongoDB connection
  When assigning phone 1 leads as verified
  Then delete the excelsheet 1
  Then the user closes the MongoDB connection

Scenario: 10 Assign Drip automation for single lead
 Given The user logs in the Zeitblast application with "super admin" credentials
  When The User should be able to navigate the Inbox page
  Then The User should select the single leads to send the Drips
   And The user logs out from the Zeitblast application
  
Scenario: 11 Change the drip 1 date as current date in MongoDB
Given the user initializes the MongoDB connection
When change the date in drip first automation for today  
  Then the user closes the MongoDB connection
  
Scenario: 12 Verify the first drip is assigned to the lead
 Given The user logs in the Zeitblast application with "super admin" credentials
  When The User should be able to navigate the Inbox page
  Then  The user should observe the first drip assigned to the lead 
   And The user logs out from the Zeitblast application
  
Scenario: 13 Trigger the Send Message API for phone no 31021000001
  Given the Send Message API is triggered for the leads for phone no "31021000001"
  
Scenario: 14 Validate no more drips should be assigned 
 Given The user logs in the Zeitblast application with "super admin" credentials
  When The User should be able to navigate the Inbox page
  Then  The user should observe no drip assigned for the lead
   And The user logs out from the Zeitblast application

Scenario: 15 Change the Time Zone to UTC
    Given the user turns on the server using valid credentials
    When the user sets the time zone to UTC on the server
    And the user turns off the server
 