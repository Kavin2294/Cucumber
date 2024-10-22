Feature: Add opportunity to Salesforce.com

Scenario: Add opportunity to salesforce and verify the opportunity name

Given Launch the browser and load the url
When Enter the username as 'dilip@testleaf.com'
And Enter the password as 'leaf@2024'
And Click on login button
Then Salesforce home page should be displayed
When Click on toggle button
And Click on View all
And Select Sales from the App Launcher.
And Click on the Opportunity tab
And Click on the New button.
Then New Opportunity page should be displayed
When Enter the Opportunity name as 'Salesforce Automation by Kavin'.
And  Enter Amount as 75,000
And Choose the close date as Today.
And Select Stage as Need Analysis.
And Click on the Save button and verify the Opportunity Name.
Then Opportunity name should be displayed