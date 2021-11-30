package factory;

import model.Ticket;
import model.User;
import model.tickets.CinemaTicket;

import java.util.HashMap;

public class CinemaTicketFactory implements ITicketFactory{

    @Override
    public Ticket getTicket(String name) {
        return new CinemaTicket(name);
    }

}
