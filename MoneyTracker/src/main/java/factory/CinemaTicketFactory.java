package factory;
import model.Ticket;
import model.tickets.CinemaTicket;

public class CinemaTicketFactory implements ITicketFactory{

    @Override
    public Ticket getTicket(String name) {
        return new CinemaTicket(name);
    }

}
