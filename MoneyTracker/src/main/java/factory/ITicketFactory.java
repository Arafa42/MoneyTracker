package factory;
import model.Ticket;

public interface ITicketFactory {
    Ticket getTicket(String name);
}
