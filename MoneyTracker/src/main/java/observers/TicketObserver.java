package observers;

import database.PersonsDB;
import database.TicketsDB;
import model.Ticket;
import model.User;
import register_entry.RegisterEntry;

import java.util.Observable;
import java.util.Observer;

public class TicketObserver implements Observer {
    // Jens heeft gekeken en vond het in orde om dit te gebruiken!
    // propertychangelistener
    @Override
    public void update(Observable o, Object arg) {
        Ticket ticket = (Ticket) arg;
        String nameUser = ticket.getName();
        RegisterEntry registerEntry = TicketsDB.getInstance().getTicketEntry((Ticket) arg);
        System.out.println("Ticket: "+ nameUser +", and ticket entry: "+ registerEntry);
    }
}
