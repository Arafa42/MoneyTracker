package controller;
import database.DatabaseTickets;
import model.Ticket;
import register_entry.RegisterEntry;
import java.util.List;

public class TicketController implements ITicket{

    private DatabaseTickets database;
    public static Integer id = 0;

    public TicketController(DatabaseTickets database){ this.database = database; }

    @Override
    public void addTicket(Ticket t) {
        t.setId(id++);
        RegisterEntry registerEntry = new RegisterEntry(true);
        database.addEntry(t,registerEntry);
    }

    @Override
    public void removeTicket(Ticket t) {
        RegisterEntry registerEntry = new RegisterEntry(false);
        database.addEntry(t, registerEntry);
    }

    @Override
    public List<Ticket> getAllTickets() { return database.getAllTickets(); }

    @Override
    public List<Ticket> getAllTicketsSortedById() {
        return database.sortJsonArr();
    }

    @Override
    public void deleteTicketById(int id) {
        RegisterEntry registerEntry = new RegisterEntry(false);
        database.deleteTicketById(id,registerEntry);
    }

    @Override
    public String deleteAllTickets() {
        return database.deleteAllTickets();
    }


}
