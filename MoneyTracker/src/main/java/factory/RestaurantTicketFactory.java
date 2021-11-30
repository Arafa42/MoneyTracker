package factory;

import model.Ticket;
import model.User;
import model.tickets.RestaurantTicket;

import java.util.HashMap;

public class RestaurantTicketFactory implements ITicketFactory{
    @Override
    public Ticket getTicket(String name) {
        return new RestaurantTicket(name);
    }
}
