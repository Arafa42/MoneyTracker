package factory;

import model.Ticket;
import model.User;

import java.util.HashMap;

public interface ITicketFactory {
    Ticket getTicket(String name);
}
