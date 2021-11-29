package database;

import model.Ticket;
import register_entry.RegisterEntry;
import register_entry.RegisterEntryNull;

import java.util.HashMap;

public class TicketsDB extends DatabaseTickets{
    private HashMap<Ticket, RegisterEntry> database;
    private static TicketsDB singletonijn;

    public static TicketsDB getInstance(){
        if(singletonijn == null){
            singletonijn = new TicketsDB();
        }
        return singletonijn;
    }


    @Override
    public void addEntry(Ticket ticket, RegisterEntry registerEntry) {
        this.database.put(ticket,registerEntry);
        setChanged();
        notifyObservers();
    }

    @Override
    public RegisterEntry getTicketEntry(Ticket ticket) {
        return this.database.getOrDefault(ticket, new RegisterEntryNull());
    }
}
