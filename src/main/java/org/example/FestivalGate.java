package org.example;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FestivalGate {
    private Queue<TicketType> ticketQueue = new ConcurrentLinkedQueue<>();

    public synchronized void addTicket(TicketType ticketType) {
        ticketQueue.add(ticketType);

    }
    public synchronized Queue<TicketType> getTicketQueue(){
        return ticketQueue;
    }
}
