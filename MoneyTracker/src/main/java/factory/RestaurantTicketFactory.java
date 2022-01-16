package factory;
import model.Ticket;
import model.tickets.RestaurantTicket;

public class RestaurantTicketFactory implements ITicketFactory{
    @Override
    public Ticket getTicket(String name) {
        return new RestaurantTicket(name);
    }
}
