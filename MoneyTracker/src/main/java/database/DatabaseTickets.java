package database;

import model.Ticket;
import register_entry.RegisterEntry;

import java.util.Observable;

public abstract class DatabaseTickets extends Observable {

    public DatabaseTickets(){}
    public abstract void addEntry(Ticket ticket, RegisterEntry registerEntry);
    public abstract RegisterEntry getTicketEntry(Ticket ticket);

}
