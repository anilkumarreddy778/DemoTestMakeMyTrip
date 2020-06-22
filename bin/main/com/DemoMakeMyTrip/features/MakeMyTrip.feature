Feature: Verify the user is able to book the flight ticket.



@Registraton_actions
Scenario: Verify that user is able to Register

When Launch the browser and Navigate the URL
Then Click on the User Register button
Then Enter the the User info
And click on the Register button


@Login_Testing
Scenario: User need to verify the flight summary and total amount

When Launch the browser and Navigate the URL and Verify the Welcome Page
Then click on the Login button to enter username and password
Then Enter the Username and Password
And Click on the Login button
Then Select the one way option from the trip type
Then Select the Source and Destination
And Select the Departure Date
And Select the two passanger
And Click on the Search button.

Then click on the Sort filter and select the Low to high price

Then Validate Price is displying in the Sorted order
Then click on the Book now button
Then click on the Yes the Secure My trip radio button
And click on the continue button
Then Verify the Flight summary
And Verify the total amount is displaying