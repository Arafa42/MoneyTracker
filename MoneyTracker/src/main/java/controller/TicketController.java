package controller;
import database.DatabaseTickets;
import model.Ticket;
import register_entry.RegisterEntry;
import java.util.List;

public class TicketController implements ITicket{

    private DatabaseTickets database;

    public TicketController(DatabaseTickets database){ this.database = database; }

    @Override
    public void addTicket(Ticket t) {
        RegisterEntry registerEntry = new RegisterEntry(true);
        database.addEntry(t,registerEntry);
    }

    @Override
    public void removeTicket(Ticket t) {
        RegisterEntry registerEntry = new RegisterEntry(false);
        database.addEntry(t, registerEntry);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return database.getAllTickets();
    }


}
