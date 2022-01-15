package database;
import model.Ticket;
import register_entry.RegisterEntry;
import register_entry.RegisterEntryNull;
import java.util.*;

public class TicketsDB extends DatabaseTickets{
    private  HashMap<Ticket, RegisterEntry> database;
    private static TicketsDB singletonijn;

    public static TicketsDB getInstance(){
        if(singletonijn == null){ singletonijn = new TicketsDB(); }
        return singletonijn;
    }

    public TicketsDB() { this.database = new HashMap<>(); }

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

    @Override
    public List<Ticket> getAllTickets() {
        ArrayList<Ticket> ticketList = new ArrayList<Ticket>(database.keySet());
        return ticketList;
    }

    @Override
    public String deleteAllTickets() {
        this.database.clear();
        setChanged();
        notifyObservers();
        return "All tickets removed from DB";
    }

    @Override
    public void deleteTicketById(int id,RegisterEntry re) {
        List<Ticket> ticketList = sortJsonArr();
        ticketList.remove(id);
        database.clear();
        for (Ticket ticket : ticketList) {
            database.put(ticket, re);
        }
        setChanged();
        System.out.println("delete ticket : " + database.keySet());
    }

    @Override
    public List<Ticket> sortJsonArr() {
        ArrayList<Ticket> ticketList = new ArrayList<Ticket>(database.keySet());
        Comparator<Ticket> comparator = new Comparator<Ticket>() {
            @Override
            public int compare(Ticket o1, Ticket o2) {
                return o1.getId() - o2.getId();
            }
        };
        Collections.sort(ticketList, comparator);
        return ticketList;
    }

    @Override
    public void clear() {
        database.clear();
    }
}