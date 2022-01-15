package factory;

import model.Ticket;
import model.tickets.FlightTicket;

public class FlightTicketFactory implements ITicketFactory{
    @Override
    public Ticket getTicket(String name) {
        return new FlightTicket(name);
    }
}
