package org.example;

import java.util.Queue;

public class FestivalStatisticsThread extends Thread {
    private final FestivalGate gate;
    private boolean running = true;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(5000);
                generateStatistics();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void generateStatistics() {
        synchronized (gate) {
            Queue<TicketType> ticketQueue = gate.getTicketQueue();
            if (!ticketQueue.isEmpty()) {
                int totalPeople = ticketQueue.size();
                int fullCount = countTickets(ticketQueue, TicketType.FULL);
                int fullVIPCount = countTickets(ticketQueue, TicketType.FULL_VIP);
                int freePassCount = countTickets(ticketQueue, TicketType.FREE_PASS);
                int oneDayCount = countTickets(ticketQueue, TicketType.ONE_DAY);
                int oneDayVIPCount = countTickets(ticketQueue, TicketType.ONE_DAY_VIP);

                System.out.println(totalPeople + " people entered");
                System.out.println(fullCount + " have full tickets");
                System.out.println(fullVIPCount + " have full VIP tickets");
                System.out.println(freePassCount + " have free passes");
                System.out.println(oneDayCount + " have one day tickets");
                System.out.println(oneDayVIPCount + " have one day VIP tickets");
            }
        }
    }
    private int countTickets(Queue<TicketType> ticketQueue, TicketType type) {
        return (int) ticketQueue.stream()
                .filter(t -> t == type)
                .count();
    }

    public void stopThread() {
        running = false;
    }
}
