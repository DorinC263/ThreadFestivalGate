package org.example;

import java.util.Random;

public class FestivalAttendeeThread extends Thread{
    private FestivalGate gate;
    private Random random = new Random();

    public FestivalAttendeeThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        TicketType ticketType = generateRandomTicket();
        synchronized (gate){
            gate.addTicket(ticketType);
        }
    }
    private TicketType generateRandomTicket(){
        TicketType[] ticketTypes = TicketType.values();
        return ticketTypes[random.nextInt(ticketTypes.length)];
    }

}
