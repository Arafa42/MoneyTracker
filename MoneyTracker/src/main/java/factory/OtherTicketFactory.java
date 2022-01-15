package factory;
import model.Ticket;
import model.tickets.OtherTicket;

public class OtherTicketFactory implements ITicketFactory{
    @Override
    public Ticket getTicket(String name) {
        return new OtherTicket(name);
    }
}
