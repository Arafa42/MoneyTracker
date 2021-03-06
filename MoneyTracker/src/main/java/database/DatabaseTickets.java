package database;
import model.Ticket;
import model.User;
import register_entry.RegisterEntry;
import java.util.List;
import java.util.Observable;

public abstract class DatabaseTickets extends Observable {
    public DatabaseTickets(){}
    public abstract void addEntry(Ticket ticket, RegisterEntry registerEntry);
    public abstract RegisterEntry getTicketEntry(Ticket ticket);
    public abstract List<Ticket> getAllTickets();
    public abstract String deleteAllTickets();
    public abstract void deleteTicketById(int id, RegisterEntry re);
    public abstract List<Ticket> sortJsonArr();
    public abstract void clear();
}
