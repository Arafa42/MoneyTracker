package factory;

import model.Ticket;
import model.tickets.ConcertTicket;

public class ConcertTicketFactory implements ITicketFactory{
    @Override
    public Ticket getTicket(String name) {
        return new ConcertTicket(name);
    }
}
