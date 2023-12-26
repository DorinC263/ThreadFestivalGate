package org.example;

public class Main
{
    public static void main( String[] args )
    {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
        statisticsThread.start();

        FestivalAttendeeThread[] attendees = new FestivalAttendeeThread[100];
        for(int i= 0; i <100;i++){
           attendees[i] = new FestivalAttendeeThread(gate);
            attendees[i].start();
        }
        for(FestivalAttendeeThread attendee: attendees){
            try {
                attendee.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        statisticsThread.stopThread();
    }
}
