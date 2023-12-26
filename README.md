# FestivalApp

 This Java application simulates a festival gate system where attendees with different types of tickets enter the festival grounds. 

The program uses multiple threads to represent festival attendees and a statistics thread to generate statistics based on the tickets collected at the gate.

# Description

The application creates multiple FestivalAttendeeThread instances, each representing a person entering the festival with a randomly 
generated ticket type (FULL, FULL_VIP, FREE_PASS, ONE_DAY, ONE_DAY_VIP). These threads add ticket data to the FestivalGate, a shared resource representing the gate entrance.

Additionally, there's a FestivalStatisticsThread that generates statistics every 5 seconds based on the tickets collected in the gate. It counts the total number of people who entered and categorizes them by ticket types.

## Usage
To run the application:

## Clone this repository.
Open the project in your Java IDE.
Compile and run the FestivalApp.java file.
The application will simulate attendees entering the festival and generate statistics periodically.

## Customization
Adjust the number of attendees by modifying the loop in FestivalApp.java.
Tune the ticket types or add more functionalities by modifying the TicketType enum or respective thread classes.
## Contributing
Feel free to contribute by creating issues or pull requests to suggest improvements or new features.
