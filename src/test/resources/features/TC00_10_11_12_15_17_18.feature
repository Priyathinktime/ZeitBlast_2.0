
Feature: TC_18 Message send count in Market and Limit Module, and in the header should be correct

Scenario: 00 Change the Time Zone to UTC
Given the user turns on the server using valid credentials
    When the user sets the time zone to UTC on the server
    And the user turns off the server
 
Scenario Outline: 01 Delete all existing documents in MongoDB
    Given the user initializes the MongoDB connection
    When the user changes the value of initial message
    When the user deletes all existing documents from the collection
    Then no documents should exist in the collection
    When the user deletes documents with "<field_name>" equal to "<value>" from the "<collection_name>" collection
    Then those documents with "<field_name>" equal to "<value>" should no longer exist in the "<collection_name>" collection
    And the user closes the MongoDB connection
    Examples:
      | field_name | value              | collection_name                    |
      | name       | QA initial message | initialandfollowtemplates          |
   
   
Scenario: 02 Change the Time Zone to UTC
    Given the user turns on the server using valid credentials
    When the user sets the time zone to UTC on the server
    And the user turns off the server
     
 Scenario: 03 To upload an Excel in the Direct Import Page
    Given The user logs in the Zeitblast application with "super admin" credentials
     When The user navigate to the direct import page from the home page
    And The user upload the excel file "AutomationData100.xlsx" in the import file field
    And The user import the excel file by clicking the import button
    Then The excel file has to be imported
     When The User should be able to navigate the Templates page
   And The user click the create new button in the Templates page
   And The user enters the Template Name as "QA initial message" and selects the Template Type as "Pre-Foreclosure / Liens / Auction"
   And The user enters all the "initial" messages
   And The user saves the message templates
   Then The user should observe a success message confirming the message templates created successfully
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
     Then The User is navigated to the Inbox page
      Then The User should be able to navigate the Settings page
      And The initial message count in the header and the message count in the messages send today should be same
    And The user logs out from the Zeitblast application
   
Scenario: 06 Fetch the phone number & other details from MongoDB 
Given the user initializes the MongoDB connection
  When fetching the required data for phone 1
  Then the user closes the MongoDB connection

Scenario: 07 Trigger the Delivery Receipt API for phone no 1
  Given the Delivery API is triggered for phone no 1

Scenario: 08 Trigger the Send Message API for phone no 1
  Given the Send Message API is triggered for 50 leads for phone no 1
   Then delete the excelsheet 1

Scenario: 09 Validate the deliverability and response percentage in campaign and batches
  Given The user logs in the Zeitblast application with "super admin" credentials
  Then The User should be able to navigate the Batches page
  And The User grab the deliverability and response percentage from the batches page
  Then The User should be able to navigate the Campaigns page
  And The User grab the deliverability and response percentage from the Campaigns page
    Then The  deliverability and response percentage from the batches and Campaigns page should be same
   And The user logs out from the Zeitblast application
   
   Scenario: 10 Change the Time Zone to UTC
    Given the user turns on the server using valid credentials
    When the user sets the time zone to UTC on the server
    And the user turns off the server